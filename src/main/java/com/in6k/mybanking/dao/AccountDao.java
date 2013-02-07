package com.in6k.mybanking.dao;

import com.in6k.mybanking.entity.Account;
import com.in6k.mybanking.hibernate.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import java.io.Serializable;
import java.util.List;

public class AccountDao {
    public static void save(Account account) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(account);
        transaction.commit();
        session.close();
    }

    public static List<Account> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Account> result = session.createCriteria(Account.class).list();
        session.close();
        return result;
    }

    public static Account findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Account result = (Account) session.get(Account.class, id);
        session.close();
        return result;
    }

    public static double CalculateSum(Account account) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<com.in6k.mybanking.entity.Transaction> transactionsDebet = session.createCriteria(com.in6k.mybanking.entity.Transaction.class).add(Expression.like("debetAccount", account)).list();
        List<com.in6k.mybanking.entity.Transaction> transactionsCredit = session.createCriteria(com.in6k.mybanking.entity.Transaction.class).add(Expression.like("creditAccount", account)).list();
        double result = 0;
        for (com.in6k.mybanking.entity.Transaction t : transactionsDebet) {
            result += t.getSum();
        }
        for (com.in6k.mybanking.entity.Transaction t : transactionsCredit) {
            result -= t.getSum();
        }

//        String str = "SELECT * FROM transactions WHERE debet_account_id=? AND credit_account_id=?";
//        Query sqlQuery = session.createSQLQuery("SELECT * FROM transactions WHERE debet_account_id=? AND credit_account_id=?", account);
//        Query query = session.createSQLQuery("SELECT sum(t.sum) FROM transactions T WHERE debet_account_id=:accountId OR credit_account_id=:accountId").addEntity(com.in6k.mybanking.entity.Transaction.class);
//        query.setInteger("accountId", account.getId());
//        query.setInteger(1, account.getId());
//        List list = query.list();
//        Object res = query.uniqueResult();

        session.close();
        return result;
    }
}
