package com.example.demo.bussiness;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.exceptions.CodeError;
import com.example.demo.common.exceptions.ServicioException;
import com.example.demo.entities.Departamento;
import com.example.demo.repositories.DepartamentoRepository;

@Service // si lo quitamos da el error porque no encuentra el ServiceBean
public class ServicioDepartamentoImpl implements ServicioDepartamento {
	// es el crud
	
	Logger log = LoggerFactory.getLogger(ServicioDepartamentoImpl.class);
	//el logger está siempre disponible porque Spring lo lleva de serie slf4j no lleva archivo properties
	// porque ya lo lleva java dentro y para modificarlo se hace en el applicationProperties de Spring
	
	@Autowired
	DepartamentoRepository repository;
	// @ no tenemos el @Repository porque Spring nos hace el DAO automaticamente y la clase
	// repositorio la tiene por ahí. Nosotros la extendemos a DepartamentoRepository
	
	
	@Override
	public List<Departamento> listDepartamentos() throws ServicioException{
		log.info("[listDepartamentos]");
		
		List<Departamento> departamentos;
		
		try {
			departamentos= repository.findAll();
			
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return departamentos;
		
	}
	
	// no usar nunca el getById() de jpaRepository es lazy. Hasta que no se hace referencia al objeto en cuestión
	// no va a por él, y a veces puede dar error. Usamos el findById()
	@Override
	public Departamento conseguirDepartamento(Integer idDepartamento) throws ServicioException{
		log.info("[conseguirDepartamento]");
		log.debug("[idDepartamento: "+idDepartamento+"]");
		
		Departamento departamento;
		
		try {
			// Optional cuando no estamos seguros de si va a devolver algo o no. Evitamos trabajar con nulos
			// cuando ese objeto pueda ser nulo. En el servicio también deberíamos devolver optional
			Optional<Departamento> departamentoOp= repository.findById(idDepartamento);
			if(!departamentoOp.isPresent()) throw new ServicioException(CodeError.DEPARTAMENTO_NOT_FOUND);
			departamento= departamentoOp.get();
		}catch(ServicioException se) {
			log.error("ServicioException", se);
			throw se;
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return departamento;
		
	}
	
	@Override
	public Departamento grabarDepartamento(Departamento departamento) throws ServicioException{
		log.info("[grabarDepartamento]");
		log.debug("[departamento: "+departamento.toString()+"]");
		
		
		try{
			departamento =repository.save(departamento);
		
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return departamento;
		
	}
	
	
	@Override
	public void eliminarDepartamento(Integer idDepartamento) throws ServicioException{
		log.info("[eliminarDepartamento]");
		log.debug("[idDepartamento: "+idDepartamento+"]");
		
			try {
			repository.deleteById(idDepartamento);
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		
	}

}
