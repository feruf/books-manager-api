package com.manager.books.repository;

import com.manager.books.module.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
   @Query("""
        select a FROM Author a
        JOIN a.books b
        WHERE LOWER(b.title) = LOWER(:title)
""")
    Set<Author> findAuthorsByBookTitle(@Param("title") String title);

    @Query("""
        SELECT a FROM Author a
        JOIN a.books b
        JOIN b.genre g
        WHERE LOWER(g.name) = LOWER(:name)
""")
    Set<Author> findAuthorsByGenreName(@Param("name") String name);

    @Query("""
        SELECT a FROM Author a
        JOIN a.books b
        WHERE b.id = :id
""")
    Set<Author> findAuthorsByBookId(@Param("id") long id);

    @Query("""
        SELECT a FROM Author a
        JOIN a.books b
        JOIN b.genre g
        WHERE g.id = :id
""")
    Set<Author> findAuthorsByGenreId(@Param("id") long id);
}
