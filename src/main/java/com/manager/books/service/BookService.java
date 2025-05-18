package com.manager.books.service;

import com.manager.books.module.dto.request.BookRequestDto;
import com.manager.books.module.dto.response.BookResponseDto;

import java.util.Set;

public interface BookService {
    public BookResponseDto create(BookRequestDto dto);
    public BookResponseDto view(long id);
    public Set<BookResponseDto> viewAll();
    public BookResponseDto update(long id, BookRequestDto dto);
    public BookResponseDto delete(long id);
    public Set<BookResponseDto> viewBooksByAuthor(long id);
    public Set<BookResponseDto> viewBooksByGenre(long id);
}
