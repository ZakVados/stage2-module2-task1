package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.example.User;
import com.example.Warehouse;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
    private Warehouse warehouse = Warehouse.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(
                req.getParameter("firstName"),
                req.getParameter("lastName")
        );

        warehouse.addUser(user);
        req.setAttribute("user", user);

        req.getRequestDispatcher("jsp/add.jsp").forward(req, resp);
    }
}