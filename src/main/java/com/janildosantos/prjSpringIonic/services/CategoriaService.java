package com.janildosantos.prjSpringIonic.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.janildosantos.prjSpringIonic.domain.Categoria;
import com.janildosantos.prjSpringIonic.repositries.CategoriaRepository;
import com.janildosantos.prjSpringIonic.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;
	//a partir do java 8 sts version 2.x
	public Categoria buscar(Integer id) {     
		Optional<Categoria> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName())); } 
	
	
    /*public Categoria buscar(Integer id) {
    	Optional<Categoria> obj = repo.findById(id);
    	if(obj == null) {
    		throw new ObjectNotFoundException("Objeto não encontrado Id:" + id+ ", tipo:" + Categoria.class.getName());
    		
    	}
    	
    	return obj.orElse(null);
    	
    }*/
	
}
