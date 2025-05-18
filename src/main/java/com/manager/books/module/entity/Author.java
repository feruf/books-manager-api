package com.manager.books.module.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(name = "name")
    @Size(min = 1, max = 255, message = "Name should be between 0 and 255 long")
    private String name;

    @Column(name = "surname")
    @Size(min = 1, max = 255, message = "Surname should be between 0 and 255 long")
    private String surname;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;
}
