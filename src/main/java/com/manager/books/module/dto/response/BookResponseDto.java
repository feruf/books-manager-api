package com.manager.books.module.dto.response;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class BookResponseDto {
    private long id;
    private String title;
    private LocalDate publishingYear;
    private GenreResponseDto genre;
    private Set<AuthorResponseDto> authors;
}
