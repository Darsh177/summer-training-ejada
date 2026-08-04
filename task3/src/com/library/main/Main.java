package com.library.main;
import com.library.exceptions.NotFound;
import com.library.models.Book;
import com.library.models.Category;
import com.library.models.Item;
import com.library.models.Magazine;
import com.library.models.Record;
import com.library.services.FindTitle;
import com.library.services.LibraryService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        var libraryService = new LibraryService();
        var scanner = new Scanner(System.in);

        libraryService.addItem( new Book(1,"seven rooms" , Category.FICTION, "Moustafa"));
        libraryService.addItem(new Book(2,"the ghost" , Category.FICTION,"ahmed"));
        libraryService.addItem(new Book(3,"family" , Category.SCIENCE,"sobhy"));
        libraryService.addItem(new Magazine(4,"the nightmare" ,Category.HISTORY, 25));
        libraryService.addItem(new Magazine(5,"spider man" ,Category.COMIC, 75));


        System.out.println("\n\nTotal books created : " + Item.getItemCounter() + "\n");

        System.out.println("the list of the book");
        for(Item item : libraryService.getAllItems()){
            item.printDetails();
        }

        System.out.println("\n\n");

        System.out.println("search for the word ghost in the titles");
        var searchResult = libraryService.searchBytitle("ghost");
        searchResult.forEach(Item::printDetails);



        System.out.println("\n\nitem sorted alphabetic");
        libraryService.getItemsSortedByTitle().forEach(Item::printDetails);

        var totalChars = libraryService.getTotaltitleCharacterLength();
        System.out.println("\n\n the total words for the item title" + totalChars + " word");

        var borrowRecord =new Record(101 , "Ali Hassan" , 2 , LocalDate.now());
        System.out.println("\nborrower: " + borrowRecord.userName() + "date : " + borrowRecord.borrowDate());


        System.out.println("\n\nnow try to search manually");
        try {
            System.out.println("enter the id to search with Id");
            var searchId = scanner.nextInt();

            var foundItem =libraryService.findById(searchId);
            foundItem.printDetails();

        }
        catch (NotFound e){
            System.err.println("error " + e.getMessage());
        }
        catch (Exception e){
            System.err.println("please enter a validate number");
        }finally {
            scanner.close();
            System.out.println("thank you");
        }


    }
}