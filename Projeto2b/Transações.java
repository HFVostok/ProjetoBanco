package banco;

public class Transacoes {
    String operacao = 9;
    double valor;
    String remetente;
    String destinatario;
    double saldo_final;

    public Transacoes(String operacao, double valor, String remetente, String destinatario, double saldo_final) {
        this.operacao = operacao;
        this.valor = valor;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.saldo_final = saldo_final;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public double getSaldo_final() {
        return saldo_final;
    }

    public void setSaldo_final(double saldo_final) {
        this.saldo_final = saldo_final;
    }

    @Override
    public String toString() {
        return this.operacao + "| valor: " + this.valor + " remetente: " + this.remetente + "| destinatario: " +
                this.destinatario + "| saldo final: " + this.saldo_final + "\n";
    }
}

public class Banco {
    static ArrayList<PessoaFisica> contasF = new ArrayList<>();
    static ArrayList<PessoaJuridica> contasJ = new ArrayList<>();
    static int indice_CLIENTE;

    public static void login_ContaFisica() {
        indice_CLIENTE = -1;
        int login = JOptionPane.showConfirmDialog(null, "Já possui conta?", "Selecione uma opcao:",
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
                JOptionPane.showMessageDialog(null, "Essa conta não existe!");
                JOptionPane.showMessageDialog(null, "Seja bem vindo " + newcontaF() + " !");
                indice_CLIENTE = contasF.size() - 1;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seja bem vindo "
                    + newcontaF() + " !");
            indice_CLIENTE = contasF.size() - 1;
        }
    }

}

    public static void login_ContaJuridica() {
        indice_CLIENTE = -1;
        int login = JOptionPane.showConfirmDialog(null, "Já possui conta?", "Selecione uma opcao:",
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
                JOptionPane.showMessageDialog(null, "Essa conta não existe!");
                JOptionPane.showMessageDialog(null, "Seja bem vindo " + newcontaJ() + " !");
                indice_CLIENTE = contasJ.size() - 1;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seja bem vindo "
                    + newcontaJ() + " !");
            indice_CLIENTE = contasJ.size() - 1;
        }
    }

    public class Banco {
        static ArrayList<PessoaFisica> contasF = new ArrayList<>();
        static ArrayList<PessoaJuridica> contasJ = new ArrayList<>();
        static double valor_saque;

        public static double Saque(double valor_saldo) {
            valor_saque = Double.parseDouble(JOptionPane.showInputDialog("Qual será o valor do saque?"));
            if (valor_saldo > valor_saque) {
                valor_saldo -= valor_saque;
                JOptionPane.showMessageDialog(null, "Saque realizado.");
                return valor_saldo;
            } else {
                JOptionPane.showMessageDialog(null, "O saque não pode ser  realizado. Saldo insuficiente.");
                int Saque_inesperado = JOptionPane.showConfirmDialog(null, "Deseja trocar o valor do  saque?",
                        "Selecione uma opcao:", JOptionPane.YES_NO_OPTION);
                if (Saque_inesperado == -1) {
                    valor_saldo = Saque(valor_saldo);
                    return valor_saldo;
                } else {
                    return valor_saldo;
                }
            }
        }
    }

    public class Banco {
        static ArrayList<PessoaFisica> contasF = new ArrayList<>();
        static ArrayList<PessoaJuridica> contasJ = new ArrayList<>();
        static double valor_depositado;

        public static double Depósito(double valor_saldo) {
            valor_depositado = Double.parseDouble(JOptionPane.showInputDialog("Qual será o valor do depósito?"));
            valor_saldo += valor_depositado;
            JOptionPane.showMessageDialog(null, "Depósito realizado.");
            return valor_saldo;
        }
    }

    public static void Transferencias_ContaFisica(){
                indice_pagamento = -1;
                Object[] transferencias = {"Transferencia para Cliente Fisico", "Transferencia para Cliente Juridico"};
                Object selectedTransfers =
                JOptionPane.showInputDialog(null, "Que tipo de transferencia deseja realizar?", "transferencia", JOptionPane.INFORMATION_MESSAGE, null,
                transferencias, transferencias[0]);
                if (selectedTransfers == transferencias[0]){
                String clientePagoNome =
                JOptionPane.showInputDialog("Qual o nome do destinatario? ");
                String clientePagoCPF =
                16
                JOptionPane.showInputDialog("Qual o CPF do destinatario? ");
                for (int m = 0; m < contasF.size(); m++){
                if
                ((contasF.get(m).getNome().equals(clientePagoNome)) &&
                (contasF.get(m).getCPF().equals(clientePagoCPF))){
                JOptionPane.showMessageDialog(null, "Conta encontrada!");
                indice_pagamento = m;
                TransferenciaCF_CF(contasF.get(indice_CLIENTE),
                contasF.get(indice_pagamento));
                break;
                }
                }
                if (indice_pagamento == -1){
                JOptionPane.showMessageDialog(null, "Essa conta não existe!");
                }
                } else {
                String clientePagoNome =
                JOptionPane.showInputDialog("Qual o nome do destinatario? ");
                String clientePagoCNPJ =
                JOptionPane.showInputDialog("Qual o CNPJ do destinatario? ");
                for (int m = 0; m < 10; m++){
                if
                ((contasJ.get(m).getNome().equals(clientePagoNome)) &&
                (contasJ.get(m).getCNPJ().equals(clientePagoCNPJ))){
                JOptionPane.showMessageDialog(null, "Conta encontrada!");
                indice_pagamento = m;
                TransferenciaCF_CJ(contasF.get(indice_CLIENTE),
                contasJ.get(indice_pagamento));
                break;
                }
                }
                if (indice_pagamento == -1){
                JOptionPane.showMessageDialog(null, "Essa conta não existe!");
                }
                }
                }

    public static void TransferenciaCF_CF(PessoaFisica cliente_perde,
            PessoaFisica cliente_ganha) {
        valor_troca = Double.parseDouble(JOptionPane.showInputDialog("Qual será o valor do pagamento?"));
        cliente_perde.setSaldo(cliente_perde.getSaldo() -
                valor_troca);
        cliente_ganha.setSaldo(cliente_ganha.getSaldo() +
                valor_troca);
        cliente_perde.setListaT(new Transações("Transferencia",
                valor_troca, cliente_perde.getNome(), cliente_ganha.getNome(),
                cliente_perde.getSaldo()));
        cliente_ganha.setListaT(new Transações("Transferencia",
                valor_troca, cliente_perde.getNome(), cliente_ganha.getNome(),
                cliente_ganha.getSaldo()));
        JOptionPane.showMessageDialog(null, "Transferencia realizada.");
    }public static void TransferenciaCF_CJ(PessoaFisica cliente_perde, PessoaJuridica cliente_ganha){
                18
                valor_troca = Double.parseDouble(JOptionPane.showInputDialog("Qual será o valor do pagamento?"));
                cliente_perde.setSaldo(cliente_perde.getSaldo() -
                valor_troca);
                cliente_ganha.setSaldo(cliente_ganha.getSaldo() +
                valor_troca);
                cliente_perde.setListaT(new Transações ("Transferencia",
                valor_troca, cliente_perde.getNome(), cliente_ganha.getNome(),
                cliente_perde.getSaldo()));
                cliente_ganha.setListaT(new Transações ("Transferencia",
                valor_troca, cliente_perde.getNome(), cliente_ganha.getNome(),
                cliente_ganha.getSaldo()));
                JOptionPane.showMessageDialog(null, "Transferencia
                realizada.");
                }

    public static void Transferencias_ContaJuridica(){
                    indice_pagamento = -1;
                    Object[] transferencias = {"Transferencia para Cliente Fisico", "Transferencia para Cliente Juridico"};
                    Object selectedTransfers =
                    JOptionPane.showInputDialog(null, "Que tipo de transferencia deseja realizar?", "transferencia", JOptionPane.INFORMATION_MESSAGE, null,
                    transferencias, transferencias[0]);
                    if (selectedTransfers == transferencias[0]){
                    String clientePagoNome =
                    JOptionPane.showInputDialog("Qual o nome do destinatario? ");
                    String clientePagoCPF =
                    JOptionPane.showInputDialog("Qual o CPF do destinatario? ");
                    for (int m = 0; m < contasF.size(); m++){
                    if
                    ((contasF.get(m).getNome().equals(clientePagoNome)) &&
                    19
                    (contasF.get(m).getCPF().equals(clientePagoCPF))){
                    JOptionPane.showMessageDialog(null, "Conta
                    encontrada!");
                    indice_pagamento = m;
                    TransferenciaCJ_CF(contasJ.get(indice_CLIENTE),
                    contasF.get(indice_pagamento));
                    break;
                    }
                    }
                    if (indice_pagamento == -1){
                    JOptionPane.showMessageDialog(null, "Essa conta
                    não existe!");
                    }
                    } else {
                    String clientePagoNome =
                    JOptionPane.showInputDialog("Qual o nome do destinatario? ");
                    String clientePagoCNPJ =
                    JOptionPane.showInputDialog("Qual o CNPJ do destinatario? ");
                    for (int m = 0; m < 10; m++){
                    if
                    ((contasJ.get(m).getNome().equals(clientePagoNome)) &&
                    (contasJ.get(m).getCNPJ().equals(clientePagoCNPJ))){
                    JOptionPane.showMessageDialog(null, "Conta
                    encontrada!");
                    indice_pagamento = m;
                    TransferenciaCJ_CJ(contasJ.get(indice_CLIENTE),
                    contasJ.get(indice_pagamento));
                    break;
                    }
                    }
                    if (indice_pagamento == -1){
                    JOptionPane.showMessageDialog(null, "Essa conta
                    não existe!");
                    }
                    }
                    }

    public static void TransferenciaCJ_CF(PessoaJuridica
                    cliente_perde, PessoaFisica cliente_ganha){
                    valor_troca =
                    Double.parseDouble(JOptionPane.showInputDialog("Qual será o valor do
                    pagamento?"));
                    cliente_perde.setSaldo(cliente_perde.getSaldo() -
                    valor_troca);
                    cliente_ganha.setSaldo(cliente_ganha.getSaldo() +
                    valor_troca);
                    cliente_perde.setListaT(new Transações ("Transferencia",
                    valor_troca, cliente_perde.getNome(), cliente_ganha.getNome(),
                    cliente_perde.getSaldo()));
                    cliente_ganha.setListaT(new Transações ("Transferencia",
                    valor_troca, cliente_perde.getNome(), cliente_ganha.getNome(),
                    cliente_ganha.getSaldo()));
                    JOptionPane.showMessageDialog(null, "Transferencia
                    realizada.");
                    }

    public static void TransferenciaCJ_CJ(PessoaJuridica
                    cliente_perde, PessoaJuridica cliente_ganha){
                    valor_troca =
                    Double.parseDouble(JOptionPane.showInputDialog("Qual será o valor do
                    21
                    pagamento?"));
                    cliente_perde.setSaldo(cliente_perde.getSaldo() -
                    valor_troca);
                    cliente_ganha.setSaldo(cliente_ganha.getSaldo() +
                    valor_troca);
                    cliente_perde.setListaT(new Transações ("Transferencia",
                    valor_troca, cliente_perde.getNome(), cliente_ganha.getNome(),
                    cliente_perde.getSaldo()));
                    cliente_ganha.setListaT(new Transações ("Transferencia",
                    valor_troca, cliente_perde.getNome(), cliente_ganha.getNome(),
                    cliente_ganha.getSaldo()));
                    JOptionPane.showMessageDialog(null, "Transferencia
                    realizada.");   } System.out.println(Extrato);

    public static void Operações_CF() {
        Object[] operations = { "Saque", "Depósito", "Transferencia",
                "Extrato" };
        Object selectedOperation = JOptionPane.showInputDialog(null, "Que operacao deseja realizar?",
                "operacao", JOptionPane.INFORMATION_MESSAGE, null, operations,
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
            contasF.get(indice_CLIENTE).setListaT(transacao);
        } else if (selectedOperation == operations[1]) {
            novo_saldo = Depósito(contasF.get(indice_CLIENTE).getSaldo());
            contasF.get(indice_CLIENTE).setSaldo(novo_saldo);
            transacao = new Transações("Depósito", valor_depositado,
                    contasF.get(indice_CLIENTE).getNome(),
                    contasF.get(indice_CLIENTE).getNome(),
                    contasF.get(indice_CLIENTE).getSaldo());
            contasF.get(indice_CLIENTE).setListaT(transacao);
        } else if (selectedOperation == operations[2]) {
            Transferencias_ContaFisica();
        } else {
            Extrato_Transações(contasF.get(indice_CLIENTE).getListaT());
        }
    }23

    public static void Operações_CJ() {
        Object[] operations = { "Saque", "Depósito", "Transferencia",
                "Extrato" };
        Object selectedOperation = JOptionPane.showInputDialog(null, "Que operacao deseja realizar?",
                "operacao", JOptionPane.INFORMATION_MESSAGE, null, operations,
                operations[0]);
        double novo_saldo;
        Transações transacao;
        if (selectedOperation == operations[0]) {
            novo_saldo = Saque(contasJ.get(indice_CLIENTE).getSaldo());
            contasJ.get(indice_CLIENTE).setSaldo(novo_saldo);
            transacao = new Transações("Saque", valor_saque,
                    contasJ.get(indice_CLIENTE).getNome(),
                    contasJ.get(indice_CLIENTE).getNome(),
                    contasJ.get(indice_CLIENTE).getSaldo());
            contasJ.get(indice_CLIENTE).setListaT(transacao);
        } else if (selectedOperation == operations[1]) {
            novo_saldo = Depósito(contasJ.get(indice_CLIENTE).getSaldo());
            contasJ.get(indice_CLIENTE).setSaldo(novo_saldo);
            transacao = new Transações("Depósito", valor_depositado,
                    contasJ.get(indice_CLIENTE).getNome(),
                    contasJ.get(indice_CLIENTE).getNome(),
                    contasJ.get(indice_CLIENTE).getSaldo());
            contasJ.get(indice_CLIENTE).setListaT(transacao);
        } else if (selectedOperation == operations[2]) {
            Transferencias_ContaJuridica();
        } else {
            Extrato_Transações(contasJ.get(indice_CLIENTE).getListaT());
        }
    }
