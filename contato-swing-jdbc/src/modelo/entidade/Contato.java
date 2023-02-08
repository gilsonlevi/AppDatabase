package modelo.entidade;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Contato {
	
	private int id;
	private String nome;
	private String email;
	private int celular;
	private LocalDate nascimento;
	private LocalDateTime cadastro;
	private int novo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCelular() {
		return celular;
	}
	public void setCelular(int celular) {
		this.celular = celular;
	}
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	public LocalDateTime getCadastro() {
		return cadastro;
	}
	public void setCadastro(LocalDateTime cadastro) {
		this.cadastro = cadastro;
	}
	
	
}
