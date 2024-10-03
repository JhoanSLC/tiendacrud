package com.tiendacrud.tiendacrud.clientes.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiendacrud.tiendacrud.clientes.domain.entity.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, String> {

}
