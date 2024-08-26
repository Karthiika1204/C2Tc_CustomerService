package com.tnsif.sm.customer;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CustomerController 
{
	@Autowired
	private CustomerService service;
	
	
	//RESTful API methodas for crud operations
	
	
	@GetMapping("/customer")
	public List<Customer> list()
	{
		return service.listAll();
	}
	//Retrive By Id
	/* Get mapping is used to handle get type of request method */
	
	
	/*if there is a yes or no answer for some field we can use
	  Response entity ,it can hold http status code  */
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> get (@PathVariable Integer id)
	{
		try
		{
			Customer customer= service.get(id);
			return new ResponseEntity<Customer>(customer,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new  ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		
	}
	//create operation
	@PostMapping("/customer")
	public void add(@RequestBody Customer customer)
	{
		service.save(customer);
	}
	//update operation
	@PutMapping("/customer/{id}")
	public ResponseEntity<?> update(@RequestBody Customer customer, @PathVariable Integer id) {
	    try {
	        Customer existCustomer = service.get(id);
	        if (existCustomer != null) {
	            customer.setCustomerId(id); // Set the ID to the customer object
	            service.save(customer);
	            return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	  //delete operation
	@DeleteMapping("/customers{id}")
	public void delete(@PathVariable Integer id)
	{
	  service.delete(id);	
	  
	}
	
	@DeleteMapping("/customers")
	public void deleteAll()
	{
	  service.delete();	
	  
	}
	
	

}
