package com.algaworks.cursojsf2.financeiro.exes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.algaworks.cursojsf2.financeiro.model.Pessoa;

public class Exe01 {

	public static void main(String... args) {
		System.out.println("Exe01.main()");
		// tstJDBCTime();
		//
		tstJPATime();
	}

	private static void tstJDBCTime() {
		System.out.println("Exe01.tstJDBCTime()");
		LocalDateTime ldtI = LocalDateTime.now();
		Connection con = null;
		String connectionUrl = null;
		// connectionUrl =
		// "jdbc:sqlserver://localhost:1433;trustServerCertificate=true;database=db202312190523;user=sa;password=senhasa;";
		// connectionUrl =
		// "jdbc:sqlserver://localhost:1433;trustServerCertificate=true;database=db202312190523;";
		connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;trustServerCertificate=true;database=db202312190523;";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// con = DriverManager.getConnection(connectionUrl);
			con = DriverManager.getConnection(connectionUrl, "sa", "senhasa");
			ps = con.prepareStatement("select * from Pessoa");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("[" + rs.getInt("codigo") + "-" + rs.getString("nome") + "]");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e2) {
			}
			try {
				ps.close();
			} catch (Exception e2) {
			}
			try {
				con.close();
			} catch (Exception e2) {
			}
		}
		LocalDateTime ldtF = LocalDateTime.now();
		System.out.println("[Ns:ldtF-ldtI=" + (ldtF.getNano() - ldtI.getNano()) + "]");
		System.out.println("[Ms:ldtF-ldtI=" + ((ldtF.getNano() - ldtI.getNano()) / 1000000d) + "]");
		System.out.println("[S:ldtF-ldtI=" + (((ldtF.getNano() - ldtI.getNano()) / 1000000d) / 1000d) + "]");
		System.out.println("[ldtF.getSecond()-ldtI.getSecond()=" + (ldtF.getSecond() - ldtI.getSecond()) + "]");
		System.out.println("/Exe01.tstJDBCTime()");
	}

	private static void tstJPATime() {
		System.out.println("Exe01.tstJPATime()");
		LocalDateTime ldtI = LocalDateTime.now();
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		try {
			String pu = null;
			pu = "myPU";
			// pu = "tstPU1";
			entityManagerFactory = Persistence.createEntityManagerFactory(pu);
			calculaTime(ldtI, null);
			entityManager = entityManagerFactory.createEntityManager();
			calculaTime(ldtI, null);
			TypedQuery<Pessoa> typedQuery = entityManager.createQuery("from Pessoa", Pessoa.class);
			calculaTime(ldtI, null);
			List<Pessoa> list = typedQuery.getResultList();
			list.forEach(System.out::println);
			calculaTime(ldtI, null);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				entityManager.close();
			} catch (Exception e2) {
			}
			try {
				entityManagerFactory.close();
			} catch (Exception e2) {
			}
		}
		calculaTime(ldtI, null);
		System.out.println("/Exe01.tstJPATime()");
	}

	private static void calculaTime(LocalDateTime ldtI, LocalDateTime ldtF) {
		if(ldtF == null)
			ldtF = LocalDateTime.now();

		System.out.println("[Ns:ldtF-ldtI=" + (ldtF.getNano() - ldtI.getNano()) + "]");
		System.out.println("[Ms:ldtF-ldtI=" + ((ldtF.getNano() - ldtI.getNano()) / 1000000d) + "]");
		System.out.println("[S:ldtF-ldtI=" + (((ldtF.getNano() - ldtI.getNano()) / 1000000d) / 1000d) + "]");
		System.out.println("[ldtF.getSecond()-ldtI.getSecond()=" + (ldtF.getSecond() - ldtI.getSecond()) + "]");
	}

}
