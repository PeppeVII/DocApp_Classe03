package it.unisa.progettois.docapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CaricaDocumentoActivity extends AppCompatActivity {
    ImageView iconaHome, iconaChat, iconaProfilo;
    Button carica;
    EditText nomeDocumento, nomeUniversita, nomeFacolta, nomeInsegnamento;
    Spinner spinnerUniversita, spinnerFacolta;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_caricadocumento);

        //Binding
        iconaHome = findViewById(R.id.iconaHome);
        iconaChat = findViewById(R.id.iconaChat);
        iconaProfilo = findViewById(R.id.iconaProfilo);
        carica = findViewById(R.id.buttonCarica);
        nomeDocumento = findViewById(R.id.nomeDocumento);
        spinnerUniversita = findViewById(R.id.spinnerUniversita);
        spinnerFacolta = findViewById(R.id.spinnerFacolta);

        //Listener icone barra menu footer
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

        //Implementazione arrayAdapter spinner Università
        ArrayAdapter<CharSequence> adapterU = ArrayAdapter.createFromResource(this,
                R.array.spinner_universita, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinnerUniversita.setAdapter(adapterU);
        spinnerUniversita.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String txt = spinnerUniversita.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), "Spinner text: " + txt, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        //Implementazione arrayAdapter spinner Facoltà
        ArrayAdapter<CharSequence> adapterF = ArrayAdapter.createFromResource(this,
                R.array.spinner_facolta, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinnerFacolta.setAdapter(adapterF);
        spinnerFacolta.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String txt = spinnerFacolta.getSelectedItem().toString();
                switch (txt){
                    case "Informatica":

                        break;
                    case "Ingegneria Informatica":
                        break;
                    case "Matematica":
                        break;
                    case "Fisica":
                        break;
                    case "Biologia":
                        break;
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });


    }

    public void caricamento(View v){
        String nomeD = nomeDocumento.getText().toString();
        String nomeU = nomeUniversita.getText().toString();
        String nomeF = nomeFacolta.getText().toString();
    }
}
