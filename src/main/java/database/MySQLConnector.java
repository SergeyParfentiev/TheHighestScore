package database;

import table.Country;
import table.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLConnector {
    private static MySQLConnector mySQLConnector;
    private static final String url = "jdbc:mysql://localhost:3306/thehighestscore";
    private static final String user = "root";
    private static final String password = "root";

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public static MySQLConnector getInstance() {
        if (mySQLConnector == null){
            mySQLConnector = new MySQLConnector();
        }
        return mySQLConnector;
    }

    public String getEmployeePassword(String login) {
        String password = null;
        connection = getConnection();
        String getPassword = "SELECT e.passwordHash FROM Employees e WHERE e.login = ?";
        try {
            preparedStatement = connection.prepareStatement(getPassword);
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                password = resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return password;
    }

    public List<Country> getCountries() {
        List<Country> countries = new ArrayList<>();
        connection = getConnection();
        String getCountries = "SELECT * FROM countries";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(getCountries);
            while (resultSet.next()) {
                countries.add(new Country(resultSet.getInt(1), resultSet.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return countries;
    }

    public List<Order> getOrders(int countryId) {
        List<Order> orders = new ArrayList<>();
        connection = getConnection();
        String getOrders = "SELECT e.fullName, r.name, SUM(o.cost) cost FROM Orders o " +
                "INNER JOIN Employees e ON e.login = o.employeeLogin INNER JOIN Regions r ON r.id = o.regionId " +
                "INNER JOIN Countries c ON c.id = r.countryId WHERE c.id = ? GROUP BY e.fullName, r.name";
        try {
            preparedStatement = connection.prepareStatement(getOrders);
            preparedStatement.setInt(1, countryId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orders.add(new Order(resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return orders;
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
