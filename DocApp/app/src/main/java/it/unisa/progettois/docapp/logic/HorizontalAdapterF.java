package it.unisa.progettois.docapp.logic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import it.unisa.progettois.docapp.R;

public class HorizontalAdapterF extends RecyclerView.Adapter<HorizontalAdapterF.ViewHolder> {

    private final String[] mItems;

    public HorizontalAdapterF(String[] items) {
        mItems = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_elemento_lista_facolta_homepage, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(mItems[position]);
    }

    @Override
    public int getItemCount() {
        return mItems.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.testo_facolta_elemento_lista);
            cardView = itemView.findViewById(R.id.elemento_lista_facolta);
        }
    }
}
