package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Persona;
import modelo.Tarea;

@WebServlet("/ListarTareaController")
public class ListarTareaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ingreso a Listar Controller por GET");
		//1.- Obtener datos que me envían en la solicitud
		
	    HttpSession session = request.getSession();
	    String nombreUsuario = (String) session.getAttribute("nombreUsuario");
		
		
		//2.- Llamo al Modelo para obtener datos
		Tarea modeloTarea = new Tarea();
		List<Tarea> lista = modeloTarea.getTareas();
		
	    for(Tarea tar:lista) {
	    	System.out.println(tar);
	    }
		
		
		for(Tarea modeloTarea1: lista) {
			if(modeloTarea1.getResponsable() !="0" && modeloTarea1.getResponsable() != null) {
				
				if(modeloTarea1.getEstado() == "0") {
					modeloTarea1.setEstado("1");
				}				
			}
			if(modeloTarea1.getResponsable()==null) {
				modeloTarea1.setResponsable("0");
			}
		}
		
		modeloTarea.update(modeloTarea);
		
		
		//3.- Llamo a la Vista

		request.setAttribute("tareas", lista);
		request.setAttribute("nombreUsuario", nombreUsuario);
		request.getRequestDispatcher("jsp/listarTarea.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
