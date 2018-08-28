package com.example.andreoliveira.biblio.db;

import com.example.andreoliveira.biblio.domain.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDB
{
    public List<Book> list() throws SQLException
    {
        List<Book> books = new ArrayList<Book>();

        try
        {
            Connection connection = DataBaseConnection.getDBConnection();

            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM myBanq.Livre");

            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next())
            {
                Book book = new Book();
                book.setId(rs.getLong("id_Livre"));
                book.setTitle(rs.getString("titre"));;

                books.add(book);
            }

        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        return books;
    }
}
