package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import modelo.entidade.Aluno;
import modelo.entidade.Funcionario;

public class AlunoDAO extends AbstratoDAO{

	public Aluno save(Aluno aluno) {
		EntityManager em = getConexao();
		try {
			em.getTransaction().begin();
			em.persist(aluno);
			em.getTransaction().commit();
			
		} catch (Exception e) {
		System.err.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return aluno;		
	}
	
	public Aluno remove(Integer id) {
		EntityManager em = getConexao();
		Aluno aluno = null;
		try {
			aluno = em.find(Aluno.class, id);
			em.getTransaction().begin();
			em.remove(aluno);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return aluno;
	}
	
	public List<Aluno> listarAlunos(){
		EntityManager em = getConexao();
		List<Aluno> alunos = null;
		try {
			alunos = em.createQuery("from Aluno").getResultList();
		} catch (Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		return alunos;
	}
	
	public Aluno findById(Integer id) {
		EntityManager em = getConexao();
		Aluno aluno = null;
		try {
			aluno = em.find(Aluno.class, id);
		} catch (Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		return aluno;
	}
}
