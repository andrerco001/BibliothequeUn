package com.example.andreoliveira.biblio.tasks;

import android.os.AsyncTask;

import com.example.andreoliveira.biblio.HomeActivity;
import com.example.andreoliveira.biblio.db.BookDB;
import com.example.andreoliveira.biblio.domain.Book;
import com.example.andreoliveira.biblio.domain.Client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookTask extends AsyncTask<Void, Void, List<Book>>
{

    private HomeActivity homeActivity;

    public BookTask(HomeActivity homeActivity)
    {
        this.homeActivity = homeActivity;
    }

    @Override
    protected List<Book> doInBackground(Void... voids)
    {
        try
        {
            return new BookDB().list();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return new ArrayList<Book>();
    }

    @Override
    protected void onPostExecute(List<Book> books)
    {
        super.onPostExecute(books);
        homeActivity.returnBookTask(books);
    }
}
