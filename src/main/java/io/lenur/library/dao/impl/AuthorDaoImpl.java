package io.lenur.library.dao.impl;

import io.lenur.library.connection.Hibernate;
import io.lenur.library.dao.AuthorDao;
import io.lenur.library.domain.Author;
import io.lenur.library.exception.DaoException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.Optional;

public class AuthorDaoImpl implements AuthorDao {
    @Override
    public Author create(Author author) {
        Transaction transaction = null;
        try (Session session = Hibernate.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
            return author;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            String msg = "Can't create an author entity!";
            throw new DaoException(msg, e);
        }
    }

    @Override
    public Optional<Author> findByName(String name) {
        try (Session session = Hibernate.getSessionFactory().openSession()) {
            Query query = session.createQuery(
                    "SELECT a " +
                        "FROM Author a " +
                        "WHERE a.name=:name"
                    , Author.class);
            query.setParameter("name", name);
            Author author = (Author) query.getSingleResult();
            return Optional.ofNullable(author);
        } catch (HibernateException e) {
            String msg = "There is something wrong in getting all movies";
            throw new DaoException(msg, e);
        }
    }
}
