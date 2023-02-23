package it.unisa.progettois.docapp.logic;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import it.unisa.progettois.docapp.R;
import it.unisa.progettois.docapp.data.Documenti_VisualizzatiDAO;
import it.unisa.progettois.docapp.data.Documento;
import it.unisa.progettois.docapp.data.Studente;

public class HomepageActivity extends AppCompatActivity{
    Button bottoneFiltro;
    ImageView carica, profilo, chat;
    Studente studente;
    ListView listView_documenti_pertinenti;
    Documenti_VisualizzatiDAO documenti_visualizzatiDAO;
    ItemAdapaterDocumenti item;
    RecyclerView recyclerViewF, recyclerViewU, recyclerViewD;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedIstanceState) {
        super.onCreate(savedIstanceState);
        setContentView(R.layout.layout_homepage);

        studente = (Studente) getIntent().getSerializableExtra("studente");
        bottoneFiltro = findViewById(R.id.bottoneFiltro);
        carica = findViewById(R.id.iconaCarica);
        profilo = findViewById(R.id.iconaProfilo);
        chat = findViewById(R.id.iconaChat);
        //listView_documenti_pertinenti = findViewById(R.id.documenti_pertinenti);
        recyclerViewF = findViewById(R.id.rvFacolta);
        recyclerViewU = findViewById(R.id.rvUniversita);



        //Implementazione lista facoltà
        Resources resFacolta = getResources();
        String[] itemsFacolta = resFacolta.getStringArray(R.array.spinner_facolta);
        HorizontalAdapterF horizontalAdapterF = new HorizontalAdapterF(itemsFacolta);
        LinearLayoutManager linearLayoutManagerF = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewF.setLayoutManager(linearLayoutManagerF);
        recyclerViewF.addItemDecoration(new HorizontalSpaceItemDecoration(20));
        recyclerViewF.setAdapter(horizontalAdapterF);


        //Implementazione lista università
        Resources resUniversita = getResources();
        String[] itemsUniversita = resUniversita.getStringArray(R.array.spinner_universita);
        HorizontalAdapterU horizontalAdapterU = new HorizontalAdapterU(itemsUniversita);
        LinearLayoutManager linearLayoutManagerU = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewU.setLayoutManager(linearLayoutManagerU);
        recyclerViewU.addItemDecoration(new HorizontalSpaceItemDecoration(20));
        recyclerViewU.setAdapter(horizontalAdapterU);


        //Listaview documenti pertinenti homepage
        documenti_visualizzatiDAO = new Documenti_VisualizzatiDAO(getApplicationContext());
        List<Documento> documenti_pertinenti = documenti_visualizzatiDAO.getDocumentiPertinenti();

        recyclerViewD = findViewById(R.id.rvDocumentiPertinenti);
        recyclerViewD.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerViewD.addItemDecoration(new HorizontalSpaceItemDecoration(20));
        HorizontalAdapterD horizontalAdapterD = new HorizontalAdapterD(this, documenti_pertinenti);
        recyclerViewD.setAdapter(horizontalAdapterD);



        /*item = new ItemAdapaterDocumenti(getApplicationContext(), documenti_pertinenti);
        listView_documenti_pertinenti.setAdapter(item);

        listView_documenti_pertinenti.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DocumentoActivity.class);
                Documento documento = (Documento) parent.getItemAtPosition(position);
                intent.putExtra("documento", documento);
                startActivity(intent);
            }
        });*/

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
