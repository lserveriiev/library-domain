package io.lenur.library.service.impl;

import io.lenur.di.annotation.Inject;
import io.lenur.library.dao.BookDao;
import io.lenur.library.domain.Book;
import io.lenur.library.service.BookService;

public class BookServiceImpl implements BookService {
    @Inject
    BookDao bookDao;

    @Override
    public Book create(Book book) {
        return bookDao.create(book);
    }
}
