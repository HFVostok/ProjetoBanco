package Projeto2;

import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 * App
 */
public class App {

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // criar os vetores de objetos
        ContaPF contasPf[] = new ContaPF[10];
        ContaPJ contasPj[] = new ContaPJ[10];
        int sConta[] = new int[10];
        // criar a aplicação do banco
        boolean aberta = true;
        int contPf = 0;
        int contPj = 0;

        while (aberta) {
            int acao = Integer.parseInt(JOptionPane.showInputDialog(
                    "Escolha a ção desejada:"
                            + "\n 1-Abrir Conta PF"
                            + "\n 2-Abrir Conta PJ"
                            + "\n 3-Acessar Conta PF"
                            + "\n 4-Acessar Conta PJ"
                            + "\n 5-Sair"));
            if (acao == 1) {// abrir conta PF
                // criar a conta
                // instanciar o objeto
                contasPf[contPf] = new ContaPF();// objeto criado
                // preencher as informações da conta
                contasPf[contPf].setNome(JOptionPane.showInputDialog("Informe o Nome:"));
                contasPf[contPf].setnCpf(JOptionPane.showInputDialog("Informe o CPF:"));
                contasPf[contPf].setSaldo(0);
                contasPf[contPf].setnConta(1000 + contPf);
                contPf++;
            } else if (acao == 2) {// abrir conta PJ
                // criar a conta
                // instanciar o objeto
                contasPj[contPj] = new ContaPJ();// objeto criado
                // preencher as injormações da conta
                contasPj[contPj].setNome(JOptionPane.showInputDialog("Injorme o Nome:"));
                contasPj[contPj].setnCnpj(JOptionPane.showInputDialog("Injorme o CPj:"));
                contasPj[contPj].setSaldo(0);
                contasPj[contPj].setnConta(2000 + contPj);
                contPj++;
            } else if (acao == 2) {// buscar a conta já criada da PF
                int contaAtual;
                int nContaBusca = Integer.parseInt(JOptionPane.showInputDialog("Informe o nº da conta buscada:"));
                for (int i = 0; i < contasPf.length; i++) {
                    // busca pelo nº da conta
                    if (nContaBusca == contasPf[i].getnConta()) {
                        contaAtual = i;
                        JOptionPane.showMessageDialog(null, "Conta Encontrada");
                        break;
                    }
                }
                boolean acessar = true;
                while (acessar) {
                    int acao2 = Integer.parseInt(JOptionPane.showInputDialog("Ação desejada:"
                            + "\n 1- verificar saldo"
                            + "\n 2-Saque"
                            + "\n 3-"));
                    if (acao2 == 1) {
                        contasPf[contaAtual].getSaldo();
                    } else if (acao2 == 2) {
                        contasPf[contaAtual].saque();
                    } else if (acao2 == 3) {
                        acessar = false;
                    } else {
                        // nº invalido
                    }
                }
            }

        }

    }

}