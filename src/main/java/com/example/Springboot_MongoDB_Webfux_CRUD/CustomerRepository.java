package com.example.Springboot_MongoDB_Webfux_CRUD;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;

public interface CustomerRepository extends ReactiveMongoRepository<Customer,Integer> 
{
	Flux<Customer> findByCity(String city);
}
