package com.example.cadastroaluno;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {
    public static final String ADICIONAR_TAG = "ADICIONAR";
    public static final String EDITAR_TAG = "EDITAR";
    private static final String EXTRA_TITULO = "TITULO";
    private static final String EXTRA_POSICAO = "POSICAO";
    private static final String EXTRA_ALUNO = "ALUNO";

    private EditText raEdit;
    private EditText nomeEdit;
    private Button Button;

    private Aluno aluno = null;

    private AlunoListener alunoListener;


    public interface AlunoListener {
        void AlunoListener(Aluno aluno, int posicao);
    }

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance(String title, Aluno aluno, int posicao) {
        MainFragment dialog = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_TITULO, title);
        bundle.putInt(EXTRA_POSICAO, posicao);
        bundle.putSerializable(EXTRA_ALUNO, aluno);
        dialog.setArguments(bundle);
        return dialog;
    }

    public static MainFragment newInstance(String title) {
        return newInstance(title,null, -1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.main_fragment, container, false);
        final Bundle bundle = getArguments();

        Button = view.findViewById(R.id.fragButton);
        raEdit = view.findViewById(R.id.rmEditText);
        nomeEdit = view.findViewById(R.id.nomeEditText);

        Button.setText(bundle.getString(EXTRA_TITULO));

        if(bundle.getString(EXTRA_TITULO).equals(EDITAR_TAG)){
            aluno = (Aluno) bundle.getSerializable(EXTRA_ALUNO);
            raEdit.setText(aluno.getRa());
            nomeEdit.setText(aluno.getNome());
        }else{
            aluno = new Aluno();
        }

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aluno.setRa(raEdit.getText().toString());
                aluno.setNome(nomeEdit.getText().toString());
                alunoListener.AlunoListener(aluno, bundle.getInt(EXTRA_POSICAO));
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        alunoListener = (AlunoListener) context;
    }

}
