package com.in6k.mybanking.dao;

import com.in6k.mybanking.entity.User;
import com.in6k.mybanking.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDao {
    public static void save(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
        session.close();
    }

    public static List<User> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> result = session.createCriteria(User.class).list();
        session.close();
        return result;
    }

    public static User findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User result = (User) session.get(User.class, id);
        session.close();
        return result;
    }
}
