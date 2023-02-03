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
    EditText nomeDocumento, descrizioneDocumento;
    Spinner spinnerUniversita, spinnerFacolta, spinnerInsegnamento;
    String universita_scelta, facolta_scelta, insegnamento_scelto;

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
        descrizioneDocumento = findViewById(R.id.descrizioneDocumento);
        spinnerUniversita = findViewById(R.id.spinnerUniversita);
        spinnerFacolta = findViewById(R.id.spinnerFacolta);
        spinnerInsegnamento = findViewById(R.id.spinnerInsegnamento);

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
                universita_scelta = spinnerUniversita.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        //Implementazione arrayAdapter spinner Facoltà e Insegnamento
        ArrayAdapter<CharSequence> adapterF = ArrayAdapter.createFromResource(this,
                R.array.spinner_facolta, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinnerFacolta.setAdapter(adapterF);

        ArrayAdapter<CharSequence> adapterInformatica = ArrayAdapter.createFromResource(this,
                R.array.spinner_informatica, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapterIngegneria = ArrayAdapter.createFromResource(this,
                R.array.spinner_ingegneriaInformatica, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapterMatematica = ArrayAdapter.createFromResource(this,
                R.array.spinner_matematica, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapterFisica = ArrayAdapter.createFromResource(this,
                R.array.spinner_fisica, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapterBiologia = ArrayAdapter.createFromResource(this,
                R.array.spinner_biologia, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        spinnerFacolta.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                facolta_scelta = spinnerFacolta.getSelectedItem().toString();
                switch (facolta_scelta){
                    case "Informatica":
                        spinnerInsegnamento.setAdapter(adapterInformatica);
                        break;
                    case "Ingegneria Informatica":
                        spinnerInsegnamento.setAdapter(adapterIngegneria);
                        break;
                    case "Matematica":
                        spinnerInsegnamento.setAdapter(adapterMatematica);
                        break;
                    case "Fisica":
                        spinnerInsegnamento.setAdapter(adapterFisica);
                        break;
                    case "Biologia":
                        spinnerInsegnamento.setAdapter(adapterBiologia);
                        break;
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        spinnerInsegnamento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                insegnamento_scelto = spinnerInsegnamento.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void caricamento(View v){
        String nomeD = nomeDocumento.getText().toString();
        String descrizioneD = descrizioneDocumento.getText().toString();
    }
}
