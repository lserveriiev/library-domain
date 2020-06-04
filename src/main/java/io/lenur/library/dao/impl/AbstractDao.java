package io.lenur.library.dao.impl;

import io.lenur.library.connection.Hibernate;
import io.lenur.library.dao.BaseDao;
import io.lenur.library.exception.DaoException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class AbstractDao<T> implements BaseDao<T> {
    @Override
    public T create(T entity) {
        Transaction transaction = null;
        try (Session session = Hibernate.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
            return entity;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            String msg = "Can't create an entity!";
            throw new DaoException(msg, e);
        }
    }
}
