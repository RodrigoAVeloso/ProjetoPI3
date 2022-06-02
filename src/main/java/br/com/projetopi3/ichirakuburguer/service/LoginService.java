package br.com.projetopi3.ichirakuburguer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.projetopi3.ichirakuburguer.data.LoginEntity;
import br.com.projetopi3.ichirakuburguer.dto.LoginDto;
import br.com.projetopi3.ichirakuburguer.repository.LoginRepository;

@Service
public class LoginService implements UserDetailsService {
	
	@Autowired
	LoginRepository repository;
	
	@Transactional
	public boolean salvarLogin(LoginDto loginDto) {
		LoginEntity login = new LoginEntity();
		BeanUtils.copyProperties(loginDto, login);
		repository.save(login);
		return true;
	}
	
	public List<LoginDto> pegarTodos(){
		List<LoginEntity> logins = repository.findAll();
		List<LoginDto> loginsDto = new ArrayList<LoginDto>();
		
		for (LoginEntity login : logins) {
			LoginDto dto = new LoginDto();
			BeanUtils.copyProperties(login, dto);
			loginsDto.add(dto);	
		}
		return loginsDto;
	
	}
	
	@Transactional
	public boolean deletarLogin(String usuario) {
		
		
		if (repository.findByUsuario(usuario) != null) {
			LoginEntity login = repository.findByUsuario(usuario);
			repository.delete(login);
    		return true;
        }
        else {
            return false;
        }
		
	}
	
	public LoginDto encontrarPorUsuario(String usuario) {

	        if (repository.findByUsuario(usuario) != null) {
	        	LoginEntity login = repository.findByUsuario(usuario);
	        	LoginDto dto = new LoginDto();
	    		BeanUtils.copyProperties(login, dto);
	    		return dto;
	        }
	        else {
	            return null;
	        }
	}
	

	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		
		return repository.findByUsuario(usuario);
		
	}
}
