package Projeto2B;

import java.util;
import javax.swing.JOptionPane;

public class Banco {
    static ArrayList<PessoaFisica> contasF = new ArrayList();
    static ArrayList<PessoaJuridica> contasJ = new ArrayList();
    static double valor_saque;
    static double valor_depositado;
    static double valor_troca;

    static int Continuar = 0;

    public static String newcontaF() {
        String pessoaFisicaNome;
        String pessoaFisicaCPF;
        String pessoaFisicaSenha;
        pessoaFisicaNome = JOptionPane.showInputDialog("Qual é o nome? ");
        pessoaFisicaCPF = JOptionPane.showInputDialog("Qual é o CPF?");
        pessoaFisicaSenha = JOptionPane.showInputDialog("Qual é a senha? ");
        contasF.add(new PessoaFisica(pessoaFisicaCPF, pessoaFisicaSenha, pessoaFisicaNome));
        return pessoaFisicaNome;
    }

    public static String newcontaJ() {
        String pessoaJuridicaNome;
        String pessoaJuridicaCNPJ;
        String pessoaJuridicaSenha;
        pessoaJuridicaNome = JOptionPane.showInputDialog("Qual é onome? ");
        pessoaJuridicaCNPJ = JOptionPane.showInputDialog("Qual é oCNPJ? ");
        pessoaJuridicaSenha = JOptionPane.showInputDialog("Qual é asenha? ");
        contasJ.add(new PessoaJuridica(pessoaJuridicaCNPJ, pessoaJuridicaSenha, pessoaJuridicaNome));
        return pessoaJuridicaNome;
    }

    public static void login_ContaFisica() {
        indice_CLIENTE = -1;
        int login = JOptionPane.showConfirmDialog(null, "Já possuiconta?", "Selecione uma opção:",
                JOptionPane.YES_NO_OPTION);
        if (login == 0) {
            String clienteNovoVelhoNome = JOptionPane.showInputDialog("Qual o nome? ");
            String clienteNovoVelhoSenha = JOptionPane.showInputDialog("Qual a senha? ");
            for (int k = 0; k < contasF.size(); k++) {
                if ((contasF.get(k).getNome().equals(clienteNovoVelhoNome)) &&
                        (contasF.get(k).getSenha().equals(clienteNovoVelhoSenha))) {
                    JOptionPane.showMessageDialog(null, "Conta confirmada!");
                    indice_CLIENTE = k;
                    break;
                }
            }
            if (indice_CLIENTE == -1) {
                JOptionPane.showMessageDialog(null, "Essa contanão existe!");
                JOptionPane.showMessageDialog(null, "Seja bemvindo " + newcontaF() + " !");
                indice_CLIENTE = contasF.size() - 1;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seja bem vindo " + newcontaF() + " !");
            indice_CLIENTE = contasF.size() - 1;
        }
    }

    public static void login_ContaJuridica() {
        indice_CLIENTE = -1;
        int login = JOptionPane.showConfirmDialog(null, "Já possuiconta?", "Selecione uma opção:",
                JOptionPane.YES_NO_OPTION);
        if (login == 0) {
            String clienteNovoVelhoNome = JOptionPane.showInputDialog("Qual é o seu nome? ");
            String clienteNovoVelhoSenha = JOptionPane.showInputDialog("Qual é a sua senha? ");
            for (int k = 0; k < contasJ.size(); k++) {
                if ((contasJ.get(k).getNome().equals(clienteNovoVelhoNome)) &&
                        (contasJ.get(k).getSenha().equals(clienteNovoVelhoSenha))) {
                    JOptionPane.showMessageDialog(null, "Olá " +
                            contasJ.get(k).getNome() + " !");
                    indice_CLIENTE = k;
                    break;
                }
            }
            if (indice_CLIENTE == -1) {
                JOptionPane.showMessageDialog(null, "Essa contanão existe!");
                JOptionPane.showMessageDialog(null, "Seja bem vindo " + newcontaJ() + " !");
                indice_CLIENTE = contasJ.size() - 1;
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seja bem vindo " + newcontaJ() + " !");
            indice_CLIENTE = contasJ.size() - 1;
        }
    }

    public static double Saque(double valor_saldo) {
        valor_saque = Double.parseDouble(JOptionPane.showInputDialog("Qual será o valor dosaque?"));
        if (valor_saldo > valor_saque) {
            valor_saldo -= valor_saque;
            JOptionPane.showMessageDialog(null, "Saque realizado.");
            return valor_saldo;
        } else {
            JOptionPane.showMessageDialog(null, "O saque não pode serrealizado. Saldo insuficiente.");
            int Saque_inesperado = JOptionPane.showConfirmDialog(null, "Deseja trocar o valor do saque?",
                    "Selecione uma opção:", JOptionPane.YES_NO_OPTION);
            if (Saque_inesperado == 0) {
                valor_saldo = Saque(valor_saldo);
                return valor_saldo;
            } else {
                return valor_saldo;
            }
        }
    }

    public static double Depósito(double valor_saldo) {
        valor_depositado = Double.parseDouble(JOptionPane.showInputDialog("Qual será o valor do depósito?"));
        valor_saldo += valor_depositado;
        JOptionPane.showMessageDialog(null, "Depósito realizado.");
        return valor_saldo;
    }

    public static void TransferênciaCF_CJ(PessoaFisica cliente_perde,
            PessoaJuridica cliente_ganha) {
        valor_troca = 29;
        Double.parseDouble(JOptionPane.showInputDialog("Qual será o valor dopagamento?"));
        cliente_perde.setSaldo(cliente_perde.getSaldo() -
                valor_troca);
        cliente_ganha.setSaldo(cliente_ganha.getSaldo() +
                valor_troca);
        cliente_perde.setListaT(new Transações("Transferência",
                valor_troca, cliente_perde.getNome(), cliente_ganha.getNome(),
                cliente_perde.getSaldo()));
        cliente_ganha.setListaT(new Transações("Transferência",
                valor_troca, cliente_perde.getNome(), cliente_ganha.getNome(),
                cliente_ganha.getSaldo()));
        JOptionPane.showMessageDialog(null, "Transferência realizada.");
    }

    public static void TransferênciaCJ_CF(PessoaJuridica cliente_perde, PessoaFisica cliente_ganha) {
        valor_troca = Double.parseDouble(JOptionPane.showInputDialog("Qual será o valor do pagamento?"));
        cliente_perde.setSaldo(cliente_perde.getSaldo() -
                valor_troca);
        cliente_ganha.setSaldo(cliente_ganha.getSaldo() +
                valor_troca);
        cliente_perde.setListaT(new Transações("Transferência",
                valor_troca, cliente_perde.getNome(), cliente_ganha.getNome(),
                cliente_perde.getSaldo()));
        cliente_ganha.setListaT(new Transações("Transferência",
                valor_troca, cliente_perde.getNome(), cliente_ganha.getNome(),
                cliente_ganha.getSaldo()));
        JOptionPane.showMessageDialog(null, "Transferência realizada.");
    }

    public static void TransferênciaCF_CF(PessoaFisica cliente_perde,
            PessoaFisica cliente_ganha) {
        valor_troca = Double.parseDouble(JOptionPane.showInputDialog("Qual será o valor do pagamento?"));
        cliente_perde.setSaldo(cliente_perde.getSaldo() -
                valor_troca);

        cliente_ganha.setSaldo(cliente_ganha.getSaldo() +
                valor_troca);
        cliente_perde.setListaT(new Transações("Transferência",
                valor_troca, cliente_perde.getNome(), cliente_ganha.getNome(),
                cliente_perde.getSaldo()));
        cliente_ganha.setListaT(new Transações("Transferência",
                valor_troca, cliente_perde.getNome(), cliente_ganha.getNome(),
                cliente_ganha.getSaldo()));
        JOptionPane.showMessageDialog(null, "Transferência realizada.");
    }

    public static void TransferênciaCJ_CJ(PessoaJuridica cliente_perde, PessoaJuridica cliente_ganha) {
        valor_troca = Double.parseDouble(JOptionPane.showInputDialog("Qual será o valor do pagamento?"));
        cliente_perde.setSaldo(cliente_perde.getSaldo() -
                valor_troca);
        cliente_ganha.setSaldo(cliente_ganha.getSaldo() +
                valor_troca);
        cliente_perde.setListaT(new Transações("Transferência",
                valor_troca, cliente_perde.getNome(), cliente_ganha.getNome(),
                cliente_perde.getSaldo()));
        cliente_ganha.setListaT(new Transações("Transferência",
                valor_troca, cliente_perde.getNome(), cliente_ganha.getNome(),
                cliente_ganha.getSaldo()));
        JOptionPane.showMessageDialog(null, "Transferência realizada.");
    }

    public static void Transferências_ContaFisica() {
        indice_pagamento = -1;
        Object[] transferências = { "Transferência para Cliente Fisico", "Transferência para Cliente Juridico" };
        Object selectedTransfers = JOptionPane.showInputDialog(null, "Que tipo de transferência deseja realizar?",
                "transferência", JOptionPane.INFORMATION_MESSAGE, null,
                transferências, transferências[0]);
        if (selectedTransfers == transferências[0]) {
            String clientePagoNome = JOptionPane.showInputDialog("Qual o nome do destinatário? ");
            String clientePagoCPF = JOptionPane.showInputDialog("Qual o CPF do destinatário? ");
            for (int m = 0; m < contasF.size(); m++) {
                if ((contasF.get(m).getNome().equals(clientePagoNome)) &&
                        (contasF.get(m).getCPF().equals(clientePagoCPF))) {
                    JOptionPane.showMessageDialog(null, "Conta encontrada!");
                    indice_pagamento = m;
                    TransferênciaCF_CF(contasF.get(indice_CLIENTE),
                            contasF.get(indice_pagamento));
                    break;
                }
            }
            if (indice_pagamento == -1) {
                JOptionPane.showMessageDialog(null, "Essa conta não existe!");
            }
        } else {
            String clientePagoNome = JOptionPane.showInputDialog("Qual o nome do destinatário? ");
            String clientePagoCNPJ = JOptionPane.showInputDialog("Qual o CNPJ do destinatário? ");
            for (int m = 0; m < 10; m++) {
                if ((contasJ.get(m).getNome().equals(clientePagoNome)) &&
                        (contasJ.get(m).getCNPJ().equals(clientePagoCNPJ))) {
                    JOptionPane.showMessageDialog(null, "Conta encontrada!");
                    indice_pagamento = m;
                    TransferênciaCF_CJ(contasF.get(indice_CLIENTE),
                            contasJ.get(indice_pagamento));
                    break;
                }
            }
            if (indice_pagamento == -1) {
                JOptionPane.showMessageDialog(null, "Essa conta não existe!");
            }
        }

    }

    public static void Transferências_ContaJuridica() {
        indice_pagamento = -1;
        Object[] transferencias = { "Transferência para Cliente Fisico", "Transferência para Cliente Juridico" };
        Object selectedTransfers = JOptionPane.showInputDialog(null, "Que tipo de transferência desejarealizar?",
                "transferência", JOptionPane.INFORMATION_MESSAGE, null,
                transferencias, transferencias[0]);
        if (selectedTransfers == transferencias[0]) {
            String clientePagoNome = JOptionPane.showInputDialog("Qual o nome do destinatário? ");
            String clientePagoCPF = JOptionPane.showInputDialog("Qual o CPF do destinatário? ");
            for (int m = 0; m < contasF.size(); m++) {
                if ((contasF.get(m).getNome().equals(clientePagoNome)) &&
                        (contasF.get(m).getCPF().equals(clientePagoCPF))) {
                    JOptionPane.showMessageDialog(null, "Conta encontrada!");
                    indice_pagamento = m;
                    TransferênciaCJ_CF(contasJ.get(indice_CLIENTE),
                            contasF.get(indice_pagamento));
                    break;
                }
            }
            if (indice_pagamento == -1) {
                JOptionPane.showMessageDialog(null, "Essa conta não existe!");
            }
        } else {
            String clientePagoNome = JOptionPane.showInputDialog("Qual o nome do destinatário? ");
            String clientePagoCNPJ = JOptionPane.showInputDialog("Qual o CNPJ do destinatário? ");
            for (int m = 0; m < 10; m++) {
                if ((contasJ.get(m).getNome().equals(clientePagoNome)) &&
                        (contasJ.get(m).getCNPJ().equals(clientePagoCNPJ))) {
                    JOptionPane.showMessageDialog(null, "Conta 33 encontrada!");
                    indice_pagamento = m;
                    TransferênciaCJ_CJ(contasJ.get(indice_CLIENTE),
                            contasJ.get(indice_pagamento));
                    break;
                }
            }
            if (indice_pagamento == -1) {
                JOptionPane.showMessageDialog(null, "Essa contanão existe!");
            }
        }
    }

    public static void Operacoes_CF() {
        Object[] operations = { "Saque", "Depósito", "Transferência",
                "Extrato" };
        Object selectedOperation = JOptionPane.showInputDialog(null, "Que operação deseja realizar?",
                "operação", JOptionPane.INFORMATION_MESSAGE, null, operations,
                operations[0]);
        double novo_saldo;
        Transações transacao;
        if (selectedOperation == operations[0]) {
            novo_saldo = Saque(contasF.get(indice_CLIENTE).getSaldo());
            contasF.get(indice_CLIENTE).setSaldo(novo_saldo);
            transacao = new Transações("Saque", valor_saque,
                    contasF.get(indice_CLIENTE).getNome(),
                    contasF.get(indice_CLIENTE).getNome(),
                    contasF.get(indice_CLIENTE).getSaldo());
            contasF.get(indice_CLIENTE).setListaT(transação);
        } else if (selectedOperation == operations[1]) {
            novo_saldo = Deposito(contasF.get(indice_CLIENTE).getSaldo());
            contasF.get(indice_CLIENTE).setSaldo(novo_saldo);

            transacao = new Transacoes("Depósito", valor_depositado,
                    contasF.get(indice_CLIENTE).getNome(),
                    contasF.get(indice_CLIENTE).getNome(),
                    contasF.get(indice_CLIENTE).getSaldo());
            contasF.get(indice_CLIENTE).setListaT(transacao);
        } else if (selectedOperation == operations[2]) {
            Transferências_ContaFisica();
        } else {
            Extrato_Transações(contasF.get(indice_CLIENTE).getListaT());
        }
    }

    public static void Operacoes_CJ() {
        Object[] operations = { "Saque", "Depósito", "Transferência",
                "Extrato" };
        Object selectedOperation = JOptionPane.showInputDialog(null, "Que operação deseja realizar?",
                "operação", JOptionPane.INFORMATION_MESSAGE, null, operations,
                operations[0]);
        double novo_saldo;
        Transações transação;
        if (selectedOperation == operations[0]) {
            novo_saldo = Saque(contasJ.get(indice_CLIENTE).getSaldo());
            contasJ.get(indice_CLIENTE).setSaldo(novo_saldo);
            transação = new Transacoes("Saque", valor_saque,
                    contasJ.get(indice_CLIENTE).getNome(),
                    contasJ.get(indice_CLIENTE).getNome(),
                    contasJ.get(indice_CLIENTE).getSaldo());
            contasJ.get(indice_CLIENTE).setListaT(transacao);
        } else if (selectedOperation == operations[1]) {
            novo_saldo = Depósito(contasJ.get(indice_CLIENTE).getSaldo());
            contasJ.get(indice_CLIENTE).setSaldo(novo_saldo);
            transação = new Transacoes("Depósito", valor_depositado,
                    contasJ.get(indice_CLIENTE).getNome(),
                    contasJ.get(indice_CLIENTE).getNome(),
                    contasJ.get(indice_CLIENTE).getSaldo());
            contasJ.get(indice_CLIENTE).setListaT(transacao);
        } else if (selectedOperation == operations[2]) {
            Transferências_ContaJuridica();

        } else {
            Extrato_Transações(contasJ.get(indice_CLIENTE).getListaT());
        }
    }

}
