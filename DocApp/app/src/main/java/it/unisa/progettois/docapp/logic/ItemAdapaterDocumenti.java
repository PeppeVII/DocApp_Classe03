package it.unisa.progettois.docapp.logic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import it.unisa.progettois.docapp.R;
import it.unisa.progettois.docapp.data.Documento;

public class ItemAdapaterDocumenti extends ArrayAdapter<Documento> {
    public ItemAdapaterDocumenti(Context context, List<Documento> documenti){
        super(context, 0, documenti);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Documento documento = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_elemento_lista_documenti, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.titolo_elemento_lista);
        textView.setText(documento.getNome());

        return convertView;
    }
}
