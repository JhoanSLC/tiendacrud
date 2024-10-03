package com.tiendacrud.tiendacrud.clientes.domain.service;

import java.util.List;

import com.tiendacrud.tiendacrud.clientes.domain.entity.ClienteDto;

public interface IClienteService {

    ClienteDto createCliente(ClienteDto clienteDto);

    ClienteDto getClienteById(String clienteId);

    List<ClienteDto> getAllClientes();

    ClienteDto updateCliente(String clienteId, ClienteDto updatedCliente);

    void deleteCliente(String clienteId);
}
