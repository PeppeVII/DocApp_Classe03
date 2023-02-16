package it.unisa.progettois.docapp.logic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


import it.unisa.progettois.docapp.R;


public class ChatActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lista_chat);



    }
}