package org.example;


import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.SessionFactory;
import org.testng.internal.Configuration;

import java.sql.*;
import java.util.Random;

public class Main {
    private final static Random random = new Random();

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "Lerudc228";

        try {
            Connection connection = DriverManager.getConnection(url,user,password);

            createDatabase(connection);
            System.out.println("Database ok");

            useDatabase(connection);
            System.out.println("Use database ok");

            createTable(connection);
            System.out.println("Create table");

            int count = random.nextInt(5,11);
            for (int i = 0; i < count; i++) {
                insertData(connection,Person.create());
                System.out.println("Insert data ok");
            }

            connection.close();
            System.out.println("Database closet");

        } catch (SQLException e){
            e.printStackTrace();
        }

    }
    private static void createDatabase(Connection connection) throws SQLException{
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS studentDB;";
        try(PreparedStatement statement = connection.prepareStatement(createDatabaseSQL)) {
            statement.execute();
        }
    }

    private static void useDatabase(Connection connection) throws SQLException{
        String useDatabaseSQL = "USE studentDB;";
        try (PreparedStatement statement = connection.prepareStatement(useDatabaseSQL)){
            statement.execute();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS student (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), age INT);";
        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)){
            statement.execute();
        }
    }

    private static void insertData(Connection connection, Person person) throws SQLException{
        String insertDataSQL = "INSERT INTO student (name,age) VALUE(?,?);";
        try (PreparedStatement statement = connection.prepareStatement(insertDataSQL)){
            statement.setString(1, person.name());
            statement.setInt(2,person.age());
            statement.executeUpdate();
        }
    }
}