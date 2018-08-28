package com.example.andreoliveira.biblio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.andreoliveira.biblio.adapter.BookAdapter;
import com.example.andreoliveira.biblio.domain.Book;
import com.example.andreoliveira.biblio.domain.Client;
import com.example.andreoliveira.biblio.domain.Reservation;
import com.example.andreoliveira.biblio.tasks.BookTask;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity
{
    List<Book> lstBook;

    private Client client;
    private ListView lvBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lvBooks = findViewById(R.id.lvBooks);
        client = (Client)getIntent().getSerializableExtra("client");

        new BookTask(this).execute();

      /*  lstBook = new ArrayList<>();
        lstBook.add(new Book("Amor y Familia","Categorie Book","Description book",R.drawable.amoryfamilia));
        lstBook.add(new Book("Far from Home","Categorie Book","Description book",R.drawable.farfromhome));
        lstBook.add(new Book("Flow","Categorie Book","Description book",R.drawable.flow));
        lstBook.add(new Book("Gelo Negro","Categorie Book","Description book",R.drawable.gelonegro));
        lstBook.add(new Book("Hackers","Categorie Book","Description book",R.drawable.hackers));
        lstBook.add(new Book("La locura mortal","Categorie Book","Description book",R.drawable.lacuramortal));
        lstBook.add(new Book("La loi du phajaan","Categorie Book","Description book",R.drawable.laloiduphajaan));
        lstBook.add(new Book("La plantation","Categorie Book","Description book",R.drawable.laplantation));
        lstBook.add(new Book("Les 100","Categorie Book","Description book",R.drawable.le100));
        lstBook.add(new Book("Le choix d'une vie","Categorie Book","Description book",R.drawable.lechoix));
        lstBook.add(new Book("Medical Embryology","Categorie Book","Description book",R.drawable.medical));
        lstBook.add(new Book("Barb ès mon amour","Categorie Book","Description book",R.drawable.monamour));
        lstBook.add(new Book("Un acto de amor","Categorie Book","Description book",R.drawable.unactodeamor));
        lstBook.add(new Book("Unforgiven","Categorie Book","Description book",R.drawable.unforgiven));

        // Second part

        lstBook.add(new Book("Amor y Familia","Categorie Book","Description book",R.drawable.amoryfamilia));
        lstBook.add(new Book("Far from Home","Categorie Book","Description book",R.drawable.farfromhome));
        lstBook.add(new Book("Flow","Categorie Book","Description book",R.drawable.flow));
        lstBook.add(new Book("Gelo Negro","Categorie Book","Description book",R.drawable.gelonegro));
        lstBook.add(new Book("Hackers","Categorie Book","Description book",R.drawable.hackers));
        lstBook.add(new Book("La locura mortal","Categorie Book","Description book",R.drawable.lacuramortal));
        lstBook.add(new Book("La loi du phajaan","Categorie Book","Description book",R.drawable.laloiduphajaan));
        lstBook.add(new Book("La plantation","Categorie Book","Description book",R.drawable.laplantation));
        lstBook.add(new Book("Les 100","Categorie Book","Description book",R.drawable.le100));
        lstBook.add(new Book("Le choix d'une vie","Categorie Book","Description book",R.drawable.lechoix));
        lstBook.add(new Book("Medical Embryology","Categorie Book","Description book",R.drawable.medical));
        lstBook.add(new Book("Barb ès mon amour","Categorie Book","Description book",R.drawable.monamour));
        lstBook.add(new Book("Un acto de amor","Categorie Book","Description book",R.drawable.unactodeamor));
        lstBook.add(new Book("Unforgiven","Categorie Book","Description book",R.drawable.unforgiven));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstBook);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);*/

    }

    public void clickExit(View v)
    {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);

    }

    public void returnBookTask(final List<Book> books)
    {
        BookAdapter livreAdapter = new BookAdapter(getApplicationContext(),books);
        lvBooks.setAdapter(livreAdapter);

        lvBooks.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Reservation reservation = new Reservation(client, books.get(i));

                Intent intent = new Intent(HomeActivity.this, Book_Activity.class);
                intent.putExtra("reservation", reservation);
                startActivity(intent);
            }
        });
    }
}
