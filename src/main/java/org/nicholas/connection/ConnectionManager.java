package org.nicholas.connection;

import jakarta.persistence.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.nicholas.model.*;

public class ConnectionManager {

    private ConnectionManager(){}

    private static Configuration configuration;
    private static SessionFactory sessionFactory;

    private static void buildConfig(){
        if (configuration == null) {
            configuration = new Configuration();
            addAnnotatedClasses(configuration);
        }
    }

    private static void addAnnotatedClasses(Configuration configuration){
        configuration.addAnnotatedClass(Author.class);
        configuration.addAnnotatedClass(BookCategory.class);
        configuration.addAnnotatedClass(Book.class);
        configuration.addAnnotatedClass(RefContactType.class);
        configuration.addAnnotatedClass(Contact.class);
        configuration.addAnnotatedClass(Customer.class);
        configuration.addAnnotatedClass(Order.class);
        configuration.addAnnotatedClass(OrderItem.class);
    }

    public static SessionFactory openSessionFactory(){
        if (sessionFactory == null || sessionFactory.isClosed()) {
            buildConfig();
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void updateIncrementForEntity(Object entity){
        Session session = getCurrentSession();
        String table = entity.getClass().getAnnotation(Table.class).name();
        session.createNativeQuery("alter table " + table + " set AUTO_INCREMENT = 1").executeUpdate();
    }

    public static Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public static void closeSessionFactory(){
        sessionFactory.close();
    }
}
