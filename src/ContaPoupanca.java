
public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente, double saldoInicial) {
		super(cliente, saldoInicial);
		
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupan�a ===");
		super.imprimirInfosComuns();
	}
}
