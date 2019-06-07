package com.example.cadastroaluno;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CardViewHolder extends RecyclerView.ViewHolder {
    private CardView cardView;
    private TextView ra;
    private TextView nome;

    public CardViewHolder(@NonNull View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.card_view);
        ra = itemView.findViewById(R.id.raTextView);
        nome = itemView.findViewById(R.id.nomeTextView);
    }

    public CardView getCardView() {
        return cardView;
    }

    public TextView getRa() {
        return ra;
    }

    public TextView getNome() {
        return nome;
    }
}
