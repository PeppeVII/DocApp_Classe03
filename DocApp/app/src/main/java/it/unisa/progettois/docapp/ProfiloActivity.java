package it.unisa.progettois.docapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import it.unisa.progettois.docapp.data.Studente;
import it.unisa.progettois.docapp.data.StudenteDAO;

public class ProfiloActivity extends AppCompatActivity {
    ImageView iconaHome, iconaCarica, iconaChat;
    TextView nomeUtente;
    private SharedPreferences sharedPreferences;
    private StudenteDAO studenteDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_profilo);

        iconaHome = findViewById(R.id.iconaHome);
        iconaCarica = findViewById(R.id.iconaCarica);
        nomeUtente = findViewById(R.id.nome_utente);
        sharedPreferences = getSharedPreferences("MY_SHARED_PREF", MODE_PRIVATE);
        studenteDAO = new StudenteDAO(getApplicationContext());
        Studente studente = studenteDAO.effettuaLogin(sharedPreferences.getString("email", ""), sharedPreferences.getString("password", ""));
        nomeUtente.setText(studente.getNickname());
        iconaHome.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), HomepageActivity.class);
            startActivity(intent);
        });

        iconaCarica.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), CaricaDocumentoActivity.class);
            startActivity(intent);
        });
    }
}
