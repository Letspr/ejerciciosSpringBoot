package com.faltas.data;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.faltas.common.Utiles;

public class Modulo {

	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String codigo;
	private String nombre;
	private int horasModulo;
	


	public Modulo(LocalDate fechaInicio, LocalDate fechaFin, String codigo, String nombre, int horasModulo) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.codigo = codigo;
		this.nombre = nombre;
		this.horasModulo = horasModulo;
	}

	

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}



	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}



	public LocalDate getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return nombre;
	}
	
	public void setTitulo(String titulo) {
		this.nombre = titulo;
	}

	public int getHorasModulo() {
		return horasModulo;
	}

	public void setHorasModulo(int horasModulo) {
		this.horasModulo = horasModulo;
	}

	@Override
	public String toString() {
		return  "Nombre del módulo: " +this.nombre +", "+
				"Código de módulo: "+this.codigo +", "+
				"Fecha inicio: "+this.fechaInicio +", "+
				"Fecha fin: "+this.fechaFin +", "+
				"Horas del módulo"+this.horasModulo;
	}
	
		

}
