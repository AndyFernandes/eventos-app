package com.example.eventosapp_pou;

import com.example.eventosapp_pou.model.Evento;
import com.example.eventosapp_pou.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventosappPouApplication {

//	@Autowired
//	private EventoRepository repository;


	public static void main(String[] args) {
		SpringApplication.run(EventosappPouApplication.class, args);
	}
}
//
//	public void run(String... args) throws Exception {
//
//		// save a couple of customers
//		repository.save(new Evento("ashsdo", "sdhoadshds", "asiudsu", "hasdiuadhsiudhsad"));
//		repository.save(new Evento("Bob", "Smith", "assssss", "qqqq"));
//
//		// fetch all customers
//		System.out.println("Customers found with findAll():");
//		System.out.println("-------------------------------");
//		for (Evento customer : repository.findAll()) {
//			System.out.println(customer);
//		}
//		System.out.println();
//}}