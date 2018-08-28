package com.example.andreoliveira.biblio.domain;

import java.io.Serializable;

public class Reservation implements Serializable
{
    private Client client;
    private Book book;

   public Reservation(Client client, Book book)
   {
       this.client = client;
       this.book = book;
   }

    public Client getClient()
    {
        return client;
    }

    public void setClient(Client client)
    {
        this.client = client;
    }

    public Book getBook()
    {
        return book;
    }

    public void setBook(Book book)
    {
        this.book = book;
    }
}
