package com.tiendacrud.tiendacrud.categorias.domain.service;

import java.util.List;

import com.tiendacrud.tiendacrud.categorias.domain.entity.CategoriaDto;

public interface ICategoriaService {

    CategoriaDto createCategoria(CategoriaDto categoriaDto);
    CategoriaDto getCategoriaById(Long categoriaId);
    List<CategoriaDto> getAllCategorias();
    CategoriaDto updateCategoria(Long categoriaId, CategoriaDto updatedCategoria);
    void deleteCategori(Long categoriaId);
}
