package br.com.projetopi3.ichirakuburguer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetopi3.ichirakuburguer.data.usuario.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer>{

}
