package modelo;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Persona implements Serializable {

	
	private static final long serialVersionUID =1L;
	final String SQL_SELECT_ALL = "SELECT * FROM persona;";
	final String SQL_AUTORIZAR = "SELECT * FROM persona WHERE nombre = ? AND password = ?";
	
	private Integer id;
	private String nombre;
	private String password;
	private Boolean esadmin;
	
	private static List<Persona> personas = null;
	
	public Persona(){	
	}
	

	public Persona(Integer id, String nombre, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
	}

	public Persona autorizar(String usuario, String password) {
		/*
		Persona personaAutorizada = null;
		List<Persona> listPersonas = this.getPersona();
		for(Persona persona:listPersonas) {
			if(persona.getNombre().equals(usuario) && persona.getPassword().equals(password)) {
				personaAutorizada = persona;
				break;
			}
		}
		return personaAutorizada;
		*/
		Persona personaAutorizada = null;
		try {
			PreparedStatement pstm= BddConnection.getConnection().prepareStatement(SQL_AUTORIZAR);
			pstm.setString(1, usuario);
			pstm.setString(2, password);
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Persona persona = new Persona();
				persona.setId(rs.getInt("id"));
				persona.setNombre(rs.getString("nombre"));
				persona.setPassword(rs.getString("password"));
				persona.setEsadmin(rs.getBoolean("esadmin"));
				personaAutorizada = persona;
			}
			BddConnection.cerrar(rs);
			BddConnection.cerrar(pstm);
			BddConnection.cerrar( );
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personaAutorizada;
		
	}
	
	public List<Persona> getPersona(){
		/*
		if(personas ==null) {
			personas = new ArrayList<>();
			personas.add(new Persona(1, "Luis", "Luis123"));
			personas.add(new Persona(2, "Pepe", "Pepe123"));
			personas.add(new Persona(3, "Maria", "Maria123"));
			personas.add(new Persona(2, "Mariana", "Mariana123"));
		}
		return personas;
		
		*/
		
		List<Persona> listaPersonas = new ArrayList<>();

		try {
			PreparedStatement pstm = BddConnection.getConnection().prepareStatement(SQL_SELECT_ALL);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				Persona persona = new Persona();
				persona.setId(rs.getInt("id"));
				persona.setNombre(rs.getString("nombre"));
				persona.setPassword(rs.getString("password"));
				persona.setEsadmin(rs.getBoolean("esadmin"));

				listaPersonas.add(persona);
			}
			BddConnection.cerrar(rs);
			BddConnection.cerrar(pstm);
			BddConnection.cerrar();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaPersonas;
	}
	

	@Override
	public String toString() {
		return "Persona [ id=" + id + ", nombre=" + nombre + ", password=" + password + ", esadmin=" + esadmin + "]";
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Boolean getEsadmin() {
		return esadmin;
	}

	public void setEsadmin(Boolean esadmin) {
		this.esadmin = esadmin;
	}

}
