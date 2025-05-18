package com.manager.books.service;

import com.manager.books.module.dto.request.GenreRequestDto;
import com.manager.books.module.dto.response.GenreResponseDto;

import java.util.Set;

public interface GenreService {
    public GenreResponseDto create(GenreRequestDto dto);
    public GenreResponseDto view(long id);
    public Set<GenreResponseDto> viewAll();
    public GenreResponseDto update(long id, GenreRequestDto dto);
    public GenreResponseDto delete(long id);
}
