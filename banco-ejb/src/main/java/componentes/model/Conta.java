package componentes.model;

public class Conta {
	private final Cliente cliente;
	
	public Conta(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}
}