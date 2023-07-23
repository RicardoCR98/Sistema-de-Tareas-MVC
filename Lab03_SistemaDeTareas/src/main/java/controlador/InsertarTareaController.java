package controlador;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Persona;
import modelo.Tarea;

@WebServlet("/InsertarTareaController")
public class InsertarTareaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertarTareaController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.- Obtener datos que me envían en la solicitud
		
		//2.- Llamo al Modelo para obtener datos
		
		//3.- Llamo a la Vista
		response.sendRedirect("jsp/insertarTarea.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1.- Obtener datos que me envian en la solicitud
		Integer codigo = Integer.parseInt(request.getParameter("codigo"));
		String nombre= request.getParameter("nombre");
		//2.- Llamo al modelo para obtener los datos
		Tarea tarea = new Tarea();
		tarea.setCodigo(codigo);
		tarea.setNombre(nombre);
		tarea.setEstado("0");

		request.setAttribute("tarea", tarea);
		
		
		Tarea modeloTarea = new Tarea();
		modeloTarea.create(tarea);
		
		//3.- LLamo a la vista
		
	    response.sendRedirect("ListarTareaController");
		
	}

}
