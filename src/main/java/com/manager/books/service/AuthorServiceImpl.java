package com.manager.books.service;

import com.manager.books.module.dto.request.AuthorRequestDto;
import com.manager.books.module.dto.request.GenreRequestDto;
import com.manager.books.module.dto.response.AuthorResponseDto;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthorServiceImpl implements AuthorService{
    @Override
    public AuthorResponseDto create(AuthorRequestDto dto) {
        return null;
    }

    @Override
    public Set<AuthorResponseDto> viewAll() {
        return Set.of();
    }

    @Override
    public AuthorResponseDto viewAuthor(long id) {
        return null;
    }

    @Override
    public AuthorResponseDto update(long id, AuthorRequestDto dto) {
        return null;
    }

    @Override
    public AuthorResponseDto delete(long id) {
        return null;
    }

    @Override
    public Set<AuthorResponseDto> viewAuthorsByBook(long id) {
        return Set.of();
    }

    @Override
    public Set<AuthorResponseDto> viewAuthorsByGenre(long id) {
        return Set.of();
    }

    @Override
    public Set<AuthorResponseDto> viewAuthorsByGenreName(GenreRequestDto dto) {
        return Set.of();
    }
}
