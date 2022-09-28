package br.com.alura.loja.testes;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeCliente {

	public static void main(String[] args) {
		cadastrarCliente();

	}
	
	
	
	private static void cadastrarCliente() {
		
		Cliente adriano = new Cliente("Adriano Pavaneli", "5456134553");
		
		EntityManager em = JPAUtil.getEntityManager();
		ClienteDao clienteDao = new ClienteDao(em);
		
		
		em.getTransaction().begin();
		
		clienteDao.cadastrar(adriano);
		
		
		em.getTransaction().commit();
		em.close();
	}

}
