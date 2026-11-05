
package com.app.servlets;

import java.io.IOException;
import java.util.List;

import com.app.logica.Cliente;
import com.app.logica.Consultas;
import com.app.logica.ControladoraLogica;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SvListarConsulta")
public class SvListarConsulta extends HttpServlet {

	private final ControladoraLogica controladora = new ControladoraLogica();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String telefono = request.getParameter("telefono"); // traemos el datos telefono de consultar.jsp

		// Buscamos al cliente por su teléfono.
		Cliente cliente = controladora.BuscarClientePorTelefono(telefono);

		if (cliente != null) {

			// Buscamos solamente las consultas de ese cliente.
			List<Consultas> consulta = controladora.ListarConsultasPorCliente(cliente.getID_Cliente()); // buscamos el Id asociado al telefono del CLiente 

			request.setAttribute("consulta", consulta);

		} else {

			// No encontramos ningún cliente con ese teléfono.
			request.setAttribute("consulta", null);
			request.setAttribute("error", "No encontramos consultas con ese teléfono.");
		}

		request.getRequestDispatcher("/consultar.jsp").forward(request, response);
	}
}
