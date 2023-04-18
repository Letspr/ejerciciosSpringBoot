package com.faltas.data;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Faltas {
	
	private LocalDateTime inicioFalta;
	private LocalDateTime finFalta;
	private Boolean justificada;
	
	public Faltas(LocalDateTime inicioFalta, LocalDateTime finFalta, Boolean justificada) {
		super();
		this.inicioFalta = inicioFalta;
		this.finFalta = finFalta;
		this.justificada = justificada;
	}
	
	public float calcularHorasFaltadas() {
		return ChronoUnit.HOURS.between(inicioFalta, finFalta);
	}
	
	

}
