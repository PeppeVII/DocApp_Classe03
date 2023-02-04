package it.unisa.progettois.docapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import it.unisa.progettois.docapp.dataTier.ConnectorDB;

public class AvvioApplicazione extends AppCompatActivity {
    Button registration, login;
    ConnectorDB connector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_apertura);


        connector = new ConnectorDB();
        login = (Button) findViewById(R.id.bottonePerLogin);
        registration = (Button) findViewById(R.id.bottonePerRegistrazione);

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegistrazioneActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}