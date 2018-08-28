package com.example.andreoliveira.biblio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.andreoliveira.biblio.domain.Client;
import com.example.andreoliveira.biblio.tasks.LoginTask;
import com.example.andreoliveira.biblio.util.Encoding;

import java.security.NoSuchAlgorithmException;

public class Login extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etUsager = findViewById(R.id.etUsager);
        final EditText etModDePasse = findViewById(R.id.etModDePasse);
        final Button buttonConnection = findViewById(R.id.buttonConnection);

        buttonConnection.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                System.out.println("click !!!!");

                Client client = new Client();
                client.setUsager(etUsager.getText().toString());
               // try
                // {
                    //client.setMotDePasse(Encoding.encoding(etModDePasse.getText().toString()));
                    client.setMotDePasse(etModDePasse.getText().toString());
               /* }
               catch (NoSuchAlgorithmException n)
               {
                    n.printStackTrace();
                }*/

                new LoginTask(Login.this).execute(client);
            }
        });
    }

    public void returnLoginTask(Client client)
    {
        if (client != null)
        {
            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("client", client);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "fail", Toast.LENGTH_LONG).show();
        }
    }
}
