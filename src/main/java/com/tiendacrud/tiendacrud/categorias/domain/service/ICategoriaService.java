package com.tiendacrud.tiendacrud.categorias.domain.service;

import com.tiendacrud.tiendacrud.categorias.domain.entity.CategoriaDto;

public interface ICategoriaService {

    CategoriaDto createCategoria(CategoriaDto categoriaDto);
    CategoriaDto getCategoriaById(Long categoriaId);
}
