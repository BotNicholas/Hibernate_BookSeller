package org.nicholas.dao;

import org.hibernate.Hibernate;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

public interface DefaultDao<T, K> {
    List<T> findAll();

    T findByKey(K key);

    void save(T obj);

    void update(T Obj);

    void delete(T obj);
}