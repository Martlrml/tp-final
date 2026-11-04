
package com.app.servlets;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import com.app.logica.Cliente;
import com.app.logica.Consulta;
import com.app.logica.ControladoraLogica;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SvCrearConsulta")
public class SvCrearConsulta extends HttpServlet {

	private final ControladoraLogica controladora = new ControladoraLogica();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		try {
			String nombre = request.getParameter("nombre");
			String telefono = request.getParameter("telefono");
			String modelo = request.getParameter("modelo");
			String descripcion = request.getParameter("descripcion");

			// El JSP no envía fechaNacimiento.
			// Se usa la fecha actual para cumplir la validación de la lógica.
			Cliente cliente = new Cliente(nombre, telefono);

			Consulta consulta = new Consulta(modelo, descripcion, cliente);
			
			controladora.crearConsulta(cliente, consulta);

			response.sendRedirect(request.getContextPath() + "/index.jsp");

		}
		catch (Exception e) {
		    String msg = e.getMessage() == null ? "No se pudo crear la consulta." : e.getMessage();

		    msg = URLEncoder.encode(msg, StandardCharsets.UTF_8);

		    response.sendRedirect(request.getContextPath() + "/index.jsp?error=" + msg);
		}
	}
}
