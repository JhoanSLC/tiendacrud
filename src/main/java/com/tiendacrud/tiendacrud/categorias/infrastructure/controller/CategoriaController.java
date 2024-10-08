package com.tiendacrud.tiendacrud.categorias.infrastructure.controller;

import java.util.List;

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

import com.tiendacrud.tiendacrud.categorias.domain.entity.CategoriaDto;
import com.tiendacrud.tiendacrud.categorias.domain.service.ICategoriaService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    private ICategoriaService categoriaService; 

    // Build Add REST API
    @PostMapping
    public ResponseEntity<CategoriaDto> createCategoria(@RequestBody CategoriaDto categoriaDto){
        CategoriaDto savedCategoria = categoriaService.createCategoria(categoriaDto);
        return new ResponseEntity<>(savedCategoria, HttpStatus.CREATED);
    }

    // Build Get REST API
    @GetMapping("{id}")
    public ResponseEntity<CategoriaDto> getCategoriaById(@PathVariable("id") Long categoriaId){
        CategoriaDto categoriaDto = categoriaService.getCategoriaById(categoriaId);
        return ResponseEntity.ok(categoriaDto);
    }

    // Build Get All REST API
    @GetMapping
    public ResponseEntity<List<CategoriaDto>> getAllCategorias(){
        List<CategoriaDto> categorias = categoriaService.getAllCategorias();
        return ResponseEntity.ok(categorias);
    }

    // Build Put REST API
    @PutMapping("{id}")
    public ResponseEntity<CategoriaDto> updateCategoria(@PathVariable("id") Long categoriaId, 
                                                        @RequestBody CategoriaDto updatedCategoria){
        CategoriaDto categoriaDto = categoriaService.updateCategoria(categoriaId, updatedCategoria);
        return ResponseEntity.ok(categoriaDto);
    }

    // Build Delete REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategoria(@PathVariable("id") Long categoriaId){
        categoriaService.deleteCategori(categoriaId);
        return ResponseEntity.ok("¡Categorìa eliminada exitosamente!");
    }
}
