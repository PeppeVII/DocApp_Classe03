package it.unisa.progettois.docapp.logic;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import it.unisa.progettois.docapp.R;
import it.unisa.progettois.docapp.data.StudenteDAO;

public class ItemAdapterChat extends ArrayAdapter<Messaggio> {
    private StudenteDAO studenteDAO;
    private SharedPreferences sharedPreferences;
    private Studente studente;

    public ItemAdapterChat(Context context, List<Messaggio> messaggi){
        super(context, 0, messaggi);
        sharedPreferences = context.getSharedPreferences("MY_SHARED_PREF", MODE_PRIVATE);
        studenteDAO = new StudenteDAO(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        studente = studenteDAO.effettuaLogin(sharedPreferences.getString("email", ""), sharedPreferences.getString("password", ""));
        Messaggio messaggio = getItem(position);
        studenteDAO = new StudenteDAO(getContext());

        if (convertView == null) {
            if (messaggio.getEmail_studente().equals(studente.getEmail())){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_my_message, parent, false);
                TextView me_message = convertView.findViewById(R.id.body_messaggio);
                me_message.setText(messaggio.getTesto());
            }else{
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_their_message, parent, false);
                TextView their_message = convertView.findViewById(R.id.message_body);
                their_message.setText(messaggio.getTesto());
                TextView nickname = convertView.findViewById(R.id.nickname);
                nickname.setText(studenteDAO.getNickname(messaggio.getEmail_studente()));
            }
        }
        return convertView;
    }
}
