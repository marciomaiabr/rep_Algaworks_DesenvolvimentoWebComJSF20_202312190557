package pkgs.db;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class JDBCUtil {

	public static void main(String[] args) {
		(new JDBCUtil()).executa();
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
		String connectionUrl = "jdbc:sqlserver://localhost;trustServerCertificate=true;database=master;user=sa;password=senhasa;";
		Connection conn = null;
		String sql = " select CURRENT_TIMESTAMP ts ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(connectionUrl);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next())
				System.out.println("Connection successful...");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				ps.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void m2() {
		// cria banco de dados da aplicação
		String connectionUrl = "jdbc:sqlserver://localhost;trustServerCertificate=true;database=master;user=sa;password=senhasa;";
		Connection conn = null;
		String db = "db202312180612";
		String sql = "create database ".concat(db);
		PreparedStatement ps = null;
		try {
			conn = DriverManager.getConnection(connectionUrl);
			ps = conn.prepareStatement(sql);
			ps.execute();
			System.out.println("Operation successful...");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
