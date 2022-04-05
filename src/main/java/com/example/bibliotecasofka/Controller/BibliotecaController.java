package com.example.bibliotecasofka.Controller;

import com.example.bibliotecasofka.DTO.DTO;
import com.example.bibliotecasofka.Model.Biblioteca;
import com.example.bibliotecasofka.Services.BibliotecaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca")
public class BibliotecaController {

    @Autowired
    BibliotecaServices bibliotecaServices;

    @GetMapping("/{id}")
    public ResponseEntity<DTO> findbyId(@PathVariable("id") String id) {
        return new ResponseEntity(bibliotecaServices.obtenerPorId(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<DTO>> findAll() {
        return new ResponseEntity(bibliotecaServices.obtenerTodos(), HttpStatus.OK);
    }

    @GetMapping("/disponibilidad")
    public ResponseEntity<String> disponibilidad(@RequestBody Biblioteca Libro){
        if(bibliotecaServices.disponibilidad(Libro.getNombreLibro())){
            return new ResponseEntity("El Libro está disponible para prestamo", HttpStatus.OK);
        }
        return new ResponseEntity(bibliotecaServices.buscarPorNombre(Libro.getNombreLibro()).getFechaPrestamo(),
                HttpStatus.OK);
    }
    

    @PostMapping("/crear")
    public ResponseEntity<DTO> create(@RequestBody DTO DTO) {
        return new ResponseEntity(bibliotecaServices.crear(DTO), HttpStatus.CREATED);
    }

    @PutMapping("/modificar")
    public ResponseEntity<DTO> update(@RequestBody DTO DTO){
        if (DTO.getId() != null){
            return new ResponseEntity(bibliotecaServices.modificar(DTO),HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
