package org.nicholas.dao;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.nicholas.connection.ConnectionManager;
import org.nicholas.validation.Validator;
import org.nicholas.validation.ValidatorImpl;

import java.util.List;

public class DefaultDaoImpl<T, K> implements DefaultDao<T, K> {
    private final Class<T> type;
    private final Validator<T> validator;

    public DefaultDaoImpl(Class<T> type){
        this.type = type;
        this.validator = new ValidatorImpl<>();
    }

    @Override
    public List<T> findAll() {
        Session session = ConnectionManager.getCurrentSession(); //closes with transaction commit

        try {
            session.beginTransaction();
            Query query = session.createQuery("from " + type.getSimpleName());
            List<T> objects = query.getResultList();
            session.getTransaction().commit();
            return objects;
        } catch (Exception ex){
            session.getTransaction().rollback();
            throw new RuntimeException(ex);
        }
    }

    @Override
    public T findByKey(K key) {
        Session session = ConnectionManager.getCurrentSession();

        try {
            session.beginTransaction();
            T object = session.get(type, key);
            session.getTransaction().commit();
            return object;
    } catch (Exception ex){
        session.getTransaction().rollback();
        throw new RuntimeException(ex);
    }
    }

    @Override
    public void save(T obj){
        if (validator.validate(obj)) {
            Session session = ConnectionManager.getCurrentSession();

            try {
                session.beginTransaction();
                session.persist(obj);
                session.getTransaction().commit();
            } catch (Exception ex) {
                session.getTransaction().rollback();
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void update(T obj) {
        if (validator.validate(obj)) {
            Session session = ConnectionManager.getCurrentSession();

            try {
                session.beginTransaction();
                session.merge(obj);
                session.getTransaction().commit();
            } catch (Exception ex) {
                session.getTransaction().rollback();
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void delete(T obj) {
        Session session = ConnectionManager.getCurrentSession();

        try {
            session.beginTransaction();
            session.remove(obj);
            session.getTransaction().commit();
    } catch (Exception ex){
        session.getTransaction().rollback();
            throw new RuntimeException(ex);
        }
    }
//    private void initialize(T object){
//        if (object != null) {
//            Field[] fields = object.getClass().getDeclaredFields();
//
//            for (Field field : fields) {
//                field.setAccessible(true);
//                try {
//                    Hibernate.initialize(field.get(object));
//                } catch (IllegalAccessException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//    }

}