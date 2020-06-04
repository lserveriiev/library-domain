package io.lenur.library.dao;

import io.lenur.library.domain.Author;

import java.util.Optional;

public interface AuthorDao extends BaseDao<Author> {
    Optional<Author> findByName(String name);
}
