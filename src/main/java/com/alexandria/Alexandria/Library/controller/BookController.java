package com.alexandria.Alexandria.Library.controller;

import com.alexandria.Alexandria.Library.entities.book.*;
import com.alexandria.Alexandria.Library.exceptions.BookNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
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

    @PutMapping
    @Transactional
    public ResponseEntity<String> update(@RequestBody @Validated BookUpdate data) {
        try {
            var book = repository.getReferenceById(data.id());
            book.updateData(data);
            return ResponseEntity.status(HttpStatus.OK).body("Livro atualizado!");
        } catch (EntityNotFoundException e) {
            System.out.println("Erro: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado para o ID fornecido, ID: " + data.id());
        }
    }
}
