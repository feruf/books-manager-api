package com.manager.books.repository;

import com.manager.books.module.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("""
        SELECT b FROM Book b
        JOIN b.authors a
        WHERE LOWER(a.name) = LOWER(:name)
""")
    Set<Book> findBooksByAuthorName(@Param("name") String name);

    @Query("""
        SELECT b FROM Book b
        JOIN b.genre g
        WHERE LOWER(g.name) = LOWER(:name)
""")
    Set<Book> findBooksByGenreName(@Param("name") String name);

    @Query("""
        SELECT b FROM Book b
        JOIN b.authors a
        WHERE a.id = :id
""")
    Set<Book> findBooksByAuthorId(@Param("id") long id);

    @Query("""
        SELECT b FROM Book b
        JOIN b.genre a
        WHERE a.id = :id
""")
    Set<Book> findBooksByGenreId(@Param("id") long id);
}
