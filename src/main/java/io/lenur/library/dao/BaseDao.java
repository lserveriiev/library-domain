package io.lenur.library.dao;

public interface BaseDao<T> {
    T create(T entity);
}
