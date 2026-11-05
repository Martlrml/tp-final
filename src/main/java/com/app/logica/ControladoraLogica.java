package com.app.logica;

import com.app.persistencia.ControladoraPersistencia;
import java.util.List;

public class ControladoraLogica {

	// La controladora de persistencia se encarga de hablar con la BD.
	// Desde aquí la usamos como "puente" para guardar datos.
	ControladoraPersistencia controlPersis = new ControladoraPersistencia();

	// ----- Cliente -----
	// Método de la capa lógica para crear un artista.
	// Antes de guardarlo en la BD, se hacen validaciones.
	public void crearConsultas(Cliente cliente, Consultas consulta) throws Exception {
		// Validación: la consulta debe tener un nombre
		if (cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()) {  // trim() es para que no puedan llenar el campo con espacios 
			throw new Exception("La consulta debe tener un nombre.");
		}
		// Validación: La consulta debe de tener un numero de telefono
		if (cliente.getTelefono() == null || cliente.getTelefono().isEmpty()) {
			throw new Exception("La consulta debe de tner un numero.");
		}
		
		if (consulta.getModelo_Celular() == null || consulta.getModelo_Celular().isEmpty()) {
			throw new Exception("La consulta debe tener un modelo de celular.");
		}
		
		if (consulta.getDescripcion_Problema() == null || consulta.getDescripcion_Problema().isEmpty()) {
			throw new Exception("La  consulta debe de tener una descripcion.");
		}
		
		if (consulta.getCliente() == null) {
			throw new Exception("La consulta debe de tener un cliente asociado.");
		}
		
		controlPersis.crearConsultas(cliente, consulta);	
	}

	public Cliente BuscarClientePorTelefono(String telefono) {
		return controlPersis.BuscarClientePorTelefono(telefono);
	}
	
	public List<Consultas> ListarConsultasPorCliente(int idCliente) {
	    return controlPersis.BuscarConsultasPorCliente(idCliente);
	}
	
	/*
	// LISTAR TODOS LOS ARTISTAS
	public List<Artista> listarArtistas() {
		return controlPersis.buscarTodosLosArtistas();
	}

	public Cancion BuscarUnaCancion(int id) {
		return controlPersis.BuscarCancion(id);
	}
	
	public List<Cancion> ListarCanciones() {
		return controlPersis.BuscarTodasLasCanciones();
	}
	

	// ----- EDITAR Y ELIMINAR ARTISTA -----

	public void editarArtista(Artista art) throws Exception {

		// Comprobamos que el artista exista.
		Artista artistaExistente = controlPersis.buscarArtista(art.getId());

		if (artistaExistente == null) {
			throw new Exception("El artista no existe.");
		}

		// Aplicamos las mismas validaciones que al crear.
		if (art.getNombre() == null || art.getNombre().isEmpty()) {
			throw new Exception("El artista debe tener un nombre.");
		}

		if (art.getGeneroMusical() == null || art.getGeneroMusical().isEmpty()) {
			throw new Exception("El artista debe tener un género musical.");
		}

		if (art.getEdad() <= 0) {
			throw new Exception("La edad del artista debe ser mayor a 0.");
		}

		if (art.getFechaNacimiento() == null) {
			throw new Exception("El artista debe tener una fecha de nacimiento.");
		}

		// Si todo está bien, guardamos los cambios.
		controlPersis.editarArtista(art);
	}

	public void eliminarArtista(int id) throws Exception {

		// Comprobamos que el artista exista.
		Artista art = controlPersis.buscarArtista(id);

		if (art == null) {
			throw new Exception("El artista no existe.");
		}

		controlPersis.eliminarArtista(id);
	}

	// ----- EDITAR Y ELIMINAR CANCIÓN -----

	public void editarCancion(Cancion can) throws Exception {

		// Comprobamos que la canción exista.
		Cancion cancionExistente = controlPersis.BuscarCancion(can.getId());

		if (cancionExistente == null) {
			throw new Exception("La canción no existe.");
		}

		// Aplicamos las mismas validaciones que al crear.
		if (can.getTitulo() == null || can.getTitulo().isEmpty()) {
			throw new Exception("La canción debe tener un título.");
		}

		if (can.getDuracion() <= 0) {
			throw new Exception("La duración debe ser mayor a 0 segundos.");
		}

		if (can.getAnio() < 1900) {
			throw new Exception("El año de la canción debe ser válido.");
		}

		if (can.getAnio() > 2026) {
			throw new Exception("El año de la canción debe ser coherente.");
		}

		// Si todo está bien, guardamos los cambios.
		controlPersis.editarCancion(can);
	}

	public void eliminarCancion(int id) throws Exception {

		// Comprobamos que la canción exista.
		Cancion can = controlPersis.BuscarCancion(id);

		if (can == null) {
			throw new Exception("La canción no existe.");
		}

		controlPersis.eliminarCancion(id);
	*/}

