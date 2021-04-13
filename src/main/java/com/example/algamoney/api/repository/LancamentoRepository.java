package com.example.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.repository.lancamento.LancamentoRepositoryQuery;

/* a interface LancamentoRepositoryQuery é extendida também, 
 * para que os metodos implementados nela esteja disponivel em lancamentoRepository (objeto)
 */

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {

}