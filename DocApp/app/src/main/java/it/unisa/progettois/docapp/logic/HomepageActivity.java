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
import it.unisa.progettois.docapp.data.Documenti_VisualizzatiDAO;

public class HomepageActivity extends AppCompatActivity
{
    Button bottoneFiltro;
    ImageView carica, profilo, chat;
    Studente studente;
    ListView listView;
    Documenti_VisualizzatiDAO documenti_visualizzatiDAO;
    ItemAdapaterDocumenti item;

    @Override
    protected void onCreate(Bundle savedIstanceState) {
        super.onCreate(savedIstanceState);
        setContentView(R.layout.layout_homepage);

        studente = (Studente) getIntent().getSerializableExtra("studente");
        bottoneFiltro = findViewById(R.id.bottoneFiltro);
        carica = findViewById(R.id.iconaCarica);
        profilo = findViewById(R.id.iconaProfilo);
        chat = findViewById(R.id.iconaChat);
        listView = findViewById(R.id.documenti_pertinenti);

        documenti_visualizzatiDAO = new Documenti_VisualizzatiDAO(getApplicationContext());
        List<Documento> documenti_pertinenti = documenti_visualizzatiDAO.getDocumentiPertinenti();

        item = new ItemAdapaterDocumenti(getApplicationContext(), documenti_pertinenti);
        listView.setAdapter(item);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DocumentoActivity.class);
                Documento documento = (Documento) parent.getItemAtPosition(position);
                intent.putExtra("documento", documento);
                startActivity(intent);
            }
        });

        profilo.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ProfiloActivity.class);
            startActivity(intent);
        });

        carica.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), CaricaDocumentoActivity.class);
            startActivity(intent);
        });

        chat.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
            startActivity(intent);
        });
    }

    public void cercaDocumenti(View view){
        Intent intent = new Intent(getApplicationContext(), RicercaDocumentoActivity.class);
        startActivity(intent);
    }
}
