package it.unisa.progettois.docapp.logic;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

import it.unisa.progettois.docapp.R;
import it.unisa.progettois.docapp.data.ConversazioneDAO;
import it.unisa.progettois.docapp.data.Messaggio;
import it.unisa.progettois.docapp.data.MessaggioDAO;
import it.unisa.progettois.docapp.data.Studente;
import it.unisa.progettois.docapp.data.StudenteDAO;

public class ChatPersonaleActivity extends AppCompatActivity {
    ListView listView;
    int id_conversazione;
    String[] stringArray = {"dio cane", "cazzo", "vaffanculo", "negro", "deficiente", "menomato", "handicappato", "frocio", "ritardato", "mongoloide", "muori", "ucciditi", "puttana", "dio stronzo", "dio infame", "dio porco", "zoccola"};
    List<String> list = Arrays.asList(stringArray);
    Studente destinatario, mittente;
    SharedPreferences sharedPreferences;
    ConversazioneDAO conversazioneDAO;
    ItemAdapterChat itemAdapterChat;
    StudenteDAO studenteDAO;
    MessaggioDAO messaggioDAO;
    EditText et_messaggio;
    ImageButton invio;
    List<Messaggio> messaggi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_chat_container);
        invio = findViewById(R.id.invioMessaggio);
        et_messaggio = findViewById(R.id.et_messaggio);
        listView = findViewById(R.id.lista_messaggi_chat);

        sharedPreferences = getSharedPreferences("MY_SHARED_PREF", MODE_PRIVATE);
        messaggioDAO = new MessaggioDAO(getApplicationContext());
        conversazioneDAO = new ConversazioneDAO(getApplicationContext());
        studenteDAO = new StudenteDAO(getApplicationContext());
        mittente = studenteDAO.effettuaLogin(sharedPreferences.getString("email", ""), sharedPreferences.getString("password", ""));
        destinatario = (Studente) getIntent().getSerializableExtra("destinatario");

        id_conversazione = conversazioneDAO.getId_Conversazione(destinatario.getEmail(), mittente.getEmail());

        messaggi = messaggioDAO.getMessaggioByTime();

        itemAdapterChat = new ItemAdapterChat(getApplicationContext(), messaggi);
        listView.setAdapter(itemAdapterChat);
    }

    public void sendMessage(View view){
        try{
            String messaggio = et_messaggio.getText().toString();

            if(messaggio.length() == 0 || messaggio.isEmpty())
                Toast.makeText(this, "Impossibile inviare messaggio vuoto", Toast.LENGTH_SHORT).show();

            for(String element : list){
                if(messaggio.contains(element) || messaggio.equalsIgnoreCase(element))
                    messaggio = messaggio.replace(element, "***");
            }

            if(messaggioDAO.inserimentoMessaggio(id_conversazione, mittente.getEmail(), messaggio)){
                messaggi = messaggioDAO.getMessaggioByTime();
                ItemAdapterChat aggiorna = new ItemAdapterChat(getApplicationContext(), messaggi);
                listView.setAdapter(aggiorna);
            }else{
                Toast.makeText(getApplicationContext(), "Errore nell'invio del messaggio", Toast.LENGTH_LONG).show();
            }
        }catch (Exception exc){
            Toast.makeText(this, "Errore nell'invio del messaggio", Toast.LENGTH_SHORT).show();
        }
    }
}
