package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Tarea;

@WebServlet("/AuxiliarController")
public class AuxiliarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AuxiliarController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("Ingreso por POST auxiliar");

	    //1.- Obtener datos del formulario
	    Tarea modeloTarea = new Tarea();
	    List<Tarea> listaTareas = modeloTarea.getTareas();

	    for (Tarea tarea : listaTareas) {
	        String responsableParamName = "select-responsable-" + tarea.getCodigo();
	        
	        if (request.getParameterMap().containsKey(responsableParamName)) {
	            String responsable = request.getParameter(responsableParamName);
	            String estado = request.getParameter("estado-" + tarea.getCodigo());
	            System.out.println("Codigo: " + tarea.getCodigo() + "Nombre: " + tarea.getNombre() + ", Responsable: " + responsable + ", Estado: " + estado);
	            tarea.setResponsable(responsable);
	        }
	    }

	    //2.- Llamar al método update de la clase Tarea para actualizar la lista existente
	    for (Tarea tarea : listaTareas) {
	        modeloTarea.update(tarea);
	    }
	    
	    for(Tarea tar:listaTareas) {
	    	System.out.println(tar);
	    }

	    //3.- Llamar a la Vista
	    response.sendRedirect("ListarTareaController");
	}



}
