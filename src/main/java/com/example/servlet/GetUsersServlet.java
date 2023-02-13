package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.example.User;
import com.example.Warehouse;

@WebServlet("/users")
public class GetUsersServlet extends HttpServlet {
    Warehouse warehouse = Warehouse.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", warehouse.getUsers());

        req.getRequestDispatcher("jsp/users.jsp").forward(req, resp);
    }
}
