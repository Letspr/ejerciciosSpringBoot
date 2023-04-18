package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "DEPARTMENTS") // se importa de jakarta.persistence
public class Departamento {

	@Id
	@Column(name="DEPARTMENT_ID")
	private Integer Id;
	@Column(name="DEPARTMENT_NAME")
	private String nombre;
	@Column(name="LOCATION_ID")
	private Integer direccionId;
	@Column(name="MANAGER_ID")
	private Integer managerId;
	
	public Departamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDireccionId() {
		return direccionId;
	}

	public void setDireccionId(Integer direccionId) {
		this.direccionId = direccionId;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "Departamento [Id=" + Id + ", nombre=" + nombre + ", direccionId=" + direccionId + ", managerId="
				+ managerId + "]";
	}
	
	
	
	
	
	
	
}
