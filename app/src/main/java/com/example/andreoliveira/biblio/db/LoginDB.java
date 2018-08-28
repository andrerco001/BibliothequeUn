package com.example.andreoliveira.biblio.db;

import com.example.andreoliveira.biblio.domain.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDB
{
    public Client auth(Client client) throws SQLException
    {
        try
        {
            Connection connection = DataBaseConnection.getDBConnection();

            StringBuilder query = new StringBuilder();

            query.append("SELECT * FROM myBanq.Client WHERE ");
            query.append("usager = ? AND motDePasse = ?");

            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());

            preparedStatement.setString(1, client.getUsager());
            preparedStatement.setString(2, client.getMotDePasse());

            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next())
            {
                client.setNom(rs.getString("nom"));
                client.setTelephone(rs.getString("telephone"));
            }
        }
        catch (ClassNotFoundException classNotFoundException)
        {
            classNotFoundException.printStackTrace();
            return null;
        }

        return  client;
    }
}
