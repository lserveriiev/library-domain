package io.lenur.library.dao.impl;

import io.lenur.library.connection.Hibernate;
import io.lenur.library.dao.AuthorDao;
import io.lenur.library.domain.Author;
import io.lenur.library.exception.DaoException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.Optional;

public class AuthorDaoImpl extends AbstractDao<Author> implements AuthorDao {
    private static final String QUERY_SELECT =
            "SELECT a FROM Author a " +
            "LEFT JOIN FETCH a.books " +
            "WHERE a.name=:name";

    @Override
    public Optional<Author> findByName(String name) {
        try (Session session = Hibernate.getSessionFactory().openSession()) {
            Query query = session.createQuery(QUERY_SELECT, Author.class);
            query.setParameter("name", name);
            Author author = (Author) query.getSingleResult();
            return Optional.ofNullable(author);
        } catch (HibernateException e) {
            String msg = "There is something wrong in getting all movies";
            throw new DaoException(msg, e);
        }
    }
}
