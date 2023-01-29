package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import modelo.entidade.Funcionario;

public class FuncionarioDAO extends AbstratoDAO{
	
	public Funcionario save(Funcionario funcionario) {
		EntityManager em = getConexao();
		try {
			em.getTransaction().begin();
			em.persist(funcionario);
			em.getTransaction().commit();
			
		} catch (Exception e) {
		System.err.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return funcionario;		
	}
	
	public Funcionario remove(Integer id) {
		EntityManager em = getConexao();
		Funcionario funcionario = null;
		try {
			funcionario = em.find(Funcionario.class, id);
			em.getTransaction().begin();
			em.remove(funcionario);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return funcionario;
	}
	
	public List<Funcionario> listarFuncionarios(){
		EntityManager em = getConexao();
		List<Funcionario> funcionarios = null;
		try {
			funcionarios = em.createQuery("from Funcionario").getResultList();
		} catch (Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		return funcionarios;
	}
	
	public Funcionario findById(Integer id) {
		EntityManager em = getConexao();
		Funcionario funcionario = null;
		try {
			funcionario = em.find(Funcionario.class, id);
		} catch (Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		return funcionario;
	}
}
