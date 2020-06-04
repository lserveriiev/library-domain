package io.lenur.library.dependency;

import io.lenur.library.dao.AuthorDao;
import io.lenur.library.dao.BookDao;
import io.lenur.library.dao.CategoryDao;
import io.lenur.library.dao.impl.AuthorDaoImpl;
import io.lenur.di.annotation.Dependencies;
import io.lenur.di.annotation.Instance;
import io.lenur.library.dao.impl.BookDaoImpl;
import io.lenur.library.dao.impl.CategoryDaoImpl;

@Dependencies
public class Dao {
    @Instance
    public AuthorDao getAuthorDao() {
        return new AuthorDaoImpl();
    }

    @Instance
    public CategoryDao getCategoryDao() {
        return new CategoryDaoImpl();
    }

    @Instance
    public BookDao getBookDao() {
        return new BookDaoImpl();
    }
}
