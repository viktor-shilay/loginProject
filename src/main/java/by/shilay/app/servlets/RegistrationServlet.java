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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        this.userService = new UserServiceImpl(new UserDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/registration.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String birthdate = request.getParameter("birthdate");
        User user = new User(login,password, birthdate);
        try {
            userService.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setAttribute("login", login);
        response.sendRedirect("/hello");
    }
}
