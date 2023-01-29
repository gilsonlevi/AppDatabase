package modelo.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbstratoDAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("contato-jpa-hibernate");
	
	public EntityManager getConexao() {
		return emf.createEntityManager();
		
	}
}