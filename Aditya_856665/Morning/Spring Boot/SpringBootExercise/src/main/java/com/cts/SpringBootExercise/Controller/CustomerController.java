package com.cts.SpringBootExercise.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.SpringBootExercise.Model.Customer;
import com.cts.SpringBootExercise.Service.CustomerService;

@RequestMapping("customer")
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer createCustomerAPI(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
	
	@GetMapping
	public List<Customer> getAllCustomersAPI() {
		return customerService.fetchCustomers();
	}
	
	@GetMapping("{customerId}")
	public Customer getCustomerAPI(@PathVariable("customerId") int id) {
		return customerService.fetchCustomer(id);
	}
	
	@PutMapping("{customerId}/{dob}")
	public Customer updateCustomerDobAPI(@PathVariable("customerId") int id, @PathVariable("dob") String stringDob) {
		return customerService.updateCustomer(id, LocalDate.parse(stringDob));
	}
	
	@DeleteMapping("{customerId}")
	public List<Customer> deleteCustomer(@PathVariable("customerId") int id)
	{
		List<Customer> list=customerService.deleteCustomer(id);
		return list;
	}
	
	
	
}
