package com.manager.books.module.dto.request;

import com.manager.books.module.entity.Book;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.util.Set;

@Validated
@Getter
@NoArgsConstructor
@Setter
public class AuthorRequestDto {
    @NotBlank(message = "Name should not be blank")
    @Size(min = 0, max = 255, message = "Name should be between 0 and 255")
    private String name;

    @NotBlank(message = "Surname should not be blank")
    @Size(min = 0, max = 255, message = "Surname should be between 0 and 255")
    private String surname;
}
