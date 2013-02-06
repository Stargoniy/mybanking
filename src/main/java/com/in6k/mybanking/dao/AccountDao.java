package com.in6k.mybanking.dao;

import com.in6k.mybanking.entity.Account;
import com.in6k.mybanking.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AccountDao {
    public static void save(Account account) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(account);
        transaction.commit();
        session.close();
    }

    public static List<Account> findAllAccounts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Account> result = session.createCriteria(Account.class).list();
        session.close();
        return result;
    }

    public static Account findAccountById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Account result = (Account) session.get(Account.class, id);
        session.close();
        return result;
    }

//    public
}
