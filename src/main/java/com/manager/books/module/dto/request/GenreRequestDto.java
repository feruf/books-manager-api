package com.manager.books.module.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GenreRequestDto {
    @NotBlank(message = "Name should not be blank")
    @Size(min = 1, max = 255, message = "Name should be between 0 and 255")
    private String name;
}
