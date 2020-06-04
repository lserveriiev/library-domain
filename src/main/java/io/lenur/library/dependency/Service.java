package io.lenur.library.dependency;

import io.lenur.library.service.AuthorService;
import io.lenur.library.service.CategoryService;
import io.lenur.library.service.impl.AuthorServiceImpl;
import io.lenur.di.annotation.Dependencies;
import io.lenur.di.annotation.Instance;
import io.lenur.library.service.impl.CategoryServiceImpl;

@Dependencies
public class Service {
    @Instance
    public AuthorService getAuthorService() {
        return new AuthorServiceImpl();
    }

    @Instance
    public CategoryService getCategoryService() {
        return new CategoryServiceImpl();
    }
}
