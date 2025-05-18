package com.manager.books.service;

import com.manager.books.module.dto.request.AuthorRequestDto;
import com.manager.books.module.dto.request.GenreRequestDto;
import com.manager.books.module.dto.response.AuthorResponseDto;

import java.util.Set;

public interface AuthorService {
    public AuthorResponseDto create(AuthorRequestDto dto);
    public Set<AuthorResponseDto> viewAll();
    public AuthorResponseDto viewAuthor(long id);
    public AuthorResponseDto update(long id, AuthorRequestDto dto);
    public AuthorResponseDto delete(long id);
    public Set<AuthorResponseDto> viewAuthorsByBook(long id);
    public Set<AuthorResponseDto> viewAuthorsByGenre(long id);
    public Set<AuthorResponseDto> viewAuthorsByGenreName(GenreRequestDto dto);

}
