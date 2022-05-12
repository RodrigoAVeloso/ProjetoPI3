package br.com.projetopi3.ichirakuburguer.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetopi3.ichirakuburguer.data.LoginEntity;
import br.com.projetopi3.ichirakuburguer.dto.LoginDto;
import br.com.projetopi3.ichirakuburguer.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	LoginRepository repository;
	
	public boolean salvarLogin(LoginDto loginDto) {
		LoginEntity login = new LoginEntity();
		BeanUtils.copyProperties(loginDto, login);
		repository.save(login);
		return true;
	}
}
