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
		// 1.- Obtener datos que me envían en la solicitud

		HttpSession session = request.getSession();
		String nombreUsuario = (String) session.getAttribute("nombreUsuario");
		if (session == null || session.getAttribute("nombreUsuario") == null) {
			// Si no existe una sesión o el atributo "username" no está presente en la
			// sesión,
			// redirigir al usuario a la página de inicio de sesión (index.jsp)
			response.sendRedirect("index.html");
		} else {

			// 2.- Llamo al Modelo para obtener datos
			Tarea modeloTarea = new Tarea();
			List<Tarea> lista = modeloTarea.getTareas();
			
			for (Tarea modeloTarea1 : lista) {
				if (modeloTarea1.getResponsable() != 1 && modeloTarea1.getResponsable() != null) {

					if (modeloTarea1.getEstado() == 0 || modeloTarea1.getEstado()==null) {
						modeloTarea1.setEstado(1);
					}
					
				}else if (modeloTarea1.getResponsable()==1 || modeloTarea1.getResponsable() == null) {
					modeloTarea1.setEstado(0);
				}
			}
			for (Tarea tar : lista) {
				modeloTarea.update(tar);
				System.out.println(tar);
			}

			// 3.- Llamo a la Vista

			request.setAttribute("tareas", lista);
			request.setAttribute("nombreUsuario", nombreUsuario);
			request.getRequestDispatcher("jsp/listarTarea.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
