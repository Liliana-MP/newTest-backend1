package com.example.demo.repos;

import com.example.demo.models.Book;

import java.util.LinkedList;
import java.util.List;

public class DAO {

    public List<Book> getAllBooks(){
        Book b1 = new Book(1, "bajs1", "valle1");
        Book b2 = new Book(2, "bajs2", "valle2");
        Book b3 = new Book(3, "bajs3", "valle3");
        Book b4 = new Book(4, "bajs4", "valle4");
        Book b5 = new Book(5, "bajs5", "valle5");

        List<Book> bookList = new LinkedList<>();
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
        bookList.add(b4);
        bookList.add(b5);



        return bookList;

    }
}
