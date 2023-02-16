package it.unisa.progettois.docapp.logic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import it.unisa.progettois.docapp.R;
import it.unisa.progettois.docapp.models.Studente;


public class HomepageActivity extends AppCompatActivity
{
    Button bottoneFiltro;
    ImageView carica, profilo, chat;
    Studente studente;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedIstanceState) {
        super.onCreate(savedIstanceState);
        setContentView(R.layout.layout_homepage);

        bottoneFiltro = findViewById(R.id.bottoneFiltro);
        carica = findViewById(R.id.iconaCarica);
        profilo = findViewById(R.id.iconaProfilo);
        chat = findViewById(R.id.iconaChat);
        listView = findViewById(R.id.documenti_pertinenti);
        chat.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
            startActivity(intent);
        });
    }


}
