package br.com.projetopi3.ichirakuburguer.repository;

import br.com.projetopi3.ichirakuburguer.data.produto.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Integer> {

}
