package by.shilay.app.dao;

import by.shilay.app.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    List<User> getAllUsers() throws SQLException;

    void addUser(User user) throws SQLException;

    void updateUser(User user) throws SQLException;

    void deleteUser(int id) throws SQLException;

    boolean isExistUser(String login, String password) throws SQLException;
}
