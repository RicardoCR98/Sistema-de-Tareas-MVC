package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Tarea;


@WebServlet("/AuxiliarTHController")
public class AuxiliarTHController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AuxiliarTHController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("Ingreso por POST auxiliar TH");

	    // Obtener la lista de tareas del atributo 'tareasUnitarias' en el request
	    Tarea modeloTarea = new Tarea();
		List<Tarea> listaTareas = (List<Tarea>) request.getSession().getAttribute("tareasUnitarias");
	    
	    for (Tarea tar : listaTareas) {
	        String valorCheckbox = request.getParameter("cbox-hecho-" + tar.getCodigo());
	        // Si el valor del checkbox es "2", significa que está marcado
	        if ("1".equals(valorCheckbox)) {
	            tar.setEstado(2); 
	        } else {
	            tar.setEstado(1); 
	        }
	    }
	   
        // Actualizar la lista de tareas en la sesión
        request.getSession().setAttribute("tareasUnitarias", listaTareas);

        // Actualizar las tareas en la base de datos (si es necesario)
        for (Tarea tarea : listaTareas) {
            modeloTarea.update(tarea);
        }
        
	    for(Tarea tar:listaTareas) {
	    	System.out.println(tar);
	    }
	    // Redirigir a la página de listado nuevamente
	    response.sendRedirect("ListarTareasPorHacerController");
	}



}
