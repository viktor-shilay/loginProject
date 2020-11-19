package by.shilay.app.servlets;

import by.shilay.app.dao.UserDaoImpl;
import by.shilay.app.model.User;
import by.shilay.app.service.UserService;
import by.shilay.app.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(urlPatterns = "/users")
public class UsersServlet extends HttpServlet {
    private UserService userService;


    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl(new UserDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = null;
        try {
            users = userService.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("users", users);
        request.getRequestDispatcher("users.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
