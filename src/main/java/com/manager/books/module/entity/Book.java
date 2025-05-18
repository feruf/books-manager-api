package com.manager.books.module.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    @Size(min = 1, max = 255, message = "Title should be between 0 and 255 long")
    private String title;

    @Column(name = "publishing_year")
    @NotNull(message = "Publishing year should not be empty")
    private LocalDate publishingYear;

    @Getter
    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    @Setter
    private Genre genre;

    @Getter
    @Setter
    @ManyToMany
    @JoinTable(
            name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors;
}
