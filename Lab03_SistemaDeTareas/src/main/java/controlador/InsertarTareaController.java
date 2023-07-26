package controlador;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

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
	    // 1. Obtener datos que me envían en la solicitud (Si es necesario)
	    
	    // 2. Llamar al Modelo para obtener datos (Si es necesario)
	    Tarea modeloTarea = new Tarea();
	    List<Tarea> lista = modeloTarea.getTareas();

	    // 3. Realizar alguna lógica para preparar los datos antes de pasarlos a la vista
	    Integer cod;
	    if (!lista.isEmpty()) {
	        cod = lista.get(lista.size() - 1).getCodigo() + 1;
	    } else {
	        cod = 1; // Si la lista está vacía, se inicia el código en 1
	    }
	    System.out.println("El codigo es: "+ cod);
	    // 4. Guardar los datos en el objeto request para que la vista pueda acceder a ellos
	    request.setAttribute("cod", cod);
	    
		request.getRequestDispatcher("jsp/insertarTarea.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1.- Obtener datos que me envian en la solicitud

		String nombre= request.getParameter("nombre");
		//2.- Llamo al modelo para obtener los datos
		Tarea tarea = new Tarea();

		tarea.setNombre(nombre);
		tarea.setResponsable(1);
		tarea.setEstado(0);

		request.setAttribute("tarea", tarea);
		Tarea modeloTarea = new Tarea();
		modeloTarea.create(tarea);
		System.out.println(modeloTarea.toString());
		//3.- LLamo a la vista
		
	    response.sendRedirect("ListarTareaController");
		
	}

}
