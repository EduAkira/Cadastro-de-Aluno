package com.example.cadastroaluno;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardViewHolder> {


    public interface CardAdapterListener {
        void cardClick(View v, int posicao);
    }

    private List<Aluno> alunos;
    private Context context;
    private CardAdapterListener listener;

    public CardAdapter(List<Aluno> alunos, Context context) {
        this.alunos = alunos;
        this.context = context;
        listener = (CardAdapterListener) context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.card_item, viewGroup, false);
        return new CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewHolder cardViewHolder, final int position) {
        final Aluno aluno = alunos.get(position);

        cardViewHolder.getRa().setText(aluno.getRa());
        cardViewHolder.getNome().setText(aluno.getNome());
        cardViewHolder.getCardView().setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                listener.cardClick(v, position);

            }
        });
    }

    @Override
    public int getItemCount() {
        return alunos.size();
    }

}
