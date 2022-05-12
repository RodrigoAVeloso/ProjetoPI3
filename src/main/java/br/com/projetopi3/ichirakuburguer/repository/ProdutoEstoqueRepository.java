package br.com.projetopi3.ichirakuburguer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetopi3.ichirakuburguer.data.ProdutoEstoqueEntity;


public interface ProdutoEstoqueRepository extends JpaRepository<ProdutoEstoqueEntity, Integer> {

}
