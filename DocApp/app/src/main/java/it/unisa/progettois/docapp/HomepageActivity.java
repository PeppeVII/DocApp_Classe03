package it.unisa.progettois.docapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class HomepageActivity extends AppCompatActivity
{
    Button bottoneFiltro;
    ImageView home, carica, profilo, chat;
    @Override
    protected void onCreate(Bundle savedIstanceState) {
        super.onCreate(savedIstanceState);
        setContentView(R.layout.layout_homepage);

        bottoneFiltro = findViewById(R.id.bottoneFiltro);
        home = findViewById(R.id.iconaProfilo);

        if(!home.isClickable())
            home.setClickable(true);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProfiloActivity.class);
                startActivity(intent);
            }
        });

        carica = findViewById(R.id.iconaCarica);
        if(!carica.isClickable())
            carica.setClickable(true);

        carica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CaricaDocumentoActivity.class);
                startActivity(intent);
            }
        });
    }
}
