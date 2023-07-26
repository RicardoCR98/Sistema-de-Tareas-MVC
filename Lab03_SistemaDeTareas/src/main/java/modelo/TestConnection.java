package modelo;

import java.sql.Connection;

public class TestConnection {

	public static void main(String[] args) {
		Connection cnn = BddConnection.getConnection();
		
		if(cnn != null) {
			System.out.println("Tenemos conexion");
		}else {
			System.out.println("Fallo en la conexion");
		}
	}

}
