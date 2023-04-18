
package com.example.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mvc.bussiness.ServicioDepartamento;
import com.example.mvc.common.exceptions.ServicioException;
import com.example.mvc.entities.Departamento;

@Controller
@RequestMapping("/departamentos") //url que va a servir todos los métodos del controlador
public class ControladorDepartamentos {
	
	@Autowired
	ServicioDepartamento servicio;
//  si no pongo el @autowired tengo que hacer lo de abajo porque Srping no tiene el servicio
//  en su contexto. Tengo que instanciarlo
//	public ControladorDepartamentos() {
//		this.servicio = new ServicioDepartamentoImp();
//	}
	
	
	// IMPORTANTE: un método, un tipo de petición por url
	// Cada método lleva consigo la maleta que la vista necesitará. En el primer caso, en el model.Atribute le mandamos lista de departamentos
	
	//Si en vez de @GetMapping le metemos un @RequestMapping lo utiliza de comodín si no hay otro método que lo sirva
	// @ResponseBody indicaría que la respuesta iría sin la vista de html, va directamente la respuesta
	@GetMapping  // la url /departamentos ejecuta el método paginaDepartamentos (no se llama en ningún sitio, lo llama la url)
	public String paginaDepartamentos(Model model) throws Exception {
		//El String indica que vamos a mandar una vista
		List<Departamento> departamentos = servicio.listDepartamentos();
		
		//Spring ayuda y javaServlet construye la página con el thymeleft que le corresponda
		model.addAttribute("departamentos", departamentos);	
		// el departamentos del addAttribute no es la vista, es el modelo que se pasa a la vista que luego 
		// se puede referenciar en ella ("${departamento.id}")
		return "departamentos";
	}
	
	@GetMapping("/{id}")
	// path variable porque no puede coincidir la url
	public String paginaDepartamento(@PathVariable Integer id,Model model) throws Exception {
		// Model model es un objeto que nos da Spring para meter atributos en la vista. Va a ser independiente para cada método.
		// Nuevo para cada método. Son maleteros diferentes.
		Departamento departamento = servicio.conseguirDepartamento(id);
		
		model.addAttribute("departamento", departamento);	
		return "departamento";
	}
	
	//Si tengo otro método post,le pongo un determinante  @PostMapping("/crear")  y tengo que indicarlo también en el th:action de la vista que lo utilice.
	@PostMapping
	public String grabarDepartamento(@ModelAttribute Departamento departamento,Model model) throws Exception {
		//@ModelAttribute Departamento departamento,Model model) le está diciendo que con esos atributos del 
		//modelo me haga un departamento. Necesita tener el mismo nombre de tods los campos en la entity y necesita los getter y setters
		//@ModelAttribute es lo que viene en los atributos del request. Si falta alguno lo deja nulo
		//Nos crea el departamento porque le hemos pasado el @ModelAttribute
		
		//Se pueden pasar más parámetros que estén fuera del modelo o el objeto, como (@RequestPAram Int edad, @ModelAttribute Departamento departamento,Model model)
		//
		
		// Otra forma de hacerlo es con String grabarDepartamento (@RequestPAram Integer id (mismo nombre que en la vista),
		// 															@RequestPAram String nombre ... etc)
		// Departamento departamento = new departamento();
		// dpartamento.setId(id);
		// dpartamento.setNombre(nombre); ...
		// La única ventaja que tiene es que en la vista se puede poner otro nombre a un atriuto y en el parámetro poner:
		// @RequestPAram (name="miNombre") String nombre;
		// también deja poner un default value: @RequestPAram (defaultValue="1") Integer id;
		departamento=servicio.grabarDepartamento(departamento);
		
		model.addAttribute("departamento", departamento);	
		return "departamento";
	}
	
	
	@GetMapping("/d/{id}")
	public String eliminarDepartamento(@PathVariable Integer id,Model model) throws Exception {
		
		servicio.eliminarDepartamento(id);
		
		
		return "redirect:/departamentos";	
	}
		
	@ExceptionHandler({ ServicioException.class, Exception.class })
    public String  handleException(Model model) {
		
		model.addAttribute("mensaje","Se ha producido un error");		

		return "error";
    }
}
