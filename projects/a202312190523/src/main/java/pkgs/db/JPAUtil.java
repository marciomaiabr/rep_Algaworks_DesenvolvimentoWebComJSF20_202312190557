package pkgs.db;

import java.lang.reflect.Method;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import pkgs.models.Empresa;

public class JPAUtil {

	public static void main(String[] args) {
		(new JPAUtil()).executa();
	}

	public void executa() {
		String resposta = JOptionPane.showInputDialog("Choose your option:");
		if (resposta == null || resposta.trim().equals("")) {
			System.out.println("Invalid option...");
		} else {
			Method method = null;
			try {
				method = this.getClass().getMethod("m".concat(resposta));
			} catch (NoSuchMethodException e) {
				System.err.println("Option no implemented...");
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (method == null) {
				System.err.println("Null method...");
			} else {
				try {
					method.invoke(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void m1() {
		// testa conexão

		Empresa empresa = null;

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Persistence.createEntityManagerFactory("myPUNoCreate");
			em = emf.createEntityManager();

			empresa = em.find(Empresa.class, 1);

			System.out.println("[empresa=" + empresa + "]");

			em.close();
			emf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void m2() {
		// cria entidades

		Empresa empresa = null;

		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction et = null;

		try {

			emf = Persistence.createEntityManagerFactory("myPUCreate");
			em = emf.createEntityManager();
			et = em.getTransaction();
			et.begin();

			empresa = new Empresa();
			empresa.setRazSoc("RazSoc Empresa 123...");
			empresa.setNomFantasia("Fantasia Empresa 123...");

			em.merge(empresa);

			et.commit();
			em.close();
			emf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
