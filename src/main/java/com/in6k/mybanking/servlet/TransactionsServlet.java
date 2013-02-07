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
        try {
            double sum = Double.parseDouble(req.getParameter("sum"));
            Account creditAccount = AccountDao.findById(new Integer(req.getParameter("credit_id")));
            if (creditAccount.getUser().isSystem() || sum < AccountDao.calculateSum(creditAccount)) {
                Transaction transaction = new Transaction();
                transaction.setDebetAccount(AccountDao.findById(new Integer(req.getParameter("debet_id"))));
                transaction.setCreditAccount(creditAccount);
                transaction.setSum(sum);
                TransactionDao.save(transaction);
            } else {
//                show message
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/transactions");
    }
}
