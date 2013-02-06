package com.in6k.mybanking.dao;

import com.in6k.mybanking.entity.Transaction;
import com.in6k.mybanking.hibernate.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class TransactionDao {
    public static void save(Transaction transaction) {
        Session session = HibernateUtil.getSessionFactory().openSession();
//        org.hibernate.Transaction hibernateTransaction = session.beginTransaction();
        session.saveOrUpdate(transaction);
//        hibernateTransaction.commit();
        session.close();
    }

    public static List<Transaction> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Transaction> result = session.createCriteria(Transaction.class).list();
        session.close();
        return result;
    }

    public static Transaction findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction result = (Transaction) session.get(Transaction.class, id);
        session.close();
        return result;
    }
}
