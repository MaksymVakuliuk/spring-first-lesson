package org.spring.first.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.spring.first.dao.UserDao;
import org.spring.first.exceptions.DataProcessingException;
import org.spring.first.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert User entity", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<User> listUsers() {
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("select u from User u", User.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieve list of users", e);
        }
    }

    @Override
    public User getUserById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("select u from User u where u.id = :id",
                    User.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieve user by id", e);
        }
    }
}
