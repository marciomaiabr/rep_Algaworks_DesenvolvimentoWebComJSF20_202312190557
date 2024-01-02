package pkgs.uteis;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	public static void criaEntidades() {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("myPU");
			em = emf.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				em.close();
			} catch (Exception e) {
			}
			try {
				emf.close();
			} catch (Exception e) {
			}
		}
	}

}
