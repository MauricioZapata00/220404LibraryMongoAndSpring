package com.example.bibliotecasofka.DTO;


import com.example.bibliotecasofka.Model.Biblioteca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BibliotecaMapper {

    public Biblioteca fromDTO(BibliotecaDTO dto) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setId(dto.getId());
        biblioteca.setNombreLibro(dto.getNombreLibro());
        biblioteca.setNombreAutor(dto.getNombreAutor());
        biblioteca.setGenero(dto.getGenero());
        biblioteca.setTipo(dto.getTipo());
        biblioteca.setFechaPrestamo(dto.getFechaPrestamo());
        biblioteca.setPrestado(dto.getPrestado());
        return biblioteca;
    }

    public BibliotecaDTO fromCollection(Biblioteca collection) {
        BibliotecaDTO bibliotecaDTO = new BibliotecaDTO();
        bibliotecaDTO.setId(collection.getId());
        bibliotecaDTO.setNombreLibro(collection.getNombreLibro());
        bibliotecaDTO.setNombreAutor(collection.getNombreAutor());
        bibliotecaDTO.setGenero(collection.getGenero());
        bibliotecaDTO.setTipo(collection.getTipo());
        bibliotecaDTO.setFechaPrestamo(collection.getFechaPrestamo());
        bibliotecaDTO.setPrestado(collection.getPrestado());
        return bibliotecaDTO;
    }

    public List<BibliotecaDTO> fromCollectionList(List<Biblioteca> collection) {
        if (collection == null) {
            return null;

        }
        List<BibliotecaDTO> list = new ArrayList(collection.size());
        Iterator listTracks = (Iterator) collection.iterator();

        while(listTracks.hasNext()) {
            Biblioteca biblioteca = (Biblioteca)listTracks.next();
            list.add(fromCollection(biblioteca));
        }
        return list;
    }
}
