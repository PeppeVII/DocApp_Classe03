package it.unisa.progettois.docapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import it.unisa.progettois.docapp.data.Documento;

public class Documenti_Filtrati_Activity extends AppCompatActivity {
    ListView listView;
    ItemAdapater item;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_documenti_filtrati);

        listView = findViewById(R.id.documenti_filtrati);
        List<Documento> list_documenti = (List<Documento>) getIntent().getSerializableExtra("lista_documenti");

        for(Documento d : list_documenti)
            Log.d("Documenti", "Eccoli: " + d.getCorso_di_studio());

        item = new ItemAdapater(getApplicationContext(), list_documenti);
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
    }
}
