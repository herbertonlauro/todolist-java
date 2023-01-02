package com.TaskToDo.Desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TaskToDo.Desafio.model.ListaTask;
import com.TaskToDo.Desafio.repository.ListaTaskRepository;

@RestController
public class ListaTaskController {

	
	@Autowired      
	private ListaTaskRepository repository;
	
	@GetMapping(path = "/api/listatask")
	public Iterable<ListaTask> ListarTodos() {
		return repository.findAll();
	}
	
	@PostMapping(path = "/api/listatask/salvar")
	public ListaTask salvar(@RequestBody ListaTask listatask) {
		return repository.save(listatask);
		
	}
	
	@GetMapping(path = "/api/listatask/{codigo}")
	public ResponseEntity<ListaTask> consultar(@PathVariable("codigo") Integer id) {
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
		
	}
	
	@PutMapping(path = "/api/listatask/{id}")
	public ResponseEntity<ListaTask> update(@PathVariable ("id") Integer id, @RequestBody ListaTask listatask){
		return repository.findById(id).map(record -> {
			record.setTitulo(listatask.getTitulo());
			record.setDescricao(listatask.getDescricao());
			record.setPrioridade(listatask.getPrioridade());
			record.setUsuario(listatask.getUsuario());
			ListaTask updated = repository.save(record);
			return ResponseEntity.ok().body(updated);
			}).orElse(ResponseEntity.notFound().build());
	}
	 
	@DeleteMapping(path = "/api/listatask/{id}")
	public ResponseEntity<Object> delete(@PathVariable Integer id) {
	   return repository.findById(id).map(record -> {
		   repository.deleteById(id);
		   return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
}
