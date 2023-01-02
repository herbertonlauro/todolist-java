package com.TaskToDo.Desafio.repository;

import org.springframework.data.repository.CrudRepository;

import com.TaskToDo.Desafio.model.UsuarioModel;


public interface UsuarioRepository extends CrudRepository<UsuarioModel, Integer>{
	
}
