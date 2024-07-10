package ar.com.api.cliente.service;

import java.util.List;

import ar.com.api.cliente.entity.Cliente;

public interface ClienteService {
	
	public Cliente save (Cliente cliente);
	
	public List<Cliente> findAll();

}
