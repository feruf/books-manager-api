package com.manager.books.service;

import com.manager.books.module.dto.request.BookRequestDto;
import com.manager.books.module.dto.response.BookResponseDto;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class BookServiceImpl implements BookService{

    @Override
    public BookResponseDto create(BookRequestDto dto) {
        return null;
    }

    @Override
    public BookResponseDto view(long id) {
        return null;
    }

    @Override
    public Set<BookResponseDto> viewAll() {
        return Set.of();
    }

    @Override
    public BookResponseDto update(long id, BookRequestDto dto) {
        return null;
    }

    @Override
    public BookResponseDto delete(long id) {
        return null;
    }

    @Override
    public Set<BookResponseDto> viewBooksByAuthor(long id) {
        return Set.of();
    }

    @Override
    public Set<BookResponseDto> viewBooksByGenre(long id) {
        return Set.of();
    }
}
