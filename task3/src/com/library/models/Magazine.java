package com.library.models;

public class Magazine extends Item{
    private int issueNumber;

    public Magazine(int id , String title ,Category category, int issueNumber){
        super(id , title, category);
        this.issueNumber =issueNumber;
    }

    @Override
    public void printDetails(){
        System.out.println("Magazine Id : " +getId() + "\n Title: " + getTitle() + "\n Issue : " +issueNumber);
    }
}
