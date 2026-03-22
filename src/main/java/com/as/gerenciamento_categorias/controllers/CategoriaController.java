package com.as.gerenciamento_categorias.controllers;

import com.as.gerenciamento_categorias.models.CategoriaModel;
import com.as.gerenciamento_categorias.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaModel> criar(@RequestBody CategoriaModel categoriaModel) {
        CategoriaModel categoria = categoriaService.criar(categoriaModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(categoria.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(categoria);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaModel>> listar() {
        List<CategoriaModel> categorias = categoriaService.listar();
        return ResponseEntity.ok().body(categorias);
    }

    @GetMapping("/{id}")
    public Optional<CategoriaModel> buscarId(Long id) {
        return categoriaService.buscarId(id);
    }

    @PutMapping("/{id}")
    public CategoriaModel atualizar(@PathVariable Long id, @RequestBody CategoriaModel categoriaModel) {
        return categoriaService.atualizar(id, categoriaModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        categoriaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
