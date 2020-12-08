package com.cts.SpringBootExercise.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.SpringBootExercise.Model.Customer;
import com.cts.SpringBootExercise.Repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer addCustomer(Customer customer) {
		Customer createdCustomer = customerRepository.save(customer);
		return createdCustomer;
	}
	public List<Customer> fetchCustomers(){
		return customerRepository.findAll();
	}
	public Customer fetchCustomer(int id) {
		Optional<Customer> option = customerRepository.findById(id);
		if(option.isPresent()) 
			return option.get();
		else 
			return null;
	}
	public Customer updateCustomer(int id, LocalDate dob) {
		Customer customer = fetchCustomer(id);
		if(customer != null) {
			customer.setDob(dob);
			return customerRepository.save(customer);
		} 
		else 
			return null;
	}
	
	public List<Customer> deleteCustomer(int id)
	{
		customerRepository.deleteById(id);
		List<Customer> list = fetchCustomers();
		return list;
	}
}
