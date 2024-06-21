public class ContaPoupanca extends Conta {
    private double taxaRendimento;

    // Construtor
    public ContaPoupanca(String numeroConta, double saldoInicial, double taxaRendimento) {
        super(numeroConta, saldoInicial);
        this.taxaRendimento = taxaRendimento;
    }

    // Implementação do método abstrato
    @Override
    public void aplicarTaxa() {
        double rendimento = getSaldo() * (taxaRendimento / 100);
        depositar(rendimento);
        System.out.println("Rendimento de R$" + rendimento + " aplicado na conta poupança.");
    }
}
