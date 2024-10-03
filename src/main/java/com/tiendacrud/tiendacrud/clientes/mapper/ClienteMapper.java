package com.tiendacrud.tiendacrud.clientes.mapper;

import com.tiendacrud.tiendacrud.clientes.domain.entity.Cliente;
import com.tiendacrud.tiendacrud.clientes.domain.entity.ClienteDto;

public class ClienteMapper {

    public static ClienteDto mapToClienteDto(Cliente cliente) {
        return new ClienteDto(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getApellidos(),
                cliente.getCelular(),
                cliente.getDireccion(),
                cliente.getEmail());
    }

    public static Cliente mapToCliente(ClienteDto clienteDto) {
        return new Cliente(
                clienteDto.getId(),
                clienteDto.getNombre(),
                clienteDto.getApellidos(),
                clienteDto.getCelular(),
                clienteDto.getDireccion(),
                clienteDto.getEmail());
    }
}
