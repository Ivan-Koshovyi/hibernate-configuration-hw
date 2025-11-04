package mate.academy.dao;

import mate.academy.model.Movie;
import mate.academy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Optional;

import static mate.academy.util.HibernateUtil.*;

public class MovieDaoImpl implements MovieDao{
    @Override
    public Movie add(Movie movie) {
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(movie);
        transaction.commit();
        session.close();
        return movie;
    }

    @Override
    public Optional<Movie> get(Long id) {
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        return Optional.ofNullable(session.find(Movie.class, id));
    }
}
