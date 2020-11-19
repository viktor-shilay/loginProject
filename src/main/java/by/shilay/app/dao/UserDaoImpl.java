package by.shilay.app.dao;

import by.shilay.app.model.User;
import by.shilay.app.util.ConnectorDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    //language=SQL
    private final String SQL_SELECT_ALL_USERS = "SELECT * FROM user";
    //language=SQL
    private final String SQL_INSERT_USER = "INSERT INTO user (login, password,birthDate) VALUES (?,?,?)";
    //language=SQL
    private final String SQL_UPDATE_USER = "UPDATE user SET name = ?, password = ?, birthDate = ? WHERE id = ?";
    //language=SQL
    private final String SQL_DELETE_USER = "DELETE FROM user WHERE id=?";
    //language=SQL
    private final String SQL_SELECT_USER = "SELECT * FROM user WHERE login=? AND password=?";

    @Override
    public List<User> getAllUsers() throws SQLException {
        Connection connection = new ConnectorDB().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_USERS);
        List<User> users = createUsers(resultSet);
        connection.close();
        return users;
    }

    @Override
    public void addUser(User user) throws SQLException {
        Connection connection = new ConnectorDB().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USER);
        preparedStatement.setString(1,user.getLogin());
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.setString(3, user.getBirthdate());
        preparedStatement.execute();

    }

    @Override
    public void updateUser(User user) throws SQLException{
        Connection connection = new ConnectorDB().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_USER);
        preparedStatement.setString(1,user.getLogin());
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.setString(3, user.getBirthdate());
        preparedStatement.setInt(4,user.getId());
        preparedStatement.execute();
    }

    @Override
    public void deleteUser(int id) throws SQLException{
        Connection connection = new ConnectorDB().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_USER);
        preparedStatement.setInt(1,id);
        preparedStatement.execute();
    }

    private List<User> createUsers (ResultSet resultSet) throws SQLException {
        List<User> users = new ArrayList<>();
        while(resultSet.next()){
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setBirthdate(resultSet.getString("birthDate"));
            users.add(user);
        }
        return users;
    }

    @Override
    public boolean isExistUser(String login, String password) throws SQLException {
        Connection connection = new ConnectorDB().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_USER);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }
}
