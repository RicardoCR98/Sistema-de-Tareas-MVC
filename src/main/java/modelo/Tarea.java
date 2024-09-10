package modelo;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Tarea implements Serializable {
	
	private static final long serialVersionUID =1L;
	
	final String SQL_SELECT_ALL = "SELECT * FROM tarea;";
	final String SQL_SELECT_BY_ID = "SELECT * FROM tarea WHERE id = ?";
	final String SQL_INSERT = "INSERT INTO tarea (nombre, idresponsable,estado) VALUES (?,?,?)";
	final String SQL_DELETE_BY_ID = "DELETE FROM persona WHERE id = ?";
	final String SQL_UPDATE = "UPDATE tarea SET nombre = ? , idresponsable = ?, estado=? WHERE id= ?";
	
	private Integer codigo;
	private String nombre;
	private Integer responsable;
	private Integer estado;
	
	private static List<Tarea> tareas = null;
	
	public Tarea() {
		
	}

	public Tarea(Integer codigo, String nombre, Integer responsable, Integer estado) {
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

	public Integer getResponsable() {
		return responsable;
	}

	public void setResponsable(Integer responsable) {
		this.responsable = responsable;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
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
		
		//Para el phpMyadmin
		// 0 -> Seleccione
		// 1 -> Luis
		// 2 -> Pepe
		// 3 -> Maria
		// 4 -> Mariana
		
		// 0 -> Por asignar
		// 1 -> Por hacer
		// 2 -> Completado
		
		//if (responsable != 0){ estado = "Por hacer" }
		
		/*if(tareas ==null) {
			tareas = new ArrayList<>();
			tareas.add(new Tarea(1, "Pagar salarios" ,"1" ,"1"));
			tareas.add(new Tarea(2, "Becas por excelencia" ,"3" ,"1"));
			tareas.add(new Tarea(3, "Pagos 1" ,"1" ,"1"));
			tareas.add(new Tarea(4, "Pagos 2" ,"1" ,"1"));
			tareas.add(new Tarea(5, "Pagos 3" ,"1" ,"1"));
			tareas.add(new Tarea(12, "Becas 2" ,"3" ,"1"));
			tareas.add(new Tarea(6, "Becas 3" ,"3" ,"1"));
		}
		return tareas;*/
		List<Tarea> listaTarea = new ArrayList<>();
		try {
			PreparedStatement pstm = BddConnection.getConnection().prepareStatement(SQL_SELECT_ALL);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				Tarea tarea = new Tarea();
				tarea.setCodigo(rs.getInt("id"));
				tarea.setNombre(rs.getString("nombre"));
				tarea.setResponsable(rs.getInt("idresponsable"));
				tarea.setEstado(rs.getInt("estado"));
				listaTarea.add(tarea);
			}
			BddConnection.cerrar(rs);
			BddConnection.cerrar(pstm);
			BddConnection.cerrar();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaTarea;
	}

	//Agregar tarea
	public void create(Tarea t) {
		this.getTareas().add(t);
		
		try {
			PreparedStatement pstm = BddConnection.getConnection().prepareStatement(SQL_INSERT);
			pstm.setString(1, t.getNombre());
			pstm.setInt(2, t.getResponsable());
			pstm.setInt(3, t.getEstado());
			pstm.executeUpdate();

			BddConnection.cerrar(pstm);
			BddConnection.cerrar();

		} catch (SQLException e) {
			e.printStackTrace();
		}
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
		
		try {
			PreparedStatement pstm= BddConnection.getConnection().prepareStatement(SQL_UPDATE);
			pstm.setString(1, t.getNombre());
			pstm.setInt(2, t.getResponsable());
			pstm.setInt(3, t.getEstado());
			pstm.setInt(4, t.getCodigo());
			
			pstm.executeUpdate();
			
			BddConnection.cerrar(pstm);
			BddConnection.cerrar();
		} catch (Exception e) {
			e.printStackTrace();
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
