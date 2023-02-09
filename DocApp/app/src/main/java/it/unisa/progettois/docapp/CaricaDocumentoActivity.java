package it.unisa.progettois.docapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import it.unisa.progettois.docapp.data.Caricamento;
import it.unisa.progettois.docapp.data.CaricamentoDAO;
import it.unisa.progettois.docapp.data.Documento;
import it.unisa.progettois.docapp.data.DocumentoDAO;
import it.unisa.progettois.docapp.data.Studente;
import it.unisa.progettois.docapp.data.StudenteDAO;
import it.unisa.progettois.docapp.facade.Facade;

public class CaricaDocumentoActivity extends AppCompatActivity {
    ImageView iconaHome, iconaChat, iconaProfilo;
    Button carica;
    EditText nomeDocumento, descrizioneDocumento;
    Spinner spinnerUniversita, spinnerFacolta, spinnerInsegnamento;
    String universita_scelta, facolta_scelta, insegnamento_scelto, pdf_path, nomeD, descrizioneD;
    String[] stringArray = {"dio cane", "cazzo", "vaffanculo", "negro", "deficiente", "menomato", "handicappato", "frocio", "ritardato", "mongoloide", "muori", "ucciditi", "puttana", "dio stronzo", "dio infame", "dio porco", "zoccola"};
    List<String> list = Arrays.asList(stringArray);
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    StudenteDAO studenteDAO;
    Uri uri;
    private int weight_pdf;
    private static final int PICK_PDF_CODE = 1;
    private Facade facade;
    private DocumentoDAO documentoDAO;
    private Studente studente;

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
        facade = new CaricamentoDAO(getApplicationContext());
        documentoDAO = new DocumentoDAO(getApplicationContext());
        sharedPreferences = getSharedPreferences("MY_SHARED_PREF", 0);
        studenteDAO = new StudenteDAO(getApplicationContext());
        studente = studenteDAO.effettuaLogin(sharedPreferences.getString("email", ""), sharedPreferences.getString("password", ""));

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

    public void updateDocumento(View view){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("application/pdf");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, PICK_PDF_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_PDF_CODE && resultCode == RESULT_OK && data != null && data.getData() != null){
            uri = data.getData();
            pdf_path = uri.getPath();
            File file = new File(pdf_path);
            weight_pdf = (int )file.length();
            Toast.makeText(this, "File path: " + pdf_path, Toast.LENGTH_SHORT).show();
        }
    }

    public void caricamento(View v){
        try {
            nomeD = nomeDocumento.getText().toString();
            Log.d("nomeDocumento", "Boh: " + nomeD);
            descrizioneD = descrizioneDocumento.getText().toString();
            universita_scelta = spinnerUniversita.getSelectedItem().toString();
            facolta_scelta = spinnerFacolta.getSelectedItem().toString();
            insegnamento_scelto = spinnerInsegnamento.getSelectedItem().toString();

            if(nomeD.length() > 70 || nomeD.isEmpty())
                Toast.makeText(this, "La stringa del titolo supera i 70 caratteri o è vuota", Toast.LENGTH_LONG).show();

            if(list.contains(nomeD))
                Toast.makeText(this, "Non si dicono queste parole birbantello", Toast.LENGTH_LONG).show();

            if(descrizioneD.isEmpty() || descrizioneD.length() > 650)
                Toast.makeText(this, "Formato Stringa della descrizione troppo lunga o vuota", Toast.LENGTH_LONG).show();

            else if(list.contains(descrizioneD))
                Toast.makeText(this, "Non si dicono queste parole birbantello", Toast.LENGTH_LONG).show();

            else if(pdf_path.isEmpty() || pdf_path.length() == 0)
                Toast.makeText(this, "Perfavore inserire un documento da caricare", Toast.LENGTH_LONG).show();

            Documento d = documentoDAO.inserisciDocumento(nomeD, descrizioneD, universita_scelta, facolta_scelta, insegnamento_scelto, pdf_path, weight_pdf);
            boolean tmp = facade.inserisci(d.getId_documento(), studente.getEmail());
            Caricamento caricamento = (Caricamento) facade.ottieni(d.getId_documento(), studente.getEmail());

            if(d != null || tmp) {
                Toast.makeText(this, "Documento caricato con successo", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), HomepageActivity.class);
                startActivity(intent);
            }
        }catch (Exception exc){
            Toast.makeText(this, "Errore nel caricamento del file", Toast.LENGTH_LONG).show();
            Log.d("eccezione", exc.getMessage());
        }
    }
}
