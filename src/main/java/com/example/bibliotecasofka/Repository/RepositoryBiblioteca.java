package com.example.bibliotecasofka.Repository;

import com.example.bibliotecasofka.Model.Biblioteca;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositoryBiblioteca extends MongoRepository <Biblioteca, String> {
}
