package it.unisa.progettois.docapp.logic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import it.unisa.progettois.docapp.R;
import it.unisa.progettois.docapp.data.Documento;

public class HorizontalAdapterD extends RecyclerView.Adapter<HorizontalAdapterD.ViewHolder> {
    Context context;
    List<Documento> documenti;


    public HorizontalAdapterD(Context context, List<Documento> documenti){
        this.context = context;
        this.documenti = documenti;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_elemento_lista_documenti, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.titolo.setText(documenti.get(position).getNome());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DocumentoActivity.class);
                Documento documento = documenti.get(position);
                intent.putExtra("documento", documento);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return documenti.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView titolo;
        CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titolo = itemView.findViewById(R.id.titolo_elemento_lista);
            cardView = itemView.findViewById(R.id.elemento_lista_documenti);

        }
    }
}
