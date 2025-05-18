package com.manager.books.service;

import com.manager.books.module.dto.request.AuthorRequestDto;
import com.manager.books.module.dto.request.GenreRequestDto;
import com.manager.books.module.dto.response.AuthorResponseDto;
import com.manager.books.module.entity.Author;
import com.manager.books.repository.AuthorRepository;
import com.manager.books.repository.BookRepository;
import com.manager.books.repository.GenreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService{
    private final AuthorRepository repository;
    private final ModelMapper mapper;

    public AuthorServiceImpl(AuthorRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public AuthorResponseDto create(AuthorRequestDto dto) {
        Author author = mapper.map(dto, Author.class);
        author = repository.save(author);
        return mapper.map(author, AuthorResponseDto.class);
    }

    @Override
    public Set<AuthorResponseDto> viewAll() {
        return repository.findAll()
                .stream()
                .map(author -> mapper.map(author, AuthorResponseDto.class))
                .collect(Collectors.toSet());
    }

    @Override
    public AuthorResponseDto viewAuthor(long id) {
        Author author = repository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("No author found"));
        return mapper.map(author, AuthorResponseDto.class);
    }

    @Override
    public AuthorResponseDto update(long id, AuthorRequestDto dto) {
        Author author = repository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("No author found"));
        mapper.map(dto, author);
        author = repository.save(author);
        return mapper.map(author,AuthorResponseDto.class);
    }

    @Override
    public AuthorResponseDto delete(long id) {
        Author authorToDelete = repository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("No author found"));
        repository.delete(authorToDelete);
        return mapper.map(authorToDelete, AuthorResponseDto.class);
    }

    @Override
    public Set<AuthorResponseDto> viewAuthorsByBook(long id) {
        return repository.findAuthorsByBookId(id)
                .stream()
                .map(author -> mapper.map(author, AuthorResponseDto.class))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<AuthorResponseDto> viewAuthorsByGenre(long id) {
        return repository.findAuthorsByGenreId(id)
                .stream()
                .map(author -> mapper.map(author, AuthorResponseDto.class))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<AuthorResponseDto> viewAuthorsByGenreName(GenreRequestDto dto) {
        return repository.findAuthorsByGenreName(dto.getName())
                .stream()
                .map(author -> mapper.map(author, AuthorResponseDto.class))
                .collect(Collectors.toSet());
    }
}
