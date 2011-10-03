package componentes.model;

import javax.ejb.Stateless;

@Stateless
public class BancoEJB {

	public Conta criarConta(Cliente cliente) {
		return new Conta(cliente);
	}
}
