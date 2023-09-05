package com.alexandria.Alexandria.Library.entities.book;

import org.antlr.v4.runtime.misc.NotNull;

public record BookUpdate(
    @NotNull
    Long id,
    String name,
    String isbn,
    String genre,
    String author) {
}
