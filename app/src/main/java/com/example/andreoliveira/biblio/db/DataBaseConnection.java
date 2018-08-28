package com.example.andreoliveira.biblio.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection
{
    public static Connection getDBConnection() throws ClassNotFoundException, SQLException
    {
        Connection connection;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://10.0.2.2:3306/myBanq", "root", "root");

            return connection;
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            throw e;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            throw e;
        }
    }

}
