package com.example.algamoney.api.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.repository.LancamentoRepository;
import com.example.algamoney.api.repository.PessoaRepository;
import com.example.algamoney.api.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	//Salvando um lancamento, mas verificando se a pessoa nao esta inativa.
	public Lancamento salvar(@Valid Lancamento lancamento) {
		Optional<Pessoa> pessoaOptional = pessoaRepository.findById(lancamento.getPessoa().getId());
		
		if(!pessoaOptional.isPresent() || pessoaOptional.get().isInativo()) {
			throw new PessoaInexistenteOuInativaException();			
		}
		
		return lancamentoRepository.save(lancamento);
	}

	
}
