package com.app.logica;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class Consulta implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_Consulta;

	private String Modelo_Celular;
	private String Descripcion_Problema;
	private String estado = "Pendiente" ;
	private String Respuesta_Posible;
	private LocalDateTime fecha_registro;
	private String tiempo_estimado_entrega;
	private String Problema_Real;
	private double Costo = 0.0;
	private String Repuesto_Utilizados;
	private boolean mostrar_detalle = false;

	@ManyToOne
	@JoinColumn(name = "ID_Cliente")
	private Cliente cliente;

	@PrePersist // @PrePersist es para poder asignar la fecha actual automaticamente
	public void asignarFechaRegistro() { // al tener esa anotacion ejecuta el metodo
		fecha_registro = LocalDateTime.now(); // LocalDateTime.now() se encarga de obtener la fecha actual
												// automaticamente y se lo pasa al atributo
	}

	public Consulta() {
		super();
	}

	public Consulta(String modelo_Celular, String descripcion_Problema, Cliente cliente) {
		this.Modelo_Celular = modelo_Celular;
		this.Descripcion_Problema = descripcion_Problema;
		this.cliente = cliente;
	}

	public Consulta(String estado, String respuesta_Posible, LocalDateTime fecha_registro,
			String tiempo_estimado_entrega, String problema_Real, double costo, String repuesto_Utilizados,
			boolean mostrar_detalle) {
		this.estado = estado;
		Respuesta_Posible = respuesta_Posible;
		this.fecha_registro = fecha_registro;
		this.tiempo_estimado_entrega = tiempo_estimado_entrega;
		Problema_Real = problema_Real;
		Costo = costo;
		Repuesto_Utilizados = repuesto_Utilizados;
		this.mostrar_detalle = mostrar_detalle;
	}

	public int getID_Consulta() {
		return ID_Consulta;
	}

	public void setID_Consulta(int iD_Consulta) {
		ID_Consulta = iD_Consulta;
	}

	public String getModelo_Celular() {
		return Modelo_Celular;
	}

	public void setModelo_Celular(String modelo_Celular) {
		Modelo_Celular = modelo_Celular;
	}

	public String getDescripcion_Problema() {
		return Descripcion_Problema;
	}

	public void setDescripcion_Problema(String descripcion_Problema) {
		Descripcion_Problema = descripcion_Problema;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRespuesta_Posible() {
		return Respuesta_Posible;
	}

	public void setRespuesta_Posible(String respuesta_Posible) {
		Respuesta_Posible = respuesta_Posible;
	}

	public LocalDateTime getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(LocalDateTime fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public String getTiempo_estimado_entrega() {
		return tiempo_estimado_entrega;
	}

	public void setTiempo_estimado_entrega(String tiempo_estimado_entrega) {
		this.tiempo_estimado_entrega = tiempo_estimado_entrega;
	}

	public String getProblema_Real() {
		return Problema_Real;
	}

	public void setProblema_Real(String problema_Real) {
		Problema_Real = problema_Real;
	}

	public double getCosto() {
		return Costo;
	}

	public void setCosto(double costo) {
		Costo = costo;
	}

	public String getRepuesto_Utilizados() {
		return Repuesto_Utilizados;
	}

	public void setRepuesto_Utilizados(String repuesto_Utilizados) {
		Repuesto_Utilizados = repuesto_Utilizados;
	}

	public boolean isMostrar_detalle() {
		return mostrar_detalle;
	}

	public void setMostrar_detalle(boolean mostrar_detalle) {
		this.mostrar_detalle = mostrar_detalle;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return " ID_Consulta: " + ID_Consulta + ", Modelo_Celular: " + Modelo_Celular + ", Descripcion_Problema: "
				+ Descripcion_Problema + ", estado: " + estado + ", Respuesta_Posible: " + Respuesta_Posible
				+ ", fecha_registro: " + fecha_registro + ", tiempo_estimado_entrega: " + tiempo_estimado_entrega
				+ ", Problema_Real: " + Problema_Real + ", Costo: " + Costo + ", Repuesto_Utilizados: "
				+ Repuesto_Utilizados + ", mostrar_detalle: " + mostrar_detalle + ", cliente: " + cliente;
	}

}
