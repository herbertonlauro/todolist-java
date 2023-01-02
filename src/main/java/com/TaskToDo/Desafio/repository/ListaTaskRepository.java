package com.TaskToDo.Desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TaskToDo.Desafio.model.ListaTask;

public interface ListaTaskRepository extends JpaRepository<ListaTask, Integer>{

	

}
