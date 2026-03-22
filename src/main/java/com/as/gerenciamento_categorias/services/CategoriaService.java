package com.as.gerenciamento_categorias.services;

import com.as.gerenciamento_categorias.models.CategoriaModel;
import com.as.gerenciamento_categorias.repositories.CategoriaRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepositoy categoriaRepositoy;

    public CategoriaModel criar(CategoriaModel categoriaModel) {
        return  categoriaRepositoy.save(categoriaModel);
    }

    public List<CategoriaModel> listar() {
        return categoriaRepositoy.findAll();
    }

    public Optional<CategoriaModel> buscarId(Long id) {
        return categoriaRepositoy.findById(id);
    }

    public CategoriaModel atualizar(Long id, CategoriaModel categoriaModel) {
        CategoriaModel model = categoriaRepositoy.findById(id).get();
        model.setNome(categoriaModel.getNome());
        model.setDescricao(categoriaModel.getDescricao());
        return  categoriaRepositoy.save(model);
    }

    public void deletar(Long id) {
        categoriaRepositoy.deleteById(id);
    }
}
