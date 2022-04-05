package com.example.bibliotecasofka.Services;


import com.example.bibliotecasofka.DTO.DTO;
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

    public List<DTO> obtenerTodos() {
        List<Biblioteca> bibliotecas = (List<Biblioteca>)repositoryBiblioteca.findAll();
        return bibliotecaMapper.fromCollectionList(bibliotecas);
    }

    public DTO obtenerPorId(String id) {
        Biblioteca biblioteca = repositoryBiblioteca.findById(id).orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        return bibliotecaMapper.fromCollection(biblioteca);
    }

    public DTO crear(DTO DTO) {
        Biblioteca biblioteca = bibliotecaMapper.fromDTO(DTO);
        return bibliotecaMapper.fromCollection(repositoryBiblioteca.save(biblioteca));
    }

    public DTO modificar(DTO DTO) {
        Biblioteca biblioteca = bibliotecaMapper.fromDTO(DTO);
        repositoryBiblioteca.findById(biblioteca.getId()).orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        return bibliotecaMapper.fromCollection(repositoryBiblioteca.save(biblioteca));
    }

    public Boolean disponibilidad (String nombreLibro){
       var libro = repositoryBiblioteca.findByNombreLibro(nombreLibro);
       return libro.getPrestado();
    }

    public Biblioteca buscarPorNombre (String nombreLibro){
        return repositoryBiblioteca.findByNombreLibro(nombreLibro);
    }

    public void borrar(String id) {
        repositoryBiblioteca.deleteById(id);
    }

}
