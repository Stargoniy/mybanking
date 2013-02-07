package com.in6k.mybanking.servlet;

import com.in6k.mybanking.dao.AccountDao;
import com.in6k.mybanking.dao.TransactionDao;
import com.in6k.mybanking.entity.Account;
import com.in6k.mybanking.entity.Transaction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TransactionsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Account> accounts = AccountDao.findAll();
        req.setAttribute("accounts", accounts);

        List<Transaction> transactions = TransactionDao.findAll();
        req.setAttribute("transactions", transactions);

        req.getRequestDispatcher("/transactions.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Transaction transaction = new Transaction();
        transaction.setDebetAccount(AccountDao.findById(new Integer(req.getParameter("debet_id"))));
        transaction.setCreditAccount(AccountDao.findById(new Integer(req.getParameter("credit_id"))));
//        transaction.setSum(new Long(req.getParameter("sum")));
        transaction.setSum(1.0);
        TransactionDao.save(transaction);
        resp.sendRedirect("/transactions");
    }
}
