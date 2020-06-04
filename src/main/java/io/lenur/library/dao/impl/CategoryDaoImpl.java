package io.lenur.library.dao.impl;

import io.lenur.library.connection.Hibernate;
import io.lenur.library.dao.CategoryDao;
import io.lenur.library.domain.Category;
import io.lenur.library.exception.DaoException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CategoryDaoImpl implements CategoryDao {
    @Override
    public Category create(Category category) {
        Transaction transaction = null;
        try (Session session = Hibernate.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(category);
            transaction.commit();
            return category;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            String msg = "Can't create a category entity!";
            throw new DaoException(msg, e);
        }
    }
}
