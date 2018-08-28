package com.example.andreoliveira.biblio.tasks;

import android.os.AsyncTask;

import com.example.andreoliveira.biblio.Login;
import com.example.andreoliveira.biblio.db.LoginDB;
import com.example.andreoliveira.biblio.domain.Client;

import java.sql.SQLException;

public class LoginTask extends AsyncTask<Client, Void, Client>
{
    private Login login;

    public LoginTask (Login login)
    {
        this.login = login;
    }

    @Override
    protected Client doInBackground(Client... clients)
    {
        try
        {
            return new LoginDB().auth(clients[0]);
        }
        catch (SQLException sqlException)
        {
            return null;
        }
    }

    @Override
    protected void onPostExecute(Client client)
    {
        super.onPostExecute(client);
        login.returnLoginTask(client);
    }
}
