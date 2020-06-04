package io.lenur.library.dependency;

import io.lenur.library.dao.AuthorDao;
import io.lenur.library.dao.impl.AuthorDaoImpl;
import io.lenur.di.annotation.Dependencies;
import io.lenur.di.annotation.Instance;

@Dependencies
public class Dao {
    @Instance
    public AuthorDao getAuthorDao() {
        return new AuthorDaoImpl();
    }
}
