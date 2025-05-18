package com.manager.books.service;

import com.manager.books.module.dto.request.GenreRequestDto;
import com.manager.books.module.dto.response.GenreResponseDto;
import com.manager.books.module.entity.Genre;
import com.manager.books.repository.GenreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class GenreServiceImpl implements GenreService{
    private final GenreRepository repository;
    private final ModelMapper mapper;

    public GenreServiceImpl(GenreRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public GenreResponseDto create(GenreRequestDto dto) {
        Genre genre = mapper.map(dto, Genre.class);
        genre = repository.save(genre);
        return mapper.map(genre, GenreResponseDto.class);
    }

    @Override
    public GenreResponseDto view(long id) {
        Genre genre = mapper
                .map(repository.findById(id)
                                .orElseThrow(()-> new IllegalArgumentException("No such genre in the database"))
                        ,Genre.class);
        return null;
    }

    @Override
    public Set<GenreResponseDto> viewAll() {
        return Set.of();
    }

    @Override
    public GenreResponseDto update(long id, GenreRequestDto dto) {
        return null;
    }

    @Override
    public GenreResponseDto delete(long id) {
        return null;
    }
}
