package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bussiness.ServicioDepartamento;
import com.example.demo.common.exceptions.ServicioException;
import com.example.demo.entities.Departamento;

@RestController
@RequestMapping("/departamentos") //la url que sirve


public class DepartamentoController {
	
	@Autowired
	ServicioDepartamento servicio;
	
	
	@GetMapping
	public List<Departamento> list() throws ServicioException{
		
		return servicio.listDepartamentos();
		
	}
		
	@GetMapping("/{id}") //url variable. Se marca el parámetro como @PathVariable
//	@GetMapping(value="/{id}",produces = MediaType.APPLICATION_XML_VALUE)
	public Departamento find(@PathVariable Integer id) throws ServicioException {
		
		return servicio.conseguirDepartamento(id);
	}
	
	@PostMapping //normalmente Post para crear y put para modificar por seguridad
	public Departamento create(@RequestBody Departamento departamento) throws ServicioException {
		
		return servicio.grabarDepartamento(departamento);
	}
	
	@PutMapping //normalmente Post para crear y put para modificar por seguridad
	public Departamento save(@RequestBody Departamento departamento) throws ServicioException {
		
		return servicio.grabarDepartamento(departamento);
	}
	
	@DeleteMapping("/{id}") //url variable. Se marca el parámetro como @PathVariable
	public String delete(@PathVariable Integer id) throws ServicioException {
		servicio.eliminarDepartamento(id);
		return "Se ha borrado";
	}
	
	
}
