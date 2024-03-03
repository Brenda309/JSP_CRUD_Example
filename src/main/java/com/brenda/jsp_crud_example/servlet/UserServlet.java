package com.brenda.jsp_crud_example.servlet;

import com.brenda.jsp_crud_example.bean.User;
import com.brenda.jsp_crud_example.doa.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/adduser")
public class UserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("sex");
        String country = request.getParameter("country");

        User newUser = new User();
        newUser.setName(name);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.setGender(gender);
        newUser.setCountry(country);

        UserDao userDao = new UserDao();
        userDao.SaveUser(newUser);

        response.sendRedirect("viewusers.jsp");
    }
}

