package com.generation.Loja_Game.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.generation.Loja_Game.Repository.UsuarioRepository;
import com.generation.Loja_Game.model.Usuarios;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String useName) throws UsernameNotFoundException{
		Optional<Usuarios>usuario=usuarioRepository.findByUsuario(useName);
		
		if (usuario.isPresent())
			return new UserDetailsImpl(usuario.get());
		
		else 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN);
	}

	
}
