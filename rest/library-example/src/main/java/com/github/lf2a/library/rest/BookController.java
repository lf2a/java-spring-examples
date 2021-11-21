package com.github.lf2a.library.rest;

import com.github.lf2a.library.exceptions.BookNotFoundException;
import com.github.lf2a.library.models.Book;
import com.github.lf2a.library.utils.CustomCollector;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = Arrays.asList(
            new Book("9780132350884", "Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin", LocalDate.of(2008, Calendar.SEPTEMBER, 1)),
            new Book("0134494164", "Clean Architecture: A Craftsman's Guide to Software Structure and Design", "Robert C. Martin", LocalDate.of(2017, Calendar.AUGUST, 10)),
            new Book("0321125215", "Domain-Driven Design: Tackling Complexity in the Heart of Software", "Eric Evans", LocalDate.of(2003, Calendar.SEPTEMBER, 20)),
            new Book("0201633612", "Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma", LocalDate.of(1994, Calendar.DECEMBER, 10))
    );

    @GetMapping(produces = {"application/hal+json"})
    public CollectionModel<Book> all() {
        for (Book book : this.books) {
            String isbn = book.getISBN();
            Link selfLink = WebMvcLinkBuilder.linkTo(BookController.class).slash(isbn).withSelfRel();
            book.add(selfLink);
        }

        Link link = WebMvcLinkBuilder.linkTo(BookController.class).withSelfRel();
        return CollectionModel.of(this.books, link);
    }

    @GetMapping(value = "/{isbn}")
    public Book getBookByISBN(@PathVariable String isbn) {
        return this.books.stream().filter(book -> book.getISBN().equals(isbn)).collect(CustomCollector.toSingleton());
    }

    @PutMapping(value = "/{isbn}")
    public Book updateBookByISBN(@PathVariable String isbn, @RequestBody @Valid Book book){
        for (Book book1 : books) {
            if (book1.getISBN().equals(isbn)) {
                book1.setAuthor(book.getAuthor());
                book1.setTitle(book.getTitle());
                book1.setReleasedDate(book.getReleasedDate());
                return book1;
            }
        }
        throw new BookNotFoundException(isbn);
    }

    @PostMapping(value = "")
    public Book newBook(@RequestBody @Valid Book book) {
        this.books.add(book);
        return book;
    }

    @DeleteMapping(value = "/{isbn}")
    public ResponseEntity<Book> deleteBookById(@PathVariable String isbn) {
        this.books = this.books.stream().filter(b -> !b.getISBN().equals(isbn)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
