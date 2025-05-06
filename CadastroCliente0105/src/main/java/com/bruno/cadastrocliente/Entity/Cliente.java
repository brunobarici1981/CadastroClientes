package com.bruno.cadastrocliente.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    private String nome;
    private String telefone;
    private String cpf;
    @OneToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "cep_id", referencedColumnName = "id")
    private CepDTO cep;
    private String cepCliente;
	public String getCepCliente() {
		return cepCliente;
	}
	public void setCepCliente(String cepCliente) {
		this.cepCliente = cepCliente;
	}
	public CepDTO getCep() {
		return cep;
	}
	public void setCep(CepDTO cep) {
		this.cep = cep;
	}
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(long id, String nome, String telefone, String cpf, CepDTO cep) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.cep = cep;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
