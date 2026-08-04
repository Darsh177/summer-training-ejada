package com.library.models;

public class Book extends Item{

    private String author;

    public Book(int id, String title ,Category category, String author) {
        super(id, title ,category );
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }


    @Override
    public void printDetails(){
        System.out.println("Book Id: " + getId() + " \n Title: " + getTitle() + " \n Author: " + author);
    }
}
