package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BddConnection {
	private static Connection cnn = null;
	
	//Singleton tiene constructor privado
	
	private BddConnection() {
		String servidor = "localhost";
		String database = "gestorpersonasstmvc";
		String usuario = "root";
		String password = "";
		String url = "jdbc:mysql://" + servidor+"/" + database;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			cnn = DriverManager.getConnection(url,usuario,password);
			System.out.println("Conexion exitosa");
		} catch (SQLException e) {
			System.out.println("Error de conexion!!");
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		if(cnn==null) {
			new BddConnection();
		}
		return cnn;
	}
	
	public static void cerrar(ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void cerrar(PreparedStatement pstmt) {
		try {
			if(pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void cerrar() {
		try {
			if(cnn!= null) {
				cnn.close();
				cnn=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
