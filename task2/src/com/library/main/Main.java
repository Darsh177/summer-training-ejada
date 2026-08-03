package com.library.main;
import com.library.models.Book;
import com.library.models.Item;
import com.library.models.Magazine;
import com.library.services.findTitle;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {


        List<Item> library = new ArrayList<>();
        library.add( new Book(1,"seven rooms" , "Moustafa"));
        library.add(new Book(2,"the ghost" , "ahmed"));
        library.add(new Book(3,"family" , "sobhy"));
        library.add(new Magazine(4,"the nightmare" , 25));
        library.add(new Magazine(5,"spider man" , 75));


        System.out.println("Total books created : " + Item.getItemCounter() + "\n");

        System.out.println("the list of the book");
        for(Item item : library){
            item.printDetails();
        }

        System.out.println("\n\n");

        findTitle javaFilter = title -> title.contains("seven");

        for (Item item : library){
            if(javaFilter.test(item.getTitle())){
                System.out.println("found it : ");
                item.printDetails();
            }
        }

    }
}