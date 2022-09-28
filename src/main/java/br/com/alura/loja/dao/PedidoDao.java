package br.com.alura.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;

public class PedidoDao {

	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}

	public void atualizar(Pedido pedido) {
		this.em.merge(pedido);
	}

	public void remover(Pedido pedido) {
		pedido = em.merge(pedido);
		this.em.remove(pedido);
	}
	
	public Produto buscarPorId(Long id) {
		return em.find(Produto.class, id);
	}
	
	public List<Pedido> buscarTodos() {
		String jpql = "SELECT p FROM PEdido p";
		return em.createQuery(jpql, Pedido.class).getResultList();
	}
	
	

}
