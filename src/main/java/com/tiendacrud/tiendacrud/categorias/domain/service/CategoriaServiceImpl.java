package com.tiendacrud.tiendacrud.categorias.domain.service;

import org.springframework.stereotype.Service;

import com.tiendacrud.tiendacrud.categorias.domain.entity.Categoria;
import com.tiendacrud.tiendacrud.categorias.domain.entity.CategoriaDto;
import com.tiendacrud.tiendacrud.categorias.infrastructure.repository.ICategoriaRepository;
import com.tiendacrud.tiendacrud.categorias.mapper.CategoriaMapper;
import com.tiendacrud.tiendacrud.excepciones.ResourceNotFoundException;

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

    @Override
    public CategoriaDto getCategoriaById(Long categoriaId) {
        Categoria categoria = categoriaRepository.findById(categoriaId)
            .orElseThrow(() -> 
                new ResourceNotFoundException("Categoria con el id: " + categoriaId + " no encontrado"));

        return CategoriaMapper.mapToCategoriaDto(categoria);
    }

}
