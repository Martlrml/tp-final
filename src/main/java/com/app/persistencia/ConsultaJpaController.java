package com.app.persistencia;

import com.app.logica.Consulta;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConsultaJpaController {

	// "Fábrica" de conexiones (EntityManagerFactory).
	// Sirve para crear EntityManager, que son los que realmente hablan con la BD.
	private EntityManagerFactory emf = null;

	// En el constructor decimos con qué unidad de persistencia vamos a trabajar.
	// Esa unidad está definida en persistence.xml con el nombre "ejemplojpa".
	public ConsultaJpaController() {
		emf = Persistence.createEntityManagerFactory("Servicio_Tecnico");
	}

	// Método que crea y devuelve un nuevo "EntityManager".
	// Pensalo como: "dame un empleado que se conecte a la base para trabajar".
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	// Método para guardar una consulta en la base de datos.
	public void crear(Consulta consulta) {
		EntityManager em = null;
		try {
			// Abrimos la conexión (pedimos un empleado).
			em = getEntityManager();

			// Iniciamos una transacción: empieza la "promesa".
			em.getTransaction().begin();

			// Guardamos el objeto en la base (pero todavía no está confirmado).
			em.persist(consulta);

			// Confirmamos la transacción: ahora sí el objeto queda guardado.
			em.getTransaction().commit();
		} finally {
			// Cerramos la conexión (el empleado ya no hace falta).
			if (em != null) {
				em.close();
			}
		}
	}

	/*
	// BUSCAR UNO: busca un artista por su id.
	// No hace falta transacción porque no modifica nada en la base.
	public Artista buscarUno(int id) {
		EntityManager em = getEntityManager();
		try {
			// find busca por clave primaria. Si no existe, devuelve null.
			return em.find(Artista.class, id);
		} finally {
			em.close();
		}
	}

	// BUSCAR TODOS: devuelve una lista con todos los artistas.
	public List<Artista> buscarTodos() {
		EntityManager em = getEntityManager();
		try {
			// Consulta JPQL: "traeme todos los objetos Artista"
			return em.createQuery("SELECT a FROM Artista a", Artista.class).getResultList();
		} finally {
			em.close();
		}
	}
	
	// EDITAR: modifica un artista que ya existe en la base de datos.
	public void editar(Artista art) {
		EntityManager em = null;
		try {
			em = getEntityManager();

			// Iniciamos la transacción.
			em.getTransaction().begin();

			// merge actualiza el artista en la base de datos.
			em.merge(art);

			// Confirmamos los cambios.
			em.getTransaction().commit();
		} finally {
			// Cerramos la conexión.
			if (em != null) {
				em.close();
			}
		}
	}

	// ELIMINAR: borra un artista por su id.
	public void eliminar(int id) {
		EntityManager em = null;
		try {
			em = getEntityManager();

			// Buscamos el artista que queremos eliminar.
			Artista art = em.find(Artista.class, id);

			// Si existe, lo eliminamos.
			if (art != null) {
				em.getTransaction().begin();
				em.remove(art);
				em.getTransaction().commit();
			}
		} finally {
			// Cerramos la conexión.
			if (em != null) {
				em.close();
			}
		}
	}
	*/
}
