package com.manager.books.module.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    @Size(min = 0, max = 255, message = "Name should be between 0 and 255 long")
    private String name;

    @Column(name = "surname")
    @Size(min = 0, max = 255, message = "Surname should be between 0 and 255 long")
    private String surname;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;
}
