package com.itacademy.zenkou.jdb2project.servlet.servlet;

import com.itacademy.zenkou.jdb2project.entity.db.User;
import com.itacademy.zenkou.jdb2project.service.UserService.UserService;
import com.itacademy.zenkou.jdb2project.service.helper.PathHelper;
import com.itacademy.zenkou.jdb2project.servlet.util.PageUtil;
import com.itacademy.zenkou.jdb2project.utils.filter.UserFilter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static com.itacademy.zenkou.jdb2project.servlet.util.ServletParameterConstant.CURRENT_PAGE;
import static com.itacademy.zenkou.jdb2project.servlet.util.ServletParameterConstant.LIMIT;
import static com.itacademy.zenkou.jdb2project.servlet.util.ServletParameterConstant.NAME;
import static com.itacademy.zenkou.jdb2project.servlet.util.ServletParameterConstant.OFFSET;
import static com.itacademy.zenkou.jdb2project.servlet.util.ServletParameterConstant.PAGE_NUMBER;
import static com.itacademy.zenkou.jdb2project.servlet.util.ServletParameterConstant.RECORDS_PER_PAGE;
import static com.itacademy.zenkou.jdb2project.servlet.util.ServletParameterConstant.SURNAME;

@WebServlet(name = "user", urlPatterns = "/user")
public class UserServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        List<User> users = userService.getUsers();
        req.setAttribute("users", users);
        getServletContext().getRequestDispatcher(PathHelper.getPath("UserPag"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        LocalDate birthDate = PageUtil.resolveDate(req);
        UserFilter userFilter = UserFilter.builder()
                .name(req.getParameter(NAME))
                .birthDate(birthDate)
                .surname(req.getParameter(SURNAME))
                .limit(Integer.valueOf(req.getParameter(LIMIT)))
                .offset(Integer.valueOf(req.getParameter(OFFSET)))
                .build();

        List<User> users = userService.getUserByUserFilter(userFilter);
        int currentPage = Integer.valueOf(req.getParameter(CURRENT_PAGE));
        int recordsPerPage = Integer.valueOf(req.getParameter(RECORDS_PER_PAGE));

        req.setAttribute(PAGE_NUMBER, PageUtil.calculatePageNumber(users, recordsPerPage));
        req.setAttribute(CURRENT_PAGE, currentPage);
        req.setAttribute(RECORDS_PER_PAGE, recordsPerPage);
        req.setAttribute("users", users);

        getServletContext().getRequestDispatcher(PathHelper.getPath("UserPag"))
                .forward(req, resp);
    }
}
