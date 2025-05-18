package com.manager.books.service;

import com.manager.books.module.dto.request.BookRequestDto;
import com.manager.books.module.dto.response.BookResponseDto;
import com.manager.books.module.entity.Author;
import com.manager.books.module.entity.Book;
import com.manager.books.module.entity.Genre;
import com.manager.books.repository.AuthorRepository;
import com.manager.books.repository.BookRepository;
import com.manager.books.repository.GenreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService{
    private final BookRepository repository;
    private final ModelMapper mapper;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    public BookServiceImpl(BookRepository repository, ModelMapper mapper, AuthorRepository authorRepository, GenreRepository genreRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public BookResponseDto create(BookRequestDto dto) {
      Book bookToInsert = mapper.map(dto, Book.class);

      Set<Author> authors = bookToInsert.getAuthors();
      Genre genre = bookToInsert.getGenre();
      Set<Author> updatedAuthors = new HashSet<>();
      if(genre == null){
          throw new IllegalArgumentException("Genre must not be null");
      }


      for(Author author: authors){
          if(author.getId()!=null && authorRepository.existsById(author.getId())){
              updatedAuthors.add(author);
          }else {
              author = authorRepository.save(author);
              updatedAuthors.add(author);
          }
      }

      if(genre.getId()!=null && !genreRepository.existsById(genre.getId())){
          genre = genreRepository.save(genre);
      }

      bookToInsert.setAuthors(updatedAuthors);
      bookToInsert.setGenre(genre);
      bookToInsert = repository.save(bookToInsert);
      return mapper.map(bookToInsert,BookResponseDto.class);
    }

    @Override
    public BookResponseDto view(long id) {
        Book bookToView = repository
                .findById(id)
                .orElseThrow(()->new IllegalArgumentException("No book found"));
        return mapper.map(bookToView,BookResponseDto.class);
    }

    @Override
    public Set<BookResponseDto> viewAll() {
        return repository.findAll()
                .stream()
                .map(book -> mapper.map(book, BookResponseDto.class))
                .collect(Collectors.toSet());
    }

    @Override
    public BookResponseDto update(long id, BookRequestDto dto) {
        Book bookToUpdate = repository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("No book found"));
        mapper.map(dto, bookToUpdate);
        bookToUpdate = repository.save(bookToUpdate);
        return mapper.map(bookToUpdate, BookResponseDto.class);
    }

    @Override
    public BookResponseDto delete(long id) {
        Book bookToDelete = repository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("No book found"));
        repository.delete(bookToDelete);
        return mapper.map(bookToDelete,BookResponseDto.class);
    }

    @Override
    public Set<BookResponseDto> viewBooksByAuthor(long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("No author found"));
        return repository.findBooksByAuthorId(id)
                .stream()
                .map(book -> mapper
                        .map(book,BookResponseDto.class))
                .collect(Collectors.toSet());

    }

    @Override
    public Set<BookResponseDto> viewBooksByGenre(long id) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("No genre found"));
        return repository.findBooksByGenreId(id)
                .stream()
                .map(book->mapper.map(book,BookResponseDto.class))
                .collect(Collectors.toSet());
    }
}
