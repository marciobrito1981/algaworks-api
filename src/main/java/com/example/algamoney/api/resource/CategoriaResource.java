package com.example.algamoney.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoney.api.event.RecursoCriadoEvent;
import com.example.algamoney.api.model.Categoria;
import com.example.algamoney.api.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@Autowired //notação para injetar e não criar o objeto
	private CategoriaRepository categoriaRepository; // injetando a categoria repository
	
	@Autowired
	private ApplicationEventPublisher publisher; // publicador de eventos
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') " // permissao do usuario logado
			+ "and #oauth2.hasScope('read')") // persmissao do cliente.. ex. mobile ou Angular
	public List<Categoria> listar(){
		
		return categoriaRepository.findAll();
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA') and #oauth2.hasScope('write')")
	public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {// adicionado a notação @Valid para validar se a categoria nao é nula, ver na classe Categoria.
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getCodigo()));
		
		//retorna no body a categoria salva, com todos os atributos. 
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
		
	}
	
	
	@RequestMapping("/{codigo}") 
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') " // permissao do usuario logado
			+ "and #oauth2.hasScope('read')") // persmissao do cliente.. ex. mobile ou Angular
	public ResponseEntity<Categoria> buscar(@PathVariable Long codigo) {
	    Categoria categoria = categoriaRepository.findById(codigo).orElse(null);//Mudança aqui

	    if(categoria == null) {
	        return ResponseEntity.notFound().build();
	    }

	    return ResponseEntity.status(HttpStatus.OK).body(categoria);
	}

}
