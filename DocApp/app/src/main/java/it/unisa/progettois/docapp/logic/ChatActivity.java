package it.unisa.progettois.docapp.logic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import it.unisa.progettois.docapp.R;
import it.unisa.progettois.docapp.data.ConversazioneDAO;
import it.unisa.progettois.docapp.data.Studente;
import it.unisa.progettois.docapp.data.StudenteDAO;

public class ChatActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    ListView listView;
    ItemAdapterListaChat itemAdapterListaChat;
    private Studente studente;
    private StudenteDAO studenteDAO;
    private ConversazioneDAO conversazioneDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lista_chat);

        studenteDAO = new StudenteDAO(getApplicationContext());
        conversazioneDAO = new ConversazioneDAO(getApplicationContext());
        sharedPreferences = getSharedPreferences("MY_SHARED_PREF", MODE_PRIVATE);

        listView = findViewById(R.id.lista_item_chat);
        studente = studenteDAO.effettuaLogin(sharedPreferences.getString("email", ""), sharedPreferences.getString("password", ""));
        List<Studente> destinatari = conversazioneDAO.getNicknameDestinatari(studente.getEmail());
        itemAdapterListaChat = new ItemAdapterListaChat(getApplicationContext(), destinatari);
        listView.setAdapter(itemAdapterListaChat);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ChatPersonaleActivity.class);
                Studente studente1 = (Studente) parent.getItemAtPosition(position);
                intent.putExtra("destinatario", studente1);
                startActivity(intent);
            }
        });
    }
}