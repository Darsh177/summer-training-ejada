package com.library.services;

import com.library.exceptions.NotFound;
import com.library.models.Item;

import java.util.*;
import java.util.stream.Collectors;

public class LibraryService {

    private List<Item> itemList = new ArrayList<>();

    private Map<Integer , Item> itemMap = new HashMap<>();

    private Set<String> uniqeTitls = new HashSet<>();

    public void  addItem(Item item){
        itemList.add(item);
        itemMap.put(item.getId(),item);
        uniqeTitls.add(item.getTitle().toLowerCase());
    }

    public Item findById(int id) throws NotFound{
        if(!itemMap.containsKey(id)){
            throw new NotFound("the item with this " + id + "is not in the library");
        }
        return itemMap.get(id);
    }

    public List<Item> searchBytitle(String title){
        return itemList.stream().filter(item -> item.getTitle().toLowerCase().
                contains(title.toLowerCase())).
                collect(Collectors.toList());
    }

    public List<Item> getItemsSortedByTitle(){
        return itemList.stream().sorted().collect(Collectors.toList());
    }

    public List<Item> getItemsSortedByIdDescending(){
        return itemList.stream().sorted(Comparator.comparingInt(Item::getId).reversed())
                .collect(Collectors.toList());
    }

    public int getTotaltitleCharacterLength(){
        return itemList.stream().map(Item::getTitle).map(String::length).reduce(0,Integer::sum);
    }

    public Set<String> getUniqeTitls(){
        return uniqeTitls;
    }

    public List<Item> getAllItems(){
        return itemList;
    }
}
