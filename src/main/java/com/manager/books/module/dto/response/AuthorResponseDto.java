package com.manager.books.module.dto.response;

import com.manager.books.module.entity.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@NoArgsConstructor
public class AuthorResponseDto {
    private long id;
    private String name;
    private String surname;
    private Set<Book> books;
}
