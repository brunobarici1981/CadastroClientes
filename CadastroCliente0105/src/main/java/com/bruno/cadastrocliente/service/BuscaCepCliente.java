package com.bruno.cadastrocliente.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bruno.cadastrocliente.Entity.Cep;

@Service
public class BuscaCepCliente {
	
	public Cep buscarCep(String cep) {
		String urlCep = "http://viacep.com.br/ws/" + cep + "/json/";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Cep> resp = restTemplate.getForEntity(urlCep, Cep.class);
		return resp.getBody();
	}
}