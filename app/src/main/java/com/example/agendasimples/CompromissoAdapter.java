package com.example.agendasimples;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CompromissoAdapter extends RecyclerView.Adapter<CompromissoAdapter.ViewHolderCompromisso> {

    private ArrayList<Compromisso> compromissos;

    public CompromissoAdapter(ArrayList<Compromisso> compromissos){
        this.compromissos = compromissos;
    }

    @NonNull
    @Override
    public CompromissoAdapter.ViewHolderCompromisso onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.compromisso_card, parent, false);

        ViewHolderCompromisso viewHolderCompromisso = new ViewHolderCompromisso(view);

        return viewHolderCompromisso;
    }

    @Override
    public void onBindViewHolder(@NonNull CompromissoAdapter.ViewHolderCompromisso holder, int position) {

        if(compromissos != null && compromissos.size() > 0){

            Compromisso compromisso = compromissos.get(position);
            int cardColor = Cores.getCor(compromisso.getColorId());

            holder.data_text.setText(compromisso.getData());
            holder.data_text.setTextColor(cardColor);
            holder.titulo_text.setText(compromisso.getTitulo());
            holder.descricao_text.setText(compromisso.getDescricao());
            holder.color_view.setBackgroundColor(cardColor);

        }

    }

    @Override
    public int getItemCount() {
        return compromissos.size();
    }

    public class ViewHolderCompromisso extends RecyclerView.ViewHolder{

        public TextView   data_text;
        public TextView   titulo_text;
        public TextView   descricao_text;
        public View       color_view;


        public ViewHolderCompromisso(@NonNull View itemView) {
            super(itemView);

            data_text       = itemView.findViewById(R.id.data_text);
            titulo_text     = itemView.findViewById(R.id.titulo_text);
            descricao_text  = itemView.findViewById(R.id.descricao_text);
            color_view      = itemView.findViewById(R.id.color_view);
        }
    }
}
