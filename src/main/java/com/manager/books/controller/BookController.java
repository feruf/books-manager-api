package com.manager.books.controller;

import com.manager.books.module.dto.request.BookRequestDto;
import com.manager.books.module.dto.response.BookResponseDto;
import com.manager.books.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/book")
@Validated
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<BookResponseDto> create(@Valid @RequestBody BookRequestDto dto){
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> view(@PathVariable long id){
        return ResponseEntity.ok(service.view(id));
    }

    @GetMapping
    public ResponseEntity<Set<BookResponseDto>> viewAll(){
        return ResponseEntity.ok(service.viewAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDto> update(@PathVariable long id, @Valid @RequestBody BookRequestDto dto){
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookResponseDto> delete(@PathVariable long id){
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<Set<BookResponseDto>> viewBooksByAuthor(@PathVariable long id){
        return ResponseEntity.ok(service.viewBooksByAuthor(id));
    }

    @GetMapping("/genre/{id}")
    public ResponseEntity<Set<BookResponseDto>> viewBooksByGenre(@PathVariable long id){
        return ResponseEntity.ok(service.viewBooksByGenre(id));
    }
}
