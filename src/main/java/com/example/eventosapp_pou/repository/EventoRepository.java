package com.example.eventosapp_pou.repository;

import com.example.eventosapp_pou.model.Evento;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EventoRepository extends MongoRepository<Evento, String> {

    public Optional<Evento> findById(String codigo);
}
