package com.example.eventosapp_pou.repository;

import com.example.eventosapp_pou.model.Convidado;
import com.example.eventosapp_pou.model.Evento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConvidadoRepository extends MongoRepository<Convidado, String> {
    Iterable<Convidado> findByEvento(Evento evento);
}
