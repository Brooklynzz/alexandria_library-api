package com.alexandria.Alexandria.Library.entities.book;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "books")
@Entity(name = "Book")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String isbn;
    private String genre;
    private String author;

    public Book(BookRegister data) {
        this.name = data.name();
        this.isbn = data.isbn();
        this.genre = data.genre();
        this.author = data.author();
    }

    public void updateData(BookUpdate data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.isbn() != null) {
            this.isbn = data.isbn();
        }
        if (data.genre() != null) {
            this.genre = data.genre();
        }
        if (data.author() != null) {
            this.author = data.author();
        }
    }
}
