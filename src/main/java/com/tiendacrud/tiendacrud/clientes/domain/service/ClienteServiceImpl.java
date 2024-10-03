package com.tiendacrud.tiendacrud.clientes.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tiendacrud.tiendacrud.clientes.domain.entity.Cliente;
import com.tiendacrud.tiendacrud.clientes.domain.entity.ClienteDto;
import com.tiendacrud.tiendacrud.clientes.infrastructure.repository.IClienteRepository;
import com.tiendacrud.tiendacrud.clientes.mapper.ClienteMapper;
import com.tiendacrud.tiendacrud.excepciones.ResourceNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements IClienteService {
    private IClienteRepository repository;

    @Override
    public ClienteDto createCliente(ClienteDto clienteDto) {
        Cliente cliente = ClienteMapper.mapToCliente(clienteDto);
        Cliente savedCliente = repository.save(cliente);

        return ClienteMapper.mapToClienteDto(savedCliente);
    }

    @Override
    public ClienteDto getClienteById(String clienteId) {
        Cliente cliente = repository.findById(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente con el id:" + clienteId + " no encontrado"));

        return ClienteMapper.mapToClienteDto(cliente);
    }

    @Override
    public List<ClienteDto> getAllClientes() {
        List<Cliente> clientes = repository.findAll();

        return clientes.stream().map((cliente) -> ClienteMapper.mapToClienteDto(cliente))
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDto updateCliente(String clienteId, ClienteDto updatedCliente) {
        Cliente cliente = repository.findById(clienteId).orElseThrow(
                () -> new ResourceNotFoundException("Cliente con el id: " + clienteId + " no encontrado"));

        cliente.setNombre(updatedCliente.getNombre());
        cliente.setApellidos(updatedCliente.getApellidos());
        cliente.setCelular(updatedCliente.getCelular());
        cliente.setDireccion(updatedCliente.getDireccion());
        cliente.setEmail(updatedCliente.getEmail());

        Cliente updatedClienteObj = repository.save(cliente);
        return ClienteMapper.mapToClienteDto(updatedClienteObj);
    }

    @Override
    public void deleteCliente(String clienteId) {
        repository.findById(clienteId).orElseThrow(
                () -> new ResourceNotFoundException("Cliente con el id: " + clienteId + " no encontrado"));
        repository.deleteById(clienteId);
    }

}
