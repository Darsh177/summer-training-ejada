package com.library.models;

public  abstract class Item implements Comparable<Item> {
    private int id;
    private String title;
    private Category category;
    private static int itemCounter = 0;

    public Item(int id, String title, Category category) {
        this.id = id;
        this.title = title;
        this.category = this.category;
        itemCounter++;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public static int getItemCounter() {
        return itemCounter;
    }

    public Category getCategory() {
        return category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract void printDetails();

    @Override
    public int compareTo(Item other){
        return title.compareToIgnoreCase(title);
    }

    @Override
    public String toString(){
        return "ID : " + id + "Title : " + title + "Category" + category;
    }
}
