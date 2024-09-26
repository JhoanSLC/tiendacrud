package com.tiendacrud.tiendacrud.categorias.domain.service;

import org.springframework.stereotype.Service;

import com.tiendacrud.tiendacrud.categorias.domain.entity.Categoria;
import com.tiendacrud.tiendacrud.categorias.domain.entity.CategoriaDto;
import com.tiendacrud.tiendacrud.categorias.infrastructure.repository.ICategoriaRepository;
import com.tiendacrud.tiendacrud.categorias.mapper.CategoriaMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoriaServiceImpl implements ICategoriaService {

    private ICategoriaRepository categoriaRepository;

    @Override
    public CategoriaDto createCategoria(CategoriaDto categoriaDto) {
        
        Categoria categoria = CategoriaMapper.mapToCategoria(categoriaDto);
        Categoria savedCategoria = categoriaRepository.save(categoria);
        return CategoriaMapper.mapToCategoriaDto(savedCategoria);
    }

}
