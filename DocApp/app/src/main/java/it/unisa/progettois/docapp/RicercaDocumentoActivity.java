package it.unisa.progettois.docapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.List;

import it.unisa.progettois.docapp.data.Documento;
import it.unisa.progettois.docapp.data.DocumentoDAO;

public class RicercaDocumentoActivity extends AppCompatActivity {
    Spinner spinnerUniversita, spinnerFacolta, spinnerInsegnamento;
    String universita_scelta, facolta_scelta, insegnamento_scelto;
    private DocumentoDAO documentoDAO;

    @Override
    protected void onCreate(Bundle savedIstanceState){
        super.onCreate(savedIstanceState);
        setContentView(R.layout.layout_cercadocumento);

        documentoDAO = new DocumentoDAO(getApplicationContext());
        spinnerFacolta = findViewById(R.id.spinnerFacolta);
        spinnerUniversita = findViewById(R.id.spinnerUniversita);
        spinnerInsegnamento = findViewById(R.id.spinnerInsegnamento);

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

    public void ricerca(View view){
        try {
            List<Documento> documentoArrayList = documentoDAO.retreiveByFiltraggio(universita_scelta, facolta_scelta, insegnamento_scelto);
            Log.d("Lista", "Lista size -> " + documentoArrayList.size());
            if(documentoArrayList.size() > 0) {
                Intent intent = new Intent(getApplicationContext(), HomepageActivity.class);
                intent.putExtra("lista_documenti", (Serializable) documentoArrayList);
                startActivity(intent);
            }
            else{
                Intent intent = new Intent(getApplicationContext(), ProfiloActivity.class);
                startActivity(intent);
            }
        }catch(Exception exception){
            Toast.makeText(this, "Errore nell'esecuzione, riempire i form del filtraggio", Toast.LENGTH_LONG).show();
        }
    }
}
