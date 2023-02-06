package it.unisa.progettois.docapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import it.unisa.progettois.docapp.data.Studente;

public class HomepageActivity extends AppCompatActivity
{
    Button bottoneFiltro;
    ImageView carica, profilo, chat;
    Studente studente;

    @Override
    protected void onCreate(Bundle savedIstanceState) {
        super.onCreate(savedIstanceState);
        setContentView(R.layout.layout_homepage);

        studente = (Studente) getIntent().getSerializableExtra("studente");
        bottoneFiltro = findViewById(R.id.bottoneFiltro);
        carica = findViewById(R.id.iconaCarica);
        profilo = findViewById(R.id.iconaProfilo);
        chat = findViewById(R.id.iconaChat);

        profilo.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ProfiloActivity.class);
            startActivity(intent);
        });

        carica.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), CaricaDocumentoActivity.class);
            startActivity(intent);
        });
    }

    public void cercaDocumenti(View view){
        Intent intent = new Intent(getApplicationContext(), RicercaDocumentoActivity.class);
        startActivity(intent);
    }
}
