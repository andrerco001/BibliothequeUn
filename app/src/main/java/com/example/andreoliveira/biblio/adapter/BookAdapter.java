package com.example.andreoliveira.biblio.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.andreoliveira.biblio.R;
import com.example.andreoliveira.biblio.domain.Book;

import java.util.List;

public class BookAdapter extends BaseAdapter
{
    private List<Book> books;
    private LayoutInflater mInflater;
    private Context context;

    public BookAdapter(Context context, List<Book> books)
    {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.books = books;
    }

    @Override
    public int getCount()
    {
        return books.size();
    }

    @Override
    public Object getItem(int position)
    {
        return books.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        convertView = mInflater.inflate(R.layout.adapter_book, null);

        if (books.get(position) != null)
        {
            final TextView tvBook = convertView.findViewById(R.id.tvBook);
            tvBook.setText(books.get(position).getTitle());
        }

        return convertView;
    }
}
