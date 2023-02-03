package it.unisa.progettois.docapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfiloActivity extends AppCompatActivity {
    ImageView iconaHome, iconaCarica, iconaChat;

    @Override
    protected void onCreate(Bundle savedIstanceState) {
        super.onCreate(savedIstanceState);
        setContentView(R.layout.layout_profilo);

        iconaHome = findViewById(R.id.iconaHome);
        iconaCarica = findViewById(R.id.iconaCarica);

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
