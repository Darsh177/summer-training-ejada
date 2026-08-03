package com.library.models;

public class Book extends Item{

    private String author;

    public Book(int id, String title , String author) {
        super(id, title);
        this.author = author;
    }

    @Override
    public void printDetails(){
        System.out.println("Book Id: " + getId() + " \n Title: " + getTitle() + " \n Author: " + author);
    }
}
