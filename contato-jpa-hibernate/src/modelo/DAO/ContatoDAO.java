package modelo.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import modelo.entidade.Contato;


public class ContatoDAO extends AbstratoDAO{
	
	public Contato save(Contato contato) {
		EntityManager em = getConexao();
		
		try {
			em.getTransaction().begin();
			em.persist(contato);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return contato;
	}

	public Contato remove(Integer id) {
		EntityManager em = getConexao();
		Contato contato = null;
		try {
			contato = em.find(Contato.class, id);
			em.getTransaction().begin();
			em.remove(contato);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return contato;
	}
	
	public Contato atualizar(Integer id, int celular) {
		EntityManager em = getConexao();
		Contato contato = null;
		try {
			contato = em.find(Contato.class, id);
			em.getTransaction().begin();
			contato.setCelular(celular);
			em.merge(contato);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return contato;
	}
	
	public Contato encontrarPeloId(Integer id) {
		EntityManager em = getConexao();
		Contato contato = null;
		try {
			contato = em.find(Contato.class, id);
		} catch (Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		return contato;
	}
	
	public List<Contato> finAll() {
		List<Contato> contatos = null;
		EntityManager em = getConexao();
		
		try {
			contatos = em.createQuery("from Contato").getResultList();
		} catch (Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		return contatos;
	}
	
}

