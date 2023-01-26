package ru.home.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import ru.home.entity.Type;
import ru.home.entity.User;

import java.net.UnknownServiceException;
import java.util.Properties;

public class Service {

    private final SessionFactory sessionFactory;

    public Service() {

        sessionFactory = new Configuration()
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

    }

    public User createUser(String name, Type type){
        User user = new User(name, type);
        return save(user);
    }

    protected User save(User user){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            return user;
        }
    }


}
