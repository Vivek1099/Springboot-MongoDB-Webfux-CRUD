package com.example.Springboot_MongoDB_Webfux_CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/*
 * DI Used in this spring project
 * -Spring Reactive Web
 * -Spring Data Reactive mongoDB
 * -Spring Boot Dev Tools
 */
@RestController
public class CustomerController 
{
	@Autowired  
	CustomerRepository crepo;
	
	@RequestMapping("/test")
	public String test()
	{
		return "This is webflux test with mongodb";
	}
	
	@PostMapping("/save")
	public Mono<Customer> saveall(@RequestBody Customer customer)
	{	
		return crepo.save(customer);
	}
	
	@GetMapping("/show")
	public Flux<Customer> showall()
	{
		return crepo.findAll();
	}
	
	@GetMapping("/byid/{cid}")
	public Mono<Customer> ById(@PathVariable int cid)
	{
		return crepo.findById(cid);
	}
	
	@DeleteMapping("/delbyid/{cid}")
	public Mono<Void> DelById(@PathVariable int cid)
	{
		return crepo.deleteById(cid);
	}
	
	@GetMapping("/city/{city}")
	public Flux<Customer> ByCity(@PathVariable String city)
	{
		return crepo.findByCity(city);
	}
	
}
