package com.library.models;

public class Item {
    private int id;
    private String title;
    private static int itemCounter = 0;

    public Item(int id, String title) {
        this.id = id;
        this.title = title;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void printDetails(){
        System.out.println("ID : " + id + ", Title: " + title);
    }
}
