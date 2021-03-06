package com.in6k.mybanking.servlet;

import com.in6k.mybanking.dao.UserDao;
import com.in6k.mybanking.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = UserDao.findAll();
        req.setAttribute("users", users);
        req.getRequestDispatcher("/users.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setName(req.getParameter("name"));
        user.setSystem("on".equals(req.getParameter("system")) ? true : false);
        UserDao.save(user);
        resp.sendRedirect("/users");
    }
}
