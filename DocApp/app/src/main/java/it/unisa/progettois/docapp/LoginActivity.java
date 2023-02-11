package it.unisa.progettois.docapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    Button buttonAccedi;
    EditText emailLogin, passwordLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        buttonAccedi = findViewById(R.id.buttonAccedi);
        emailLogin = findViewById(R.id.emailLogin);
        passwordLogin = findViewById(R.id.passwordLogin);



        buttonAccedi.setOnClickListener(v -> {


            Intent intent = new Intent(getApplicationContext(), HomepageActivity.class);
            startActivity(intent);



        });
    }


}
