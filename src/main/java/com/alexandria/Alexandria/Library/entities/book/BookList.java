package com.alexandria.Alexandria.Library.entities.book;

public record BookList(
        Long id,
        String name,
        String isbn,
        String genre,
        String author
) {
    public BookList(Book book) {
        this(book.getId(), book.getName(), book.getIsbn(), book.getGenre(), book.getAuthor());
    }
}
