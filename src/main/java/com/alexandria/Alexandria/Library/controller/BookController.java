package com.alexandria.Alexandria.Library.controller;

import com.alexandria.Alexandria.Library.entities.book.Book;
import com.alexandria.Alexandria.Library.entities.book.BookList;
import com.alexandria.Alexandria.Library.entities.book.BookRegister;
import com.alexandria.Alexandria.Library.entities.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookRepository repository;

    @GetMapping
    public List<BookList> listBooks() {
        return repository.findAll().stream().map(BookList::new).toList();
    }

    @PostMapping
    @Transactional
    public void bookRegister(@RequestBody BookRegister data) {
        repository.save(new Book(data));
    }
}
