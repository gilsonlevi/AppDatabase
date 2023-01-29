package modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbstratoDAO {
	
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("academia-jpa");
	
	public static EntityManager getConexao() {
		return emf.createEntityManager();
	}
}
