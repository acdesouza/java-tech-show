package componentes.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class BancoEJBTest {
	private static EJBContainer ejbContainer;
	private static Context ctx;

	@BeforeClass
	public static void setUp() {
		ejbContainer = EJBContainer.createEJBContainer();
		ctx = ejbContainer.getContext();
	}

	@AfterClass
	public static void tearDown() {
		if(ejbContainer != null) {
			ejbContainer.close();
		}
	}

	@Test
	public void deveCriarUmaContaSimples() throws NamingException {
		Cliente clienteSimples = new Cliente("Antonio Carlos de Souza");

		BancoEJB bancoEJB = (BancoEJB) ctx.lookup("java:global/classes/BancoEJB!componentes.model.BancoEJB");
		assertNotNull(bancoEJB);
		
		Conta contaNova = bancoEJB.criarConta(clienteSimples);
		
		assertNotNull(contaNova);
	}

	@Test
	public void deveCriarUmaContaAssociadaComCliente() throws NamingException {
		Cliente clienteSimples = new Cliente("Antonio Carlos de Souza");

		BancoEJB bancoEJB = (BancoEJB) ctx.lookup("java:global/classes/BancoEJB!componentes.model.BancoEJB");
		assertNotNull(bancoEJB);

		Conta contaNova = bancoEJB.criarConta(clienteSimples);

		assertNotNull(contaNova.getCliente());
		assertEquals(clienteSimples, contaNova.getCliente());
	}
}