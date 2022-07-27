package com.janildosantos.prjSpringIonic;

//import java.sql.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.janildosantos.prjSpringIonic.domain.Categoria;
import com.janildosantos.prjSpringIonic.domain.Cidade;
import com.janildosantos.prjSpringIonic.domain.Estado;
import com.janildosantos.prjSpringIonic.domain.Produto;
import com.janildosantos.prjSpringIonic.repositries.CategoriaRepository;
import com.janildosantos.prjSpringIonic.repositries.CidadeRepository;
import com.janildosantos.prjSpringIonic.repositries.EstadoRepository;
import com.janildosantos.prjSpringIonic.repositries.ProdutoRepository;

@SpringBootApplication
public class PrjSpringIonicApplication implements CommandLineRunner {
   //Instancia o repository para gravar no banco
	@Autowired
	private CategoriaRepository categoriaRepository;    
    @Autowired
    private ProdutoRepository produtoRepository;    
    @Autowired
    private EstadoRepository estadoRepository;    
    @Autowired
    private CidadeRepository cidadeRepository;
    
	public static void main(String[] args) {
		SpringApplication.run(PrjSpringIonicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritorio");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));		
		
		// Salvar no banco
		categoriaRepository.saveAll(Arrays.asList( cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		//nova instacia Cidade e Estado
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null,"Uberlandia",est1);
		Cidade c2 = new Cidade(null,"São Paulo",est2);
		Cidade c3 = new Cidade(null,"Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
	}	

}
