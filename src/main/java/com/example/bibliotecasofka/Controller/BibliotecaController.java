package com.example.bibliotecasofka.Controller;

import com.example.bibliotecasofka.DTO.BibliotecaDTO;
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
    public ResponseEntity<BibliotecaDTO> findbyId(@PathVariable("id") String id) {
        return new ResponseEntity(bibliotecaServices.obtenerPorId(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<BibliotecaDTO>> findAll() {
        return new ResponseEntity(bibliotecaServices.obtenerTodos(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<BibliotecaDTO> create(@RequestBody BibliotecaDTO bibliotecaDTO) {
        return new ResponseEntity(bibliotecaServices.crear(bibliotecaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/modificar")
    public ResponseEntity<BibliotecaDTO> update(@RequestBody BibliotecaDTO bibliotecaDTO){
        if (bibliotecaDTO.getId() != null){
            return new ResponseEntity(bibliotecaServices.modificar(bibliotecaDTO),HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
