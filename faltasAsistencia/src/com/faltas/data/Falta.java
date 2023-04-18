package com.faltas.data;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Falta {
	
	private LocalDateTime inicioFalta;
	private LocalDateTime finFalta;
	private Boolean justificada;
	
	
	public Falta(LocalDateTime inicioFalta, LocalDateTime finFalta, Boolean justificada) {
		super();
		this.inicioFalta = inicioFalta;
		this.finFalta = finFalta;
		this.justificada = justificada;
	}
	
	public float calcularHorasFaltadas() {
		return ChronoUnit.HOURS.between(inicioFalta, finFalta);
	}
	

	public LocalDateTime getInicioFalta() {
		return inicioFalta;
	}

	public void setInicioFalta(LocalDateTime inicioFalta) {
		this.inicioFalta = inicioFalta;
	}

	public LocalDateTime getFinFalta() {
		return finFalta;
	}

	public void setFinFalta(LocalDateTime finFalta) {
		this.finFalta = finFalta;
	}

	public Boolean getJustificada() {
		return justificada;
	}

	public void setJustificada(Boolean justificada) {
		this.justificada = justificada;
	}

	@Override
	public String toString() {
		return  "Inicio de falta: " +this.inicioFalta +", "+
				"Fin de falta: "+this.finFalta +", "+
				"Justificada: "+this.justificada;
	}
	
}
