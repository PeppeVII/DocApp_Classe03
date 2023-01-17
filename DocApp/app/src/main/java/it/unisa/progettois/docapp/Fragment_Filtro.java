package it.unisa.progettois.docapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Fragment_Filtro extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceSate)
    {
        View view = inflater.inflate(R.layout.fragment_filtro, container, false);
        EditText et = view.findViewById(R.id.filtroDocumenti);
        Button b = view.findViewById(R.id.bottoneFiltro);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et.getText().toString().isEmpty())
                    Toast.makeText(getContext(), "Il campo di ricerca è vuoto", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
