package io.lenur.library.service;

import io.lenur.library.domain.Author;

public interface AuthorService {
    Author create(Author author);

    Author findByName(String name);
}
