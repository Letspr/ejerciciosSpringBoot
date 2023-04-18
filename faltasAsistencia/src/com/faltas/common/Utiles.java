package com.faltas.common;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.faltas.data.Modulo;

public class Utiles {
	
	/** Lista que contiene LocalDate de todos los festivos durante el curso */
	public static List<LocalDate> listaFestivos = new ArrayList<LocalDate>
		(Arrays.asList(
			LocalDate.of(2022, 10, 31),
			LocalDate.of(2022, 11, 1),
			LocalDate.of(2022, 12, 5),
			LocalDate.of(2022, 12, 6),
			LocalDate.of(2022, 12, 7),
			LocalDate.of(2022, 12, 8),
			LocalDate.of(2022, 12, 26),
			LocalDate.of(2022, 12, 27),
			LocalDate.of(2022, 12, 28),
			LocalDate.of(2022, 12, 29),
			LocalDate.of(2022, 12, 30),
			LocalDate.of(2023, 1, 2),
			LocalDate.of(2023, 1, 3),
			LocalDate.of(2023, 1, 4),
			LocalDate.of(2023, 1, 5),
			LocalDate.of(2023, 1, 6),
			LocalDate.of(2023, 3, 20),
			LocalDate.of(2023, 4, 3),
			LocalDate.of(2023, 4, 4),
			LocalDate.of(2023, 4, 5),
			LocalDate.of(2023, 4, 6),
			LocalDate.of(2023, 4, 7),
			LocalDate.of(2023, 5, 1),
			LocalDate.of(2023, 5, 2)));
	
	public static final int horasDia = 5;
	
	//** litaModulos que contiene los Módulos */
	public static List<Modulo> listaModulos = new ArrayList<Modulo>(
		Arrays.asList(
			new Modulo(
				LocalDate.of(2022, 10, 25), 
				LocalDate.of(2022, 11, 11), 
				"MF0223_3", 
				"SISTEMAS OPERATIVOS Y APLICACIONES INFORMÁTICAS", 
				170),
			new Modulo(
				LocalDate.of(2022, 12, 20), 
				LocalDate.of(2023, 3, 2), 
				"MF0226_3", 
				"PROGRAMACIÓN DE BASES DE DATOS RELACIONALES", 
				210),
			new Modulo(
				LocalDate.of(2022, 3, 3), 
				LocalDate.of(2023, 5, 24), 
				"MF0227_3", 
				"PROGRAMACIÓN ORIENTADA A OBJETOS", 
				250)));
	
	
	
		
	// Landa para imprimir listaFestivos
//	public static void main(String[] args) {
//		listaFestivos = llenarLista();
//		listaFestivos.forEach(System.out::println);
//	}
	

}
