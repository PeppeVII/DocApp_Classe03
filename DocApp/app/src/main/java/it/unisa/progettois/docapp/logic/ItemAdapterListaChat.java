package it.unisa.progettois.docapp.logic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import it.unisa.progettois.docapp.R;
import it.unisa.progettois.docapp.data.Studente;

public class ItemAdapterListaChat extends ArrayAdapter<Studente> {

    public ItemAdapterListaChat(Context context, List<Studente> studenti){
        super(context, 0, studenti);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Studente studente = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_item_lista_chat, parent, false);
        }
        TextView nome_chat = convertView.findViewById(R.id.nome_chat);
        nome_chat.setText(studente.getNickname());

        return convertView;
    }
}
