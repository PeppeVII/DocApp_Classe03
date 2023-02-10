package it.unisa.progettois.docapp.logic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import it.unisa.progettois.docapp.R;

public class Fragment_Filtro extends Fragment {
    ImageView documento1, documento2, documento3, documento4, documento5;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceSate)
    {
        View view = inflater.inflate(R.layout.layout_homepage, container, false);
        Button b = view.findViewById(R.id.bottoneFiltro);
        return view;
    }


    //TUTTO QUESTO PER LA COMMIT DEL CAZZO (GIUSEPPE D'AMBROSIO)
    /*
imgFavorite.setClickable(true);
imgFavorite.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.i(SystemSettings.APP_TAG + " : " + HomeActivity.class.getName(), "Entered onClick method");
            Toast.makeText(v.getContext(),
                    "The favorite list would appear on clicking this icon",
                    Toast.LENGTH_LONG).show();
        }
    }); */


}
