package com.example.demo.controllers;

import com.example.demo.models.Book;
import com.example.demo.repos.DAO;
import com.example.demo.models.Message;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// CRUD = Create, read, update, delete

@RestController
public class BookController {

    DAO db = new DAO();
    List<Book> myBooks = db.getAllBooks();


    @RequestMapping("/books")
    public List<Book> books(){
        return myBooks;
    }

    @RequestMapping("/book/{id}")
    public Book bookById(@PathVariable int id){
        for (Book b:myBooks) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    @RequestMapping("/book/{id}/delete")
    public String deleteBookById(@PathVariable int id){
        int indexToRemove = -1;

        for (int i = 0; i < myBooks.size(); i++) {
            if (myBooks.get(i).getId() == id){
                indexToRemove = i;
            }
        }

        myBooks.remove(indexToRemove);
        return "Boken med id " + id + " är borttagen";
    }

    // Lektion 2
    @PostMapping("book/add")
    public String addBook(@RequestBody Book b){
        myBooks.add(b);
        return "Book added";
    }

    @PostMapping("book/upsert")
    public Message upsertBook(@RequestBody Book b){
        int indexToUpdate = -1;
        for (int i = 0; i < myBooks.size(); i++) {
            if (myBooks.get(i).getId() == b.getId()){
                indexToUpdate = i;
            }
        }
        if (indexToUpdate == -1){
            myBooks.add(b);
            Message m = new Message(true, "Book was created");
            return m;
        } else {
            myBooks.set(indexToUpdate, b);
            Message m = new Message(true, "Book was updated");
            return m;
        }
    }
}
