package com.bruno.cadastrocliente.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bruno.cadastrocliente.Entity.CepDTO;

@Service
public class BuscaCepCliente {


	public CepDTO buscarCepCliente(String cepStr) {
		String urlCep = "http://viacep.com.br/ws/" + cepStr + "/json/";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CepDTO> resp = restTemplate.getForEntity(urlCep, CepDTO.class);	
		return resp.getBody();
	}

	
}