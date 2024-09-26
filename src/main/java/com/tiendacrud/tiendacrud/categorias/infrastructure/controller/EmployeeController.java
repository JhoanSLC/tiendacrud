package com.tiendacrud.tiendacrud.categorias.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendacrud.tiendacrud.categorias.domain.entity.CategoriaDto;
import com.tiendacrud.tiendacrud.categorias.domain.service.ICategoriaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/categoria")
public class EmployeeController {

    private ICategoriaService categoriaService; 


    @PostMapping
    public ResponseEntity<CategoriaDto> createCategoria(@RequestBody CategoriaDto categoriaDto){
        CategoriaDto savedCategoria = categoriaService.createCategoria(categoriaDto);
        return new ResponseEntity<>(savedCategoria, HttpStatus.CREATED);
    }
}
