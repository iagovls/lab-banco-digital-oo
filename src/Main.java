
public class Main {

	public static void main(String[] args) {
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
		
		Conta cc = new ContaCorrente(venilton, 100);
		Conta poupanca = new ContaPoupanca(venilton, 100);

		cc.depositar(100);
		cc.transferir(100, poupanca);
		cc.sacar(150);
		cc.depositar(150);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
		System.out.println("Listando clientes:");
		
	}

}
