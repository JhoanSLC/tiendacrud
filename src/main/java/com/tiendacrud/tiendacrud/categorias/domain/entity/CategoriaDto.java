package com.tiendacrud.tiendacrud.categorias.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDto {

    private Long id;
    private String descripcion;
    private String estado;
}
