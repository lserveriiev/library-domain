package io.lenur.library.dao;

import io.lenur.library.domain.Author;

import java.util.Optional;

public interface AuthorDao {
    Author create(Author author);

    Optional<Author> findByName(String name);
}
