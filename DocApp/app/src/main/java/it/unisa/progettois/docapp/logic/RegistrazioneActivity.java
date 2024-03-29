package it.unisa.progettois.docapp.logic;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.unisa.progettois.docapp.R;

public class RegistrazioneActivity extends AppCompatActivity{
    Button bottoneRegistrazione;
    EditText usernameET, emailET, passwordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_registrazione);

        bottoneRegistrazione = findViewById(R.id.bottoneRegistrazione);
        usernameET =  findViewById(R.id.username);
        emailET =  findViewById(R.id.email);
        passwordET =  findViewById(R.id.password);
    }

    public void effettuaRegistrazione(View v)
    {
        String email = emailET.getText().toString();
        String username = usernameET.getText().toString();
        String password = passwordET.getText().toString();

        Pattern checkUsername = Pattern.compile("^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$", Pattern.CASE_INSENSITIVE);
        Matcher matcherUsername = checkUsername.matcher(username);

        Pattern checkEmail = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcherEmail = checkEmail.matcher(email);

        Pattern checkPassword = Pattern.compile("^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$");
        Matcher matcherPassword = checkPassword.matcher(password);

        //Controllo dei campi per vedere se sono vuoti
        if(username.matches("") || email.matches("")|| password.matches(""))
        {
            Toast.makeText(this, "Uno dei campi è vuoto, procedere alla compilazione", Toast.LENGTH_SHORT).show();
            return;
        }

        //Controllo della lunghezza dell'username e dell'eventuale presenza di caratteri speciali
        if(!matcherUsername.find() || username.length() > 30)
        {
            Toast.makeText(this, "Username non valido, caratteri speciali non ammessi", Toast.LENGTH_SHORT).show();
            return;
        }

        //Controllo della lunghezza dell'email e dell'eventuale presenza del punto o la @
        if(!matcherEmail.find() || email.length() > 50)
        {
            Toast.makeText(this, "Email non valida o troppo lunga", Toast.LENGTH_SHORT).show();
            return;
        }

        //Controllo della lunghezza della password e dei caratteri inseriti
        if(!matcherPassword.find())
        {
            Toast.makeText(this, "Password non valida", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}