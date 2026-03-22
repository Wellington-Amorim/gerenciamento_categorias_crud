package com.as.gerenciamento_categorias.repositories;

import com.as.gerenciamento_categorias.models.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositoy extends JpaRepository<CategoriaModel, Long> {
}
