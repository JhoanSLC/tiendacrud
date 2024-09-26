package com.tiendacrud.tiendacrud.categorias.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiendacrud.tiendacrud.categorias.domain.entity.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria,Long> {

}
