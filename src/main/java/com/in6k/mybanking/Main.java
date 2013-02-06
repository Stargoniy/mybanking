package com.in6k.mybanking;

import com.in6k.mybanking.dao.AccountDao;
import com.in6k.mybanking.dao.TransactionDao;
import com.in6k.mybanking.entity.Account;
import com.in6k.mybanking.entity.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Account account1 = new Account();
        account1.setName("scard");
        account1.setUserId(1);
        AccountDao.save(account1);

        Account account2 = new Account();
        account2.setName("John");
        account2.setUserId(2);
        AccountDao.save(account2);

        Transaction transaction = new Transaction();
        transaction.setDebetAccount(account1);
        transaction.setCreditAccount(account2);
        transaction.setSum((long) 10);
        TransactionDao.save(transaction);

        List<Transaction> transactions = TransactionDao.findAllTransactions();
        for (Transaction t : transactions) {
            System.out.println("CreditAccount name: " + t.getCreditAccount().getName());
            System.out.println("CreditAccount name: " + t.getDebetAccount().getName());
        }
    }
}
