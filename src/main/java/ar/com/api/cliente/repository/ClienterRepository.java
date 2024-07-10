package ar.com.api.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.api.cliente.entity.Cliente;

public interface ClienterRepository extends JpaRepository<Cliente, Integer> {

}
