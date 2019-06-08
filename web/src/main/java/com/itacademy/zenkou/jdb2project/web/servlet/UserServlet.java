package com.itacademy.zenkou.jdb2project.web.servlet;

import com.itacademy.zenkou.jdb2project.database.entity.db.User;
import com.itacademy.zenkou.jdb2project.service.filter.dto.UserFilterDto;
import com.itacademy.zenkou.jdb2project.service.service.UserService;
import com.itacademy.zenkou.jdb2project.web.config.WebConfig;
import com.itacademy.zenkou.jdb2project.web.helper.PathHelper;
import com.itacademy.zenkou.jdb2project.web.util.PageUtil;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.itacademy.zenkou.jdb2project.web.util.ServletParameterConstant.BIRTH_DATE;
import static com.itacademy.zenkou.jdb2project.web.util.ServletParameterConstant.CURRENT_PAGE;
import static com.itacademy.zenkou.jdb2project.web.util.ServletParameterConstant.LIMIT;
import static com.itacademy.zenkou.jdb2project.web.util.ServletParameterConstant.NAME;
import static com.itacademy.zenkou.jdb2project.web.util.ServletParameterConstant.OFFSET;
import static com.itacademy.zenkou.jdb2project.web.util.ServletParameterConstant.PAGE_NUMBER;
import static com.itacademy.zenkou.jdb2project.web.util.ServletParameterConstant.RECORDS_PER_PAGE;
import static com.itacademy.zenkou.jdb2project.web.util.ServletParameterConstant.SURNAME;
import static com.itacademy.zenkou.jdb2project.web.util.ServletParameterConstant.USERS;

@WebServlet(name = "user", urlPatterns = "/user")
public class UserServlet extends HttpServlet {

    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
    private UserService userService = context.getBean(UserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        List<User> users = userService.findAll();
        req.setAttribute(USERS, users);
        getServletContext().getRequestDispatcher(PathHelper.getPath("UserPag"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        UserFilterDto userFilter = UserFilterDto.builder()
                .name(req.getParameter(NAME))
                .birthDate(req.getParameter(BIRTH_DATE))
                .surname(req.getParameter(SURNAME))
                .limit(req.getParameter(LIMIT))
                .offset(req.getParameter(OFFSET))
                .build();

        List<User> users = userService.getUsersByFilter(userFilter);
        int currentPage = Integer.valueOf(req.getParameter(CURRENT_PAGE));
        int recordsPerPage = Integer.valueOf(req.getParameter(RECORDS_PER_PAGE));

        req.setAttribute(PAGE_NUMBER, PageUtil.calculatePageNumber(users, recordsPerPage));
        req.setAttribute(CURRENT_PAGE, currentPage);
        req.setAttribute(RECORDS_PER_PAGE, recordsPerPage);
        req.setAttribute(USERS, users);

        getServletContext().getRequestDispatcher(PathHelper.getPath("UserPag"))
                .forward(req, resp);
    }
}
