package com.faltas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.faltas.common.Utiles;
import com.faltas.data.Curso;
import com.faltas.data.Falta;

public class CalculoFaltas {
	public static void main(String[] args) {
		
		Curso curso= new Curso();
		String control="S";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime test = LocalDateTime.now();
		
		Scanner sc = new Scanner(System.in);
		System.out.println(test.format(formatter));		
		System.out.println("Cálculo del cómputo de faltas realizadas durante el curso y "
				+ "comprobación de si se es apto o no para obtener certificado");
		System.out.println("------------------------------------------");
		System.out.println();
		
		//TODO: Quitar los datos moqueados de la lista de faltas y descomentar la entrada de datos por consola
		curso.alumno.añadirFalta(new Falta(LocalDateTime.parse("2022-11-10 10:00", formatter),LocalDateTime.parse("2022-11-10 11:00", formatter),true ));
		curso.alumno.añadirFalta(new Falta(LocalDateTime.parse("2022-12-01 09:00", formatter),LocalDateTime.parse("2022-12-01 12:00", formatter),false));
		curso.alumno.añadirFalta(new Falta(LocalDateTime.parse("2023-01-09 10:00", formatter),LocalDateTime.parse("2023-01-10 12:00", formatter),true ));
		curso.alumno.añadirFalta(new Falta(LocalDateTime.parse("2023-02-17 09:00", formatter),LocalDateTime.parse("2023-02-17 14:00", formatter),false));
		curso.alumno.añadirFalta(new Falta(LocalDateTime.parse("2023-02-23 09:00", formatter),LocalDateTime.parse("2023-02-23 12:00", formatter),true ));
		System.out.println("------------Datos moqueados-------------");
		System.out.println(curso.alumno.toString());
		
//		while (control.toUpperCase().equals("S")) {
//			System.out.println("Introduzca día y hora del comienzo de la falta en el siguiente formato: yyyy-MM-dd hh:mm ");
//			String inicio=sc.nextLine();
//			
//			System.out.println("Introduzca día y hora del final de la falta en el siguiente formato: yyyy-MM-dd hh:mm ");
//			String fin=sc.nextLine();
//
//			LocalDateTime inicioFalta = LocalDateTime.parse(inicio, formatter);
//			LocalDateTime finFalta = LocalDateTime.parse(fin, formatter);
//			
//			System.out.println("¿Es una falta justificada? Responda S para sí y N para No");
//			boolean justificada= sc.nextLine().toUpperCase().equals("S") ? true:false; 
//			
//			Falta falta=new Falta(inicioFalta, finFalta, justificada);
////			System.out.println(falta);
//			curso.alumno.añadirFalta(falta);
////			System.out.println(curso.alumno.toString());
//			
//			// TODO: hacer verificaciones y excepciones en la introducción de datos 
//			// TODO: rellenar la lista e imprimir para verificar con el toString de Alumno
//			
//			System.out.println("Para seguir introduciendo faltas pulse S. Para salir presione cualquier tecla.");
//			control= sc.nextLine();
//			System.out.println();
//			System.out.println();
//		}
//			System.out.println(curso.alumno.toString());

	}
	
}
