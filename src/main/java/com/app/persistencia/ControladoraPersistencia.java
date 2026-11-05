package com.app.persistencia;

import java.util.List;

import com.app.logica.Cliente;
import com.app.logica.Consultas;

import jakarta.persistence.EntityManager; // administra las operaciones con las entidades
import jakarta.persistence.EntityTransaction; // permite confirma como cancelar cambios 

public class ControladoraPersistencia {
	// Artista: Creamos una instancia del controlador que sabe cómo hablar con la
	// base de datos
	ClienteJpaController clienteJpa = new ClienteJpaController(); // con esto nos permite poder utilizar los metodos JPA de cliente y buscar lo que necesitamos

	// Cancion: Creamos una instancia del controlador que sabe cómo hablar con la
	// base de datos
	// INSTANCIAR OBJETO DE CANCIONJPACONTROLER AL IGUAL QUE SE HIZO CON ARTISTA
	ConsultaJpaController consultaJpa = new ConsultaJpaController();

	// Este método es el que se usa desde otras capas para crear un ARTISTA
	public void crearConsultas(Cliente cliente, Consultas consulta) {

		EntityManager em = clienteJpa.getEntityManager(); // utilizamos lo que tenemos en el clientejpa

		EntityTransaction transaccion = em.getTransaction(); // iniciamos una transaccion, para poder controlar la
																// operacon y cancelarla en cualquer caso

		try {

			transaccion.begin(); // comenzamos la transaccion

			em.persist(cliente); // gurdamos el cliente y obtenemos el id por parte de BD

			consulta.setCliente(cliente); // establece la relacion de conculta con el cliente

			em.persist(consulta); // guarda la consulta con el id del cliente asociado

			transaccion.commit(); // confirma los cambios

		} catch (Exception e) {

			if (transaccion.isActive()) {
				transaccion.rollback(); // se cierra si hay un error zzzz
			}

			throw e;

		} finally {

			em.close();

		}

	}

	public Cliente BuscarClientePorTelefono(String telefono) {
		return clienteJpa.BuscarTelefono(telefono);
	}
	
	public List<Consultas> BuscarConsultasPorCliente(int idCliente) {
		return consultaJpa.BuscarIdCliente(idCliente);
	}

	/*
	 * // BUSCAR UN ARTISTA public Artista buscarArtista(int id) { return
	 * artistaJpa.buscarUno(id); } // BUSCAR TODOS LOS ARTISTAS public List<Artista>
	 * buscarTodosLosArtistas() { return artistaJpa.buscarTodos(); }
	 * 
	 * 
	 * public Cancion BuscarCancion(int id) { return cancionJpa.BuscarUno(id); }
	 * 
	 * public List<Cancion> BuscarTodasLasCanciones() { return
	 * cancionJpa.BuscarTodos(); }
	 * 
	 * // EDITAR UN ARTISTA public void editarArtista(Artista artista) {
	 * artistaJpa.editar(artista); }
	 * 
	 * // ELIMINAR UN ARTISTA public void eliminarArtista(int id) {
	 * artistaJpa.eliminar(id); }
	 * 
	 * // EDITAR UNA CANCIÓN public void editarCancion(Cancion cancion) {
	 * cancionJpa.editar(cancion); }
	 * 
	 * // ELIMINAR UNA CANCIÓN public void eliminarCancion(int id) {
	 * cancionJpa.eliminar(id); }
	 */

}
