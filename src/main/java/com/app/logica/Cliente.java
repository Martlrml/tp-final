package com.app.logica;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Cliente;

    private String nombre;
    private String telefono;

	public Cliente() {
	}

	public Cliente(String nombre, String telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public int getID_Cliente() {
		return ID_Cliente;
	}

	public void setID_Cliente(int iD_Cliente) {
		ID_Cliente = iD_Cliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
	return "ARTISTA: \n" + "ID: " + getID_Cliente() + "\nNombre: " + getNombre()
	+ "\n Telefono: " + getTelefono();
	}
}
