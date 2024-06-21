import java.util.HashMap;
import java.util.Map;

public class BancoDigital {
    private String nome;
    private Map<String, Conta> contas;

    // Construtor
    public BancoDigital(String nome) {
        this.nome = nome;
        this.contas = new HashMap<>();
    }

    // Métodos do Banco
    public void cadastrarConta(Conta conta) {
        contas.put(conta.getNumeroConta(), conta);
        System.out.println("Conta " + conta.getNumeroConta() + " cadastrada com sucesso no Banco " + nome);
    }

    public void depositar(String numeroConta, double valor) {
        Conta conta = contas.get(numeroConta);
        if (conta != null) {
            conta.depositar(valor);
        } else {
            System.out.println("Conta " + numeroConta + " não encontrada.");
        }
    }

    public void sacar(String numeroConta, double valor) {
        Conta conta = contas.get(numeroConta);
        if (conta != null) {
            conta.sacar(valor);
        } else {
            System.out.println("Conta " + numeroConta + " não encontrada.");
        }
    }

    public void transferir(String origem, String destino, double valor) {
        Conta contaOrigem = contas.get(origem);
        Conta contaDestino = contas.get(destino);
        if (contaOrigem != null && contaDestino != null) {
            contaOrigem.transferir(contaDestino, valor);
        } else {
            System.out.println("Conta de origem ou destino não encontrada.");
        }
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public Map<String, Conta> getContas() {
        return contas;
    }

    // Método principal para execução de testes
    public static void main(String[] args) {
        BancoDigital meuBanco = new BancoDigital("Meu Banco");

        // Criando e cadastrando contas
        ContaCorrente cc1 = new ContaCorrente("001", 1000, 2.0);
        ContaPoupanca cp1 = new ContaPoupanca("002", 500, 1.5);
        meuBanco.cadastrarConta(cc1);
        meuBanco.cadastrarConta(cp1);

        // Realizando operações
        meuBanco.depositar("001", 500);
        meuBanco.sacar("001", 200);
        meuBanco.transferir("001", "002", 300);

        // Aplicando taxas e rendimentos
        cc1.aplicarTaxa();
        cp1.aplicarTaxa();
    }
}
