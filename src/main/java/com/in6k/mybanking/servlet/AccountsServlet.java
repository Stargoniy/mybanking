package com.in6k.mybanking.servlet;

import com.in6k.mybanking.dao.AccountDao;
import com.in6k.mybanking.dao.UserDao;
import com.in6k.mybanking.entity.Account;
import com.in6k.mybanking.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AccountsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = UserDao.findAll();
        req.setAttribute("users", users);

        List<Account> accounts = AccountDao.findAll();
        for (Account a : accounts) {
            a.setSum(AccountDao.CalculateSum(a));
        }
        req.setAttribute("accounts", accounts);
        req.getRequestDispatcher("/accounts.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account account = new Account();
        account.setName(req.getParameter("name"));
        account.setUser(UserDao.findById(new Integer(req.getParameter("user_id"))));
        AccountDao.save(account);
        resp.sendRedirect("/accounts");
    }
}
