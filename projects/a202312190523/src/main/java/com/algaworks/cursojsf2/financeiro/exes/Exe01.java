package com.algaworks.cursojsf2.financeiro.exes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;

public class Exe01 {

	public static void main(String... args) {
		System.out.println("Exe01.main()");
		tstJDBCTime();
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

}
