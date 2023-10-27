package com.generation.Loja_Game.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.Loja_Game.model.Usuarios;

public interface UsuarioRepository extends JpaRepository <Usuarios, Long> {
	
	public Optional< Usuarios > findByUsuario(String usuario);

}
