package ar.com.api.cliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.api.cliente.entity.Cliente;
import ar.com.api.cliente.repository.ClienterRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienterRepository clienteRepo;
	
	@Override
	public Cliente save(Cliente cliente) {
		return clienteRepo.save(cliente);
	}

	@Override
	public List<Cliente> findAll() {
		return clienteRepo.findAll();
	}

}
