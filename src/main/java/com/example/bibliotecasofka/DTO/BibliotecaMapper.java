package com.example.bibliotecasofka.DTO;


import com.example.bibliotecasofka.Model.Biblioteca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BibliotecaMapper {

    public Biblioteca fromDTO(DTO dto) {
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

    public DTO fromCollection(Biblioteca collection) {
        DTO DTO = new DTO();
        DTO.setId(collection.getId());
        DTO.setNombreLibro(collection.getNombreLibro());
        DTO.setNombreAutor(collection.getNombreAutor());
        DTO.setGenero(collection.getGenero());
        DTO.setTipo(collection.getTipo());
        DTO.setFechaPrestamo(collection.getFechaPrestamo());
        DTO.setPrestado(collection.getPrestado());
        return DTO;
    }

    public List<DTO> fromCollectionList(List<Biblioteca> collection) {
        if (collection == null) {
            return null;

        }
        List<DTO> list = new ArrayList(collection.size());
        Iterator listTracks = (Iterator) collection.iterator();

        while(listTracks.hasNext()) {
            Biblioteca biblioteca = (Biblioteca)listTracks.next();
            list.add(fromCollection(biblioteca));
        }
        return list;
    }
}
