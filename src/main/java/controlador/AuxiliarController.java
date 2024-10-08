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
	            Integer responsable = Integer.parseInt(request.getParameter(responsableParamName));
	            Integer estado = Integer.parseInt(request.getParameter("estado-" + tarea.getCodigo()));
	            tarea.setResponsable(responsable);
	            if(responsable!=1) {
	            	tarea.setEstado(estado);
	            }else if(responsable ==1) {
	            	tarea.setEstado(0);
	            }
	        }
	    }
	    
	    for (Tarea tarea : listaTareas) {
	        System.out.println(tarea.toString());
	    }

	    //2.- Llamar al método update de la clase Tarea para actualizar la lista existente
	    for (Tarea tarea : listaTareas) {
	        modeloTarea.update(tarea);
	    }

	    //3.- Llamar a la Vista
	    response.sendRedirect("ListarTareaController");
	}



}
