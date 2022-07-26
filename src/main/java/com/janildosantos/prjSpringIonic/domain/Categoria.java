package com.janildosantos.prjSpringIonic.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String Nome;
	
	//mapeamento relaconal deste lado apenas mapeia
	@JsonManagedReference //resolver referencia ciclica
	@ManyToMany(mappedBy="categorias")	
	//categoria tem uma lista de produtos
	private List<Produto> produtos = new ArrayList<>();
	
	//construtor vazio
	public Categoria() {
		
	}
	//construtor com argumentos
	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		Nome = nome;
	}
    //geters e seters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	//geters e seters de produto collection	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}

	
	
	

}
