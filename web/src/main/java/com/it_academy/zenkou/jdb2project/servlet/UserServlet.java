package com.it_academy.zenkou.jdb2project.servlet;

import com.it_academy.zenkou.jdb2project.entity.User;
import com.it_academy.zenkou.jdb2project.service.UserService.UserService;
import com.it_academy.zenkou.jdb2project.service.helper.PathHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userService.getUsers();
        req.setAttribute("users", users);
        getServletContext().getRequestDispatcher(PathHelper.getPath("User"))
                .forward(req, resp);
    }
}
