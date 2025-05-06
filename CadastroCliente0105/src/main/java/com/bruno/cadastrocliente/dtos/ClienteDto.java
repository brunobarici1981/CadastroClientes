package com.bruno.cadastrocliente.dtos;

public class ClienteDto {
    public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	private String nome;
    private String cep;

    // Getters e Setters
}
