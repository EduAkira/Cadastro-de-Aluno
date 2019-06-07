package com.example.cadastroaluno;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Aluno implements Serializable {

    private String nome;
    private String ra;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public Aluno(String nome, String ra) {
        this.nome = nome;
        this.ra = ra;
    }
    public Aluno(){}

    @NonNull
    @Override
    public String toString() {
        return "Aluno{" + "ra=" + ra + ", nome=" + nome + '\'' + "}";
    }
}
