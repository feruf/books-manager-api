package com.manager.books.controller;

import com.manager.books.module.dto.request.AuthorRequestDto;
import com.manager.books.module.dto.request.GenreRequestDto;
import com.manager.books.module.dto.response.AuthorResponseDto;
import com.manager.books.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/author")
@Validated
public class AuthorController {
    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AuthorResponseDto> create(@Valid @RequestBody AuthorRequestDto dto){
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/view")
    public ResponseEntity<Set<AuthorResponseDto>> viewAll(){
        return ResponseEntity.ok(service.viewAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> viewAuthor(@PathVariable long id){
        return ResponseEntity.ok(service.viewAuthor(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> update(@PathVariable long id, @Valid @RequestBody AuthorRequestDto dto){
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> delete(@PathVariable long id){
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Set<AuthorResponseDto>> viewAuthorsByBook(@PathVariable long id){
        return ResponseEntity.ok(service.viewAuthorsByBook(id));
    }

    @GetMapping("/genre/{id}")
    public ResponseEntity<Set<AuthorResponseDto>> viewAuthorsByGenre(@PathVariable long id){
        return ResponseEntity.ok(service.viewAuthorsByGenre(id));
    }

    @GetMapping("/genre")
    public ResponseEntity<Set<AuthorResponseDto>> viewAuthorsByGenreName(@Valid @RequestBody GenreRequestDto dto){
        return ResponseEntity.ok(service.viewAuthorsByGenreName(dto));
    }

}
