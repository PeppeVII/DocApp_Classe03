package it.unisa.progettois.docapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import it.unisa.progettois.docapp.data.CaricamentoDAO;
import it.unisa.progettois.docapp.data.Documento;

public class DocumentoActivity extends AppCompatActivity {
    ImageView likeImage;
    TextView counterFeedback, nome_documento, descrizione_documento, nome_universita, nome_facolta, nome_insegnamento, nome_autore;
    CaricamentoDAO caricamentoDAO;
    ImageView visualizzaDocumento;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pagina_documento);

        likeImage = findViewById(R.id.imageFeedback);
        counterFeedback = findViewById(R.id.counterFeedback);
        nome_autore = findViewById(R.id.nome_autore);
        visualizzaDocumento = findViewById(R.id.visualizzaDocumento);
        nome_documento = findViewById(R.id.nome_documento);
        descrizione_documento = findViewById(R.id.nome_descrizione);
        nome_universita = findViewById(R.id.nome_universita);
        nome_facolta = findViewById(R.id.nome_facolta);
        nome_insegnamento = findViewById(R.id.nome_insegnamento);
        caricamentoDAO = new CaricamentoDAO(getApplicationContext());

        Documento d = (Documento) getIntent().getSerializableExtra("documento");
        Log.d("nomeAutore", "Nome autore: " + caricamentoDAO.getAutore(d.getId_documento()));

        nome_documento.setText(d.getNome());
        nome_autore.setText(caricamentoDAO.getAutore(d.getId_documento()));
        descrizione_documento.setText(d.getDescrizione());
        nome_universita.setText(d.getUniversita());
        nome_facolta.setText(d.getFacolta());
        nome_insegnamento.setText(d.getCorso_di_studio());


        //Listener tasto like
        likeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (likeImage.getContentDescription() == "black_like"){
                    likeImage.setImageResource(R.mipmap.blue_like_is);
                    likeImage.setContentDescription("blue_like");
                }
                else {
                    likeImage.setImageResource(R.mipmap.black_like_is);
                    likeImage.setContentDescription("black_like");
                }
            }
        });

        //Listener visualizzazione documento
        visualizzaDocumento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openPdf(getFilesDir().getPath());
            }
        });
    }

    /*public void openPdf(String path){
        File file = new File(path);
        if (file.exists()){
            Uri p = Uri.fromFile(file);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(p,"it.unisa.progettois.docapp.documenti/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            startActivity(intent);
        }
    }*/
}
