public class ContaCorrente extends Conta {
    private double taxaManutencao;

    // Construtor
    public ContaCorrente(String numeroConta, double saldoInicial, double taxaManutencao) {
        super(numeroConta, saldoInicial);
        this.taxaManutencao = taxaManutencao;
    }

    // Implementação do método abstrato
    @Override
    public void aplicarTaxa() {
        double taxa = getSaldo() * (taxaManutencao / 100);
        sacar(taxa);
        System.out.println("Taxa de manutenção de R$" + taxa + " aplicada na conta corrente.");
    }
}
