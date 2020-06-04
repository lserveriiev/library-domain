package io.lenur.library.service;

import io.lenur.library.domain.Author;

public interface AuthorService extends BaseService<Author> {
    Author findByName(String name);
}
