package com.developer.johhns.arquitecturaandroidmvvm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotaAdaptador  extends RecyclerView.Adapter<NotaAdaptador.ViewHolder> {

    private List<Nota> notas = new ArrayList<>();

    @NonNull
    @Override
    public NotaAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from( parent.getContext() ).inflate( R.layout.card_view , parent , false ) ;
        return new ViewHolder( vista );
    }

    @Override
    public void onBindViewHolder(@NonNull NotaAdaptador.ViewHolder holder, int position) {
      holder.txtPrioridad.setText( String.valueOf( notas.get(position).getPrioridad() ) );
      holder.txtTitulo.setText( notas.get(position).getTitulo() );
      holder.txtDescripcion.setText( notas.get(position).getDescripcion() );
    }

    @Override
    public int getItemCount() {
        return  notas.size() ;
    }

    public void inicializarNotas( List<Nota> notas ){
        this.notas = notas ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtPrioridad, txtTitulo, txtDescripcion ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDescripcion = itemView.findViewById( R.id.txtDescripcion ) ;
            txtTitulo      = itemView.findViewById( R.id.txtTitulo ) ;
            txtPrioridad   = itemView.findViewById( R.id.txtPrioridad ) ;
        }
    }
}
