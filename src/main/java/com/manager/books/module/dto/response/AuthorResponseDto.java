package com.manager.books.module.dto.response;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class AuthorResponseDto {
    private long id;
    private String name;
    private String surname;
    private Set<BookResponseDto> books;
}
