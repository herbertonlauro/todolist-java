package com.TaskToDo.Desafio.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "listatask")
public class ListaTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private String prioridade;
	
	@Column(nullable = false)
	private String usuario;

	public ListaTask(Integer id, String titulo, String descricao, String prioridade, String usuario) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.prioridade = prioridade;
		this.usuario = usuario;
	}

	public ListaTask() {
		super();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "ListaTask [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", prioridade=" + prioridade
				+ ", usuario=" + usuario + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaTask other = (ListaTask) obj;
		return Objects.equals(id, other.id);
	}	
	
	
	
}


