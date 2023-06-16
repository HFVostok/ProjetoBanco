package Projeto2;

import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 * Conta
 */
public abstract class Conta {

    Scanner sc = new Scanner(System.in);

    String nome;
    int nConta;
    double saldoConta;
    double senhaConta;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getnConta() {
        return nConta;
    }

    public void setnConta(int nConta) {
        this.nConta = nConta;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }

    public double getSenhaConta(double senhaConta) {

        JOptionPane.showInputDialog("Favor Digite a Senha Novamente");
        double senhaConta2 = sc.nextDouble();

        if (senhaConta == senhaConta2) {
            JOptionPane.showInputDialog("Senha Confirmada com Sucesso!");
        }
        return senhaConta;
    }

    public void setSenhaConta(double senhaConta) {
        this.senhaConta = senhaConta;
    }

}