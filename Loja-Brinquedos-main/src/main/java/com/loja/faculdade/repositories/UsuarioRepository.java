package com.loja.faculdade.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loja.faculdade.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
}
