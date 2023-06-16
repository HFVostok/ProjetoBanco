package Projeto2B;

import java.util.*;

public abstract class Modelo_Conta {
    private String senha;
    private String nome;
    private double saldo = 0;
    private ArrayList<Transacoes> listaT = new ArrayList<>();

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Transações> getListaT() {
        return listaT;
    }

public void setListaT(Transações transacao) {
7
this.listaT.add(transacao);
}

    public Modelo_Conta(String senha, String nome) {
        this.senha = senha;
        this.nome = nome;
    }
}
