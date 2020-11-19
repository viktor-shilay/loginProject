package by.shilay.app.service;

import by.shilay.app.dao.UserDao;
import by.shilay.app.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserServiceImpl implements UserService {

    private static Logger LOG = Logger.getLogger(UserService.class.getName());

    private final UserDao userdao;

    public UserServiceImpl(UserDao userDao){
        this.userdao = userDao;
    }


    @Override
    public List<User> getAllUsers() throws SQLException {
        LOG.log(Level.INFO, "getAllUsers() method was called!");
        List<User> allUsers = userdao.getAllUsers();
        return allUsers;
    }

    @Override
    public void addUser(User user) throws SQLException {
        LOG.log(Level.INFO, "addUser() method was called!");
        userdao.addUser(user);
    }

    @Override
    public void updateUser(User user) throws SQLException {
        LOG.log(Level.INFO, "updateUser() method was called!");
        userdao.updateUser(user);
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        LOG.log(Level.INFO, "deleteUser() method was called!");
        userdao.deleteUser(id);
    }

    @Override
    public boolean isExistUser(String login, String password) throws SQLException {
        LOG.log(Level.INFO, "isExistLogin() method was called!");
        return userdao.isExistUser(login, password);
    }
}
