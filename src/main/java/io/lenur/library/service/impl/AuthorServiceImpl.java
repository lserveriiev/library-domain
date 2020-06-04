package io.lenur.library.service.impl;

import io.lenur.di.annotation.Inject;
import io.lenur.library.dao.AuthorDao;
import io.lenur.library.domain.Author;
import io.lenur.library.exception.ModelNotFoundException;
import io.lenur.library.service.AuthorService;

public class AuthorServiceImpl implements AuthorService {
    @Inject
    AuthorDao authorDao;

    @Override
    public Author create(Author author) {
        return authorDao.create(author);
    }

    @Override
    public Author findByName(String name) {
        return authorDao
                .findByName(name)
                .orElseThrow(() -> new ModelNotFoundException("An author is not found"));
    }
}
