
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

		List<Cliente> cliente = controladora.listarCliente();

		List<Consultas> consulta = controladora.listarConsulta();

		request.setAttribute("cliente", cliente);
		request.setAttribute("consulta", consulta);

		request.getRequestDispatcher("/consultas.jsp").forward(request, response);
	}
}
