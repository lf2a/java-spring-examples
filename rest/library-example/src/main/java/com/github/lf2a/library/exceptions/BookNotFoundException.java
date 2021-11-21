package com.github.lf2a.library.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String id) {
        super("Could not find book " + id);
    }
}
