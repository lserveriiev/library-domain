package io.lenur.library.dao.impl;

import io.lenur.library.connection.Hibernate;
import io.lenur.library.dao.BookDao;
import io.lenur.library.domain.Book;
import io.lenur.library.exception.DaoException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookDaoImpl implements BookDao {
    @Override
    public Book create(Book book) {
        Transaction transaction = null;
        try (Session session = Hibernate.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
            return book;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            String msg = "Can't create a book entity!";
            throw new DaoException(msg, e);
        }
    }
}
