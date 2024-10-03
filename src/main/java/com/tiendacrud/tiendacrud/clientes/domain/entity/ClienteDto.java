package com.tiendacrud.tiendacrud.clientes.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDto {
    private String id;
    private String nombre;
    private String apellidos;
    private String celular;
    private String direccion;
    private String email;
}
