package it.unisa.progettois.docapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import it.unisa.progettois.docapp.data.CaricamentoDAO;
import it.unisa.progettois.docapp.data.Documento;
import it.unisa.progettois.docapp.data.Feedback;
import it.unisa.progettois.docapp.data.FeedbackDAO;
import it.unisa.progettois.docapp.data.Studente;
import it.unisa.progettois.docapp.data.StudenteDAO;

public class DocumentoActivity extends AppCompatActivity {
    ImageView likeImage;
    TextView counterFeedback, nome_documento, descrizione_documento, nome_universita, nome_facolta, nome_insegnamento, nome_autore, counter_feedback;
    CaricamentoDAO caricamentoDAO;
    FeedbackDAO feedbackDAO;
    ImageView visualizzaDocumento;
    Documento d;
    Studente studente;
    StudenteDAO studenteDAO;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        counter_feedback = findViewById(R.id.counterFeedback);
        feedbackDAO = new FeedbackDAO(getApplicationContext());
        caricamentoDAO = new CaricamentoDAO(getApplicationContext());
        studenteDAO = new StudenteDAO(getApplicationContext());
        sharedPreferences = getSharedPreferences("MY_SHARED_PREF", MODE_PRIVATE);

        if(getIntent().getExtras() != null)
            d = (Documento) getIntent().getSerializableExtra("documento");

        counter_feedback.setText("" + feedbackDAO.counterFeedback(d.getId_documento()));
        studente = studenteDAO.effettuaLogin(sharedPreferences.getString("email", ""), sharedPreferences.getString("password", ""));

        if(feedbackDAO.ottieni(d.getId_documento(), studente.getEmail()) != null)
            likeImage.setImageResource(R.mipmap.blue_like_is);

        nome_documento.setText(d.getNome());
        nome_autore.setText(caricamentoDAO.getAutore(d.getId_documento()));
        descrizione_documento.setText(d.getDescrizione());
        nome_universita.setText(d.getUniversita());
        nome_facolta.setText(d.getFacolta());
        nome_insegnamento.setText(d.getCorso_di_studio());

        likeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(feedbackDAO.ottieni(d.getId_documento(), studente.getEmail()) == null){
                    if(feedbackDAO.inserisci(d.getId_documento(), studente.getEmail())){
                        likeImage.setImageResource(R.mipmap.blue_like_is);
                        likeImage.setContentDescription("blue_like");
                        counter_feedback.setText("" + feedbackDAO.counterFeedback(d.getId_documento()));
                    }
                }else{
                    likeImage.setImageResource(R.mipmap.black_like_is);
                    likeImage.setContentDescription("black_like");
                    if(feedbackDAO.rimuoviFeedback(d.getId_documento(), studente.getEmail())){
                        counter_feedback.setText("" + feedbackDAO.counterFeedback(d.getId_documento()));
                    }
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
}
