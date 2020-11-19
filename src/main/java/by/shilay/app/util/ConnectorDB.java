package by.shilay.app.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectorDB {
    public Connection getConnection(){
        Properties properties = new Properties();
        Connection connection = null;
        try {
            properties.load(ConnectorDB.class.getResourceAsStream("/db.properties"));
            String dbUrl = properties.getProperty("db.url");
            String dbUser = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");
            String dbDriverClassName = properties.getProperty("db.driverClassName");
            Class.forName(dbDriverClassName);
            connection = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
