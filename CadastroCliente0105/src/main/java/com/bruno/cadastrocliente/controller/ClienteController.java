package com.bruno.cadastrocliente.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.cadastrocliente.Entity.Cep;
import com.bruno.cadastrocliente.Entity.Cliente;
import com.bruno.cadastrocliente.service.BuscaCepCliente;
import com.bruno.cadastrocliente.service.ClienteService;

@RestController
@RequestMapping
public class ClienteController {
	@Autowired
	ClienteService service;
	@Autowired
	BuscaCepCliente buscaCep;
	@GetMapping
	public List<Cliente> getClients() {
		return service.buscarClientes();
	}
	
	@GetMapping("consultarCep/{cep}")
	public Cep buscarApiCep(@PathVariable String cep) {
	    System.out.println("Buscando CEP: " + cep);
	    return buscaCep.buscarCep(cep);
	}

	@GetMapping("/{id}")
	public Optional<Cliente> getClientsById(@PathVariable  int id){
		
		return service.buscarClientePorId(id);
	}
	@DeleteMapping("{id}")
	public void deletClientById(@PathVariable int id) {
		
		service.deletarClientePorId(id);
	}
	@PostMapping()
	public Cliente createClient(@RequestBody @Validated Cliente cliente) {
		return service.cadastrarCliente(cliente);
		
	}
	@PutMapping("/{id}")
	public Cliente updateClient(@PathVariable Long id, @RequestBody Cliente cliente) {
	    return service.atualizarCliente(id, cliente);
	}
}
