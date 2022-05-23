package br.com.projetopi3.ichirakuburguer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetopi3.ichirakuburguer.data.LoginEntity;

public interface LoginRepository extends JpaRepository<LoginEntity, Integer>{
	
	public LoginEntity findByUsuario(String usuario);
}
