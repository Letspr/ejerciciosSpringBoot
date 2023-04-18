package com.faltas.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Alumno {
	
	private List<Falta> listaFaltas = new ArrayList<>();
	
	public void añadirFalta(Falta falta){
		listaFaltas.add(falta);
	}
	
	/** Obtiene las horas totales que se han faltado por cada período de tiempo */
	public float obtenerHorasFaltaModulo(LocalDate inicio, LocalDate fin) {
		return  obtenerHorasPorTipo(inicio, fin, true) + obtenerHorasPorTipo(inicio, fin, false);
	}
	
	/** Obtiene las horas que se han faltado contemplando rango de fechas y tipo de falta (justificada o no) */
	public float obtenerHorasPorTipo(LocalDate inicio, LocalDate fin, Boolean justificada) {
		float horas=0;
		
		for (Falta falta : listaFaltas) {
			LocalDate fechaInicio = falta.getInicioFalta();
			if( fechaInicio.compareTo(inicio)>0 || fechaInicio.compareTo(fin)<0) 
			
		}
		return horas;
	}

	public List<Falta> getListaFaltas() {
		return listaFaltas;
	}

	public void setListaFaltas(List<Falta> listaFaltas) {
		this.listaFaltas = listaFaltas;
	}

	@Override
	public String toString() {
		String str = "";
		for(Falta falta :  listaFaltas) {
			str += falta.toString() + "\r\n";
		}
		return str;
	}
		
}
