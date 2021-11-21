package com.github.lf2a.library.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book extends RepresentationModel<Book> {
    @NotBlank(message = "ISBN is mandatory")
    private String ISBN;

    @NotBlank(message = "Book Title is mandatory")
    private String title;

    @NotBlank(message = "Book Author is mandatory")
    private String author;

    @PastOrPresent
    private LocalDate releasedDate;
}
