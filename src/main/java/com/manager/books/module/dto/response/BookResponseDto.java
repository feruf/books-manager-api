package com.manager.books.module.dto.response;

import com.manager.books.module.entity.Author;
import com.manager.books.module.entity.Genre;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Getter
@NoArgsConstructor
public class BookResponseDto {
    private long id;
    private String title;
    private LocalDate publishingYear;
    private Genre genre;
    private Set<Author> authors;
}
