package io.lenur.library.service.impl;

import io.lenur.di.annotation.Inject;
import io.lenur.library.dao.CategoryDao;
import io.lenur.library.domain.Category;
import io.lenur.library.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
    @Inject
    CategoryDao categoryDao;

    @Override
    public Category create(Category category) {
        return categoryDao.create(category);
    }
}
