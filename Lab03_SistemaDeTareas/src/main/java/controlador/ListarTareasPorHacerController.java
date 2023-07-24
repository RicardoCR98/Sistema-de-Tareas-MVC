package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Tarea;


@WebServlet("/ListarTareasPorHacerController")
public class ListarTareasPorHacerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListarTareasPorHacerController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("NUEVO INGRESO POR LiSTARTAREASPORHACERCONTROLLER");
		//1.- Obtener datos que me envían en la solicitud
		HttpSession session = request.getSession();
		if (session == null || session.getAttribute("nombreUsuario") == null) {
            // Si no existe una sesión o el atributo "username" no está presente en la sesión,
            // redirigir al usuario a la página de inicio de sesión (index.jsp)
            response.sendRedirect("index.html");
        } else {
		
	    
	    String nombreUsuario = (String) session.getAttribute("nombreUsuario");
		
		//2.- Llamo al Modelo para obtener datos
		Tarea modeloTarea = new Tarea();
		List<Tarea> lista = modeloTarea.getTareas();
		List<Tarea> aux = new ArrayList<>();
		
		String nombreAux = null;
		
		if(nombreUsuario.equals("Pepe")) {
			nombreAux = "1";
			for(Tarea tar:lista) {
				if(tar.getResponsable().equals(nombreAux)) {
					aux.add(tar);
					modeloTarea.update(tar);
				}
			}
			request.getSession().setAttribute("tareasUnitarias", aux);
		}else if(nombreUsuario.equals("Maria")) {
			nombreAux="2";
			for(Tarea tar:lista) {
				if(tar.getResponsable().equals(nombreAux)) {
					aux.add(tar);
					modeloTarea.update(tar);
				}
			}
			request.getSession().setAttribute("tareasUnitarias", aux);
		}else if(nombreUsuario.equals("Mariana")){
			nombreAux="3";
			for(Tarea tar:lista) {
				if(tar.getResponsable().equals(nombreAux)) {
					aux.add(tar);
					modeloTarea.update(tar);
				}
			}
			request.getSession().setAttribute("tareasUnitarias", aux);
		}
		
	    for(Tarea tar:lista) {
	    	System.out.println(tar);
	    }
	    

		//3.- Llamo a la Vista
		request.setAttribute("nombreUsuario", nombreUsuario);
		request.getRequestDispatcher("jsp/listarTareaTH.jsp").forward(request, response);}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
