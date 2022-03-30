package com.example.bibliotecasofka.Services;


import com.example.bibliotecasofka.DTO.BibliotecaDTO;
import com.example.bibliotecasofka.DTO.BibliotecaMapper;
import com.example.bibliotecasofka.Model.Biblioteca;
import com.example.bibliotecasofka.Repository.RepositoryBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BibliotecaServices {
    @Autowired
    RepositoryBiblioteca repositoryBiblioteca;
    BibliotecaMapper bibliotecaMapper = new BibliotecaMapper();

    public List<BibliotecaDTO> obtenerTodos() {
        List<Biblioteca> bibliotecas = (List<Biblioteca>)repositoryBiblioteca.findAll();
        return bibliotecaMapper.fromCollectionList(bibliotecas);
    }

    public BibliotecaDTO obtenerPorId(String id) {
        Biblioteca biblioteca = repositoryBiblioteca.findById(id).orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        return bibliotecaMapper.fromCollection(biblioteca);
    }

    public BibliotecaDTO crear(BibliotecaDTO bibliotecaDTO) {
        Biblioteca biblioteca = bibliotecaMapper.fromDTO(bibliotecaDTO);
        return bibliotecaMapper.fromCollection(repositoryBiblioteca.save(biblioteca));
    }

    public BibliotecaDTO modificar(BibliotecaDTO bibliotecaDTO) {
        Biblioteca biblioteca = bibliotecaMapper.fromDTO(bibliotecaDTO);
        repositoryBiblioteca.findById(biblioteca.getId()).orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        return bibliotecaMapper.fromCollection(repositoryBiblioteca.save(biblioteca));
    }

    public void borrar(String id) {
        repositoryBiblioteca.deleteById(id);
    }

}
