package com.manager.books.controller;

import com.manager.books.module.dto.request.GenreRequestDto;
import com.manager.books.module.dto.response.GenreResponseDto;
import com.manager.books.service.GenreService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/genre")
@Validated
public class GenreController {
    private final GenreService service;

    public GenreController(GenreService service) {
        this.service = service;
    }

    @PutMapping()
    public ResponseEntity<GenreResponseDto> create(@Valid @RequestBody GenreRequestDto dto){
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping()
    public ResponseEntity<Set<GenreResponseDto>> viewAll(){
        return ResponseEntity.ok(service.viewAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreResponseDto> view(@PathVariable long id){
        return ResponseEntity.ok(service.view(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<GenreResponseDto> update(@Valid @RequestBody GenreRequestDto dto, @PathVariable long id){
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenreResponseDto> delete(@PathVariable long id){
        return ResponseEntity.ok(service.delete(id));
    }
}
