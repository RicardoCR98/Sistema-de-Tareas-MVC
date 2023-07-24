package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tarea implements Serializable {
	
	private static final long serialVersionUID =1L;
	private Integer codigo;
	private String nombre;
	private String responsable;
	private String estado;
	
	private static List<Tarea> tareas = null;
	
	public Tarea() {
		
	}

	public Tarea(Integer codigo, String nombre, String responsable, String estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.responsable = responsable;
		this.estado = estado;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setTareas(List<Tarea> tareas) {
		Tarea.tareas = tareas;
	}

	//Tareas pre-armadas
	
	public List<Tarea> getTareas(){
		//0 -> seleccione
		//1 -> pepe
		//2 -> Maria
		//3 -> Mariana
		
		// 0 -> Por asignar
		// 1 -> Por hacer
		// 2 -> Completado
		
		//if (responsable != 0){ estado = "Por hacer" }
		if(tareas ==null) {
			tareas = new ArrayList<>();
			tareas.add(new Tarea(1, "Pagar salarios" ,"1" ,"1"));
			tareas.add(new Tarea(2, "Becas por excelencia" ,"3" ,"1"));
			tareas.add(new Tarea(3, "Pagos 1" ,"1" ,"1"));
			tareas.add(new Tarea(4, "Pagos 2" ,"1" ,"1"));
			tareas.add(new Tarea(5, "Pagos 3" ,"1" ,"1"));
			tareas.add(new Tarea(12, "Becas 2" ,"3" ,"1"));
			tareas.add(new Tarea(6, "Becas 3" ,"3" ,"1"));
		}
		return tareas;
	}

	//Agregar tarea
	public void create(Tarea p) {
		this.getTareas().add(p);
	}    
    //Update
    
	public void update(Tarea t) {
	    List<Tarea> listTarea = this.getTareas();

	    for (Tarea tarea : listTarea) {
	        if (tarea.getCodigo() == t.getCodigo()) {
	            tarea.setNombre(t.getNombre());
	            tarea.setEstado(t.getEstado());
	            tarea.setResponsable(t.getResponsable());
	            break;
	        }
	    }
	}

    // Busqueda de tarea por ID
    public Tarea getByID(int codigo) {
        List<Tarea> listaTareas = getTareas();

        for (Tarea tarea : listaTareas) {
            if (tarea.getCodigo() == codigo) {
                return tarea;
            }
        }
        return null;
    }
    
    
    @Override
    public String toString() {
        // Devuelve una representación de cadena significativa de la tarea
        return "Codigo: " + codigo + ", Nombre: " + nombre + ", Responsable: " + responsable + ", Estado: " + estado;
    }
	
}
