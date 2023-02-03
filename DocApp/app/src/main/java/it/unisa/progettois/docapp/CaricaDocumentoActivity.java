package it.unisa.progettois.docapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class CaricaDocumentoActivity extends AppCompatActivity {
    ImageView iconaHome, iconaChat, iconaProfilo;
    Button carica;
    EditText nomeDocumento, nomeUniversita, nomeFacolta, nomeInsegnamento;
    Spinner spinner;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_caricadocumento);

        iconaHome = findViewById(R.id.iconaHome);
        iconaChat = findViewById(R.id.iconaChat);
        iconaProfilo = findViewById(R.id.iconaProfilo);
        carica = findViewById(R.id.buttonCarica);
        nomeDocumento = findViewById(R.id.nomeDocumento);
        nomeUniversita = findViewById(R.id.nomeUniversita);
        nomeFacolta = findViewById(R.id.nomeFacolta);
        nomeInsegnamento = findViewById(R.id.nomeInsegnamento);
        spinner = findViewById(R.id.spinner);

        iconaHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomepageActivity.class);
                startActivity(intent);
            }
        });

        iconaChat.setOnClickListener(v -> {

        });

        iconaProfilo.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ProfiloActivity.class);
            startActivity(intent);
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_items, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

    }

    public void caricamento(View v){
        String nomeD = nomeDocumento.getText().toString();
        String nomeU = nomeUniversita.getText().toString();
        String nomeF = nomeFacolta.getText().toString();


    }
}
