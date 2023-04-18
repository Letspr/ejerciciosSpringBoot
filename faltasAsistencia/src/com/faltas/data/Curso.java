package com.faltas.data;

import com.faltas.common.Utiles;

public class Curso {

	public Alumno alumno = new Alumno();
	
	
	/** obtenerCertificado comprueba si el número de faltas por módulo supera el permitido para cada uno de ellos. 
	 Si se supera devuelve false porque no se puede obtener el certificado*/
	public Boolean obtenerCertificado() {
		Boolean certificado = Boolean.TRUE;
		//Recorre la listaModulos para obtener las horas que se puede faltar en cada módulo y las compara con las 
		//horas faltadas por cada módulo
		for(int i=1; i<Utiles.listaModulos.size(); i++) {
			double horasFaltaModudo = alumno.obtenerHorasFaltaModulo(Utiles.listaModulos.get(i).getFechaInicio(), 
																	Utiles.listaModulos.get(i).getFechaFin());
			if ((Utiles.listaModulos.get(i).getHorasModulo()*0.25)<horasFaltaModudo) {
				certificado = Boolean.FALSE;
			}
		} 
		return certificado;
	}
	
	
}
