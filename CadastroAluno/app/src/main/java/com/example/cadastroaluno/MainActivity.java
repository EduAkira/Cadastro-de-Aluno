package com.example.cadastroaluno;


import android.os.Bundle;

import android.view.View;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static com.example.cadastroaluno.MainFragment.ADICIONAR_TAG;
import static com.example.cadastroaluno.MainFragment.EDITAR_TAG;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainFragment.AlunoListener, CardAdapter.CardAdapterListener {

    private MainFragment fragments;
    private FragmentManager fragmentManager;
    private FloatingActionButton addButton;
    private List<Aluno> alunos;
    private CardAdapter cardAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton = findViewById(R.id.add_aluno);
        addButton.setOnClickListener(this);

        alunos = new ArrayList<>();
        alunos.add(new Aluno("Eduardo Akira Watanabe", "0040481721015"));

        setRecyclerView();
    }

    private void setRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layout);

        cardAdapter = new CardAdapter(alunos, this);

        recyclerView.setAdapter(cardAdapter);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        addButton.show();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.add_aluno){
            fragments = MainFragment.newInstance(ADICIONAR_TAG);
            showFragment();
        }

    }

    private void showFragment() {
        addButton.hide();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment,fragments);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void cardClick(View v, int posicao) {
        fragments = MainFragment.newInstance(EDITAR_TAG, alunos.get(posicao), posicao);
        showFragment();

    }

    @Override
    public void AlunoListener(Aluno aluno, int posicao) {
        update(aluno,posicao);
    }

    public void update(Aluno aluno, int posicao){
        addButton.show();
        fragmentManager.popBackStack();
        if(posicao == -1){
            alunos.add(aluno);
        }else{
            alunos.set(posicao, aluno);
        }
        cardAdapter.notifyDataSetChanged();
    }
}
