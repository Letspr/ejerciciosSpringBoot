package com.example.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mvc.entities.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
	//JpaRepository extiende de ListRepository, en la versión anterior de SpringFramework heredaba de Repository
	// SpringBoot 3.0 funciona con Spring Framework 6
	// Ponemos JpaRepository en vez de Crud porque también queremos persistencia en las entidades.
	// JpaRepository extiende de PagingandSorting que pagina los resultados y los ordena y extiende del CrudRepository

}
