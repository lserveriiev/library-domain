package io.lenur.library.service;

public interface BaseService<T> {
    T create(T entity);
}
