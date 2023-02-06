package it.unisa.progettois.docapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.sql.SQLException;

import it.unisa.progettois.docapp.data.DatabasePopulator;
import it.unisa.progettois.docapp.data.Studente;
import it.unisa.progettois.docapp.data.StudenteDAO;

public class LoginActivity extends AppCompatActivity {
    Button buttonAccedi;
    EditText emailLogin, passwordLogin;
    private StudenteDAO studenteDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        studenteDAO = new StudenteDAO(getApplicationContext());
        buttonAccedi = findViewById(R.id.buttonAccedi);
        emailLogin = findViewById(R.id.emailLogin);
        passwordLogin = findViewById(R.id.passwordLogin);
    }

    public void effettuaLogin(View view){
        String email = emailLogin.getText().toString();
        String password = passwordLogin.getText().toString();
        try {
            Studente studente = studenteDAO.effettuaLogin(email, password);
            Toast.makeText(this, "Studente di nome -> " + studente.getNickname() + " e admin uguale a -> " + studente.isIs_admin(), Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), HomepageActivity.class);
            intent.putExtra("studente", studente);
            startActivity(intent);

        }catch (Exception exception){
            Toast.makeText(getApplicationContext(), "Errore nell'input", Toast.LENGTH_SHORT).show();
        }
    }
}
