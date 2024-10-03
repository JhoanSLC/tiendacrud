package com.tiendacrud.tiendacrud.clientes.infrastructure.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendacrud.tiendacrud.clientes.domain.entity.ClienteDto;
import com.tiendacrud.tiendacrud.clientes.domain.service.IClienteService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private IClienteService service;

    @PostMapping
    public ResponseEntity<ClienteDto> createCliente(@RequestBody ClienteDto clienteDto) {
        ClienteDto savedCliente = service.createCliente(clienteDto);
        return new ResponseEntity<>(savedCliente, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClienteDto> getClienteById(@PathVariable("id") String clienteId) {
        ClienteDto clienteDto = service.getClienteById(clienteId);
        return ResponseEntity.ok(clienteDto);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDto>> getAllClientes() {
        List<ClienteDto> clientes = service.getAllClientes();
        return ResponseEntity.ok(clientes);
    }

    @PutMapping("{id}")
    public ResponseEntity<ClienteDto> updateCliente(@PathVariable("id") String clienteId,
            @RequestBody ClienteDto updatedCliente) {
        ClienteDto clienteDto = service.updateCliente(clienteId, updatedCliente);
        return ResponseEntity.ok(clienteDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable("id") String clienteId) {
        service.deleteCliente(clienteId);
        return ResponseEntity.ok("¡Cliente eliminado exitosamente!");
    }
}
