package com.manager.books.module.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@NoArgsConstructor
@Setter
public class BookRequestDto {
    @NotBlank(message = "Title should not be blank")
    @Size(min = 1, max = 255, message = "Title should be between 0 and 255")
    private String title;

    @NotNull(message = "The book should have a genre")
    @Min(value = 1, message = "Genre should be higher than 0")
    private Long genreId;

    @NotNull(message = "Publishing year should not be empty")
    private LocalDate publishingYear;

    @NotNull(message = "The book should contain authors")
    private Set<Long> authorsId;
}
