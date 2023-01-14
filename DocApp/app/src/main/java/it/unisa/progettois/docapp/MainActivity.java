package it.unisa.progettois.docapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button registration, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_apertura);

        login = (Button) findViewById(R.id.bottonePerLogin);
        registration = (Button) findViewById(R.id.bottonePerRegistrazione);

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registration();
            }
        });
    }

    public void registration(){
        Intent intent = new Intent(this, RegistrazioneActivity.class);
        startActivity(intent);
    }
}