package com.in6k.mybanking;

import com.in6k.mybanking.dao.AccountDao;
import com.in6k.mybanking.dao.TransactionDao;
import com.in6k.mybanking.dao.UserDao;
import com.in6k.mybanking.entity.Account;
import com.in6k.mybanking.entity.Transaction;
import com.in6k.mybanking.entity.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Account account1 = new Account();
//        account1.setName("scard");
//        account1.setUserId(1);
//        AccountDao.save(account1);
//
//        Account account2 = new Account();
//        account2.setName("John");
//        account2.setUserId(2);
//        AccountDao.save(account2);
//
//        Transaction transaction = new Transaction();
//        transaction.setDebetAccount(account1);
//        transaction.setCreditAccount(account2);
//        transaction.setSum((long) 10);
//        TransactionDao.save(transaction);
//
//        List<Transaction> transactions = TransactionDao.findAll();
//        for (Transaction t : transactions) {
//            System.out.println("CreditAccount name: " + t.getCreditAccount().getName());
//            System.out.println("CreditAccount name: " + t.getDebetAccount().getName());
//        }
        User user1 = new User();
        user1.setName("John");
        user1.setSystem(false);
        UserDao.save(user1);

        User user2 = new User();
        user2.setName("Popolnenie");
        user2.setSystem(true);
        UserDao.save(user2);

        List<User> users = UserDao.findAll();
        for (User u : users) {
            System.out.println(u.getName() + "  " + u.isSystem());
        }

    }
}
