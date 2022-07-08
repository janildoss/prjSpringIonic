package com.janildosantos.prjSpringIonic.resouces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.janildosantos.prjSpringIonic.domain.Categoria;
import com.janildosantos.prjSpringIonic.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResouce {
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?>find(@PathVariable Integer id) {
	  
		Categoria obj = service.buscar(id);
		
	  //Categoria cat1 = new Categoria(1,"Informatica");
	  //Categoria cat2 = new Categoria(2,"Escritorio");
	  
	  //List<Categoria> lista = new ArrayList<>();
	  //lista.add(cat1);
	  //lista.add(cat2);
	  
	  return ResponseEntity.ok().body(obj);
  }
	
}
