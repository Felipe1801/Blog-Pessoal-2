package com.generation.blogpessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;


@Entity
@Table (name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotNull 
	@Size(min = 2, max = 100, message = "O atributo Nome é Obrigatório"
			+ "deve ter no mínimo 2 caracteres e no máximo 100")
	private String nome;
	
	@Schema(example="email@email.com.br")
	@NotNull
	@Size(min = 2, max = 100, message = "O atributo Senha é Obrigatório!"
			+ "A Senha deve ter no mínimo 2 caracteres e no máximo 100")
	@Email(message = "O atributo Usuário deve ser um email válido!")
	private String usuario;
	
	@NotNull 
	@Size(min = 2, max = 100, message = "O atributo Senha é Obrigatório!"
			+ "A Senha deve ter no mínimo 2 caracteres e no máximo 100")
	private String senha;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Postagem> postagem;
	
	//Primeiro Método Construtor - Com os atributos
	
	public Usuario(Long id, String nome, String usuario, String senha) {
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
	}
     

	// Segundo Método Construtor - Sem os atributos
	public Usuario( ) { }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	
}