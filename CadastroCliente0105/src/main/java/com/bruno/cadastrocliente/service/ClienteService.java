package com.bruno.cadastrocliente.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.cadastrocliente.Entity.CepDTO;
import com.bruno.cadastrocliente.Entity.Cliente;
import com.bruno.cadastrocliente.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repository;
    @Autowired
    BuscaCepCliente buscaCepCliente;
	public List<Cliente> buscarClientes() {

		return repository.findAll();
	}

	 public Cliente cadastrarCliente(Cliente clienteDto) {
	        CepDTO cepDTO = buscaCepCliente.buscarCepCliente(clienteDto.getCepCliente());
	        CepDTO cep = new CepDTO();

	       
	        BeanUtils.copyProperties(cepDTO, cep); 

	        Cliente cliente = new Cliente();
	        cliente.setNome(clienteDto.getNome());
	        cliente.setCpf(clienteDto.getCpf());
	        cliente.setTelefone(clienteDto.getTelefone());
	        cliente.setCepCliente(cep.getCep());
	        cliente.setCep(cep);
	        
	     
	        return repository.save(cliente);
	    }

	public Optional<Cliente> buscarClientePorId(long id) {

		return repository.findById(id);
	}

	public void deletarClientePorId(long id) {

		repository.deleteById(id);
	}

	
	public Cliente atualizarCliente(Long id, Cliente novosDados) {
	    Cliente existente = repository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

	    existente.setNome(novosDados.getNome());
	    existente.setCpf(novosDados.getCpf());
	    existente.setTelefone(novosDados.getTelefone());
	    novosDados.getId();
	 

	    return repository.save(existente);
	}
}
