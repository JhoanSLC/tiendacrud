package com.tiendacrud.tiendacrud.categorias.mapper;

import com.tiendacrud.tiendacrud.categorias.domain.entity.Categoria;
import com.tiendacrud.tiendacrud.categorias.domain.entity.CategoriaDto;

public class CategoriaMapper {

    public static CategoriaDto mapToCategoriaDto(Categoria categoria){
        return new CategoriaDto(
            categoria.getId(),
            categoria.getDescripcion(),
            categoria.getEstado()
        );
    }

    public static Categoria mapToCategoria(CategoriaDto categoriaDto){
        return new Categoria(
            categoriaDto.getId(),
            categoriaDto.getDescripcion(),
            categoriaDto.getEstado()
        );
    }
}
