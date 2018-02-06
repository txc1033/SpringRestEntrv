package com.javifast.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	@NotNull
    private String nombre;
	@NotNull
    private String apellido;

    public Persona(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

    
}
