package com.astarteam.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Informacion basica de cada una de las personas asociadas a la entidad
 * bancaria
 * 
 * @author Alvaro sebastian tabares gaviria
 * @version 1.0
 */
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@NamedQueries({ @NamedQuery(name = Persona.LISTAR_TODOS, query = "select p from Persona p") })
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * referencia para listar los clientes
	 */
	public static final String LISTAR_TODOS = "ListarLosClientes";

	/**
	 * identificacion de la persona
	 * 
	 * 
	 * 
	 * hhyhy
	 */
	@Id
	@Column(length = 20)
	private String cedula;

	/**
	 * nombre de la persona
	 */
	@Column(length = 40, updatable = true)
	private String nombre;
	/**
	 * correo de la persona
	 */
	@Column(length = 40, updatable = true)
	private String correo;

	/**
	 * Apodo de la persona
	 */
	@Column(length = 30, unique = true, updatable = true)
	private String apodo;

	/**
	 * Numero de telefono de la persona
	 */
	@Column(length = 11, updatable = true)
	private String numeroTelefono;

	public Persona() {
		super();
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (cedula == null) {
			if (other.cedula != null)
				return false;
		} else if (!cedula.equals(other.cedula))
			return false;
		return true;
	}

}
