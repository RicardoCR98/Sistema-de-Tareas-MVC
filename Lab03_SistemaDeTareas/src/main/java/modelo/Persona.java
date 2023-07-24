package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Persona implements Serializable {

	
	private static final long serialVersionUID =1L;
	private Integer id;
	private String nombre;
	private String password;
	
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
		Persona personaAutorizada = null;
		List<Persona> listPersonas = this.getPersona();
		for(Persona persona:listPersonas) {
			if(persona.getNombre().equals(usuario) && persona.getPassword().equals(password)) {
				personaAutorizada = persona;
				break;
			}
		}
		return personaAutorizada;
	}
	
	public List<Persona> getPersona(){
		
		if(personas ==null) {
			personas = new ArrayList<>();
			personas.add(new Persona(1, "Luis", "Luis123"));
			personas.add(new Persona(2, "Pepe", "Pepe123"));
			personas.add(new Persona(3, "Maria", "Maria123"));
			personas.add(new Persona(2, "Mariana", "Mariana123"));
		}
		return personas;
	}

}
