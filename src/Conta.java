
public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected double saldoInicial;
	protected Cliente cliente;
	protected double limiteChequeEspecial;
	protected boolean chequeEspecialAtivo; 

	public Conta(Cliente cliente, double saldoInicial) {
		this.saldo = saldoInicial;
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.chequeEspecialAtivo = false;
		// chequeEspecial 50% do saldo ao criar a conta
		this.limiteChequeEspecial = 0.5 * this.saldo;
	}

	@Override
	public void sacar(double valor) {
		// se o saque for maior que o saldo e menor que o limite do cheque especial, ativa o cheque especial
		if (valor > saldo && saldo - valor >= limiteChequeEspecial) {
			
			saldo -= valor;
		} else if (valor > saldo && saldo - valor < -limiteChequeEspecial) {
			System.out.println("Saldo insuficiente para realizar o saque.");
		}
		else {
			saldo -= valor;
		}
		if (saldo < 0) {
			chequeEspecialAtivo = true;
		}
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
		if (saldo > 0) {
			chequeEspecialAtivo = false;
		}
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		System.out.println(String.format("Cheque especial: %.2f", this.limiteChequeEspecial));
		System.out.println(String.format("Cheque especial ativo: %s", this.chequeEspecialAtivo ? "Sim" : "Não"));
	}

	
}
