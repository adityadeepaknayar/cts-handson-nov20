package com.cts.SpringBootExercise.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.SpringBootExercise.Model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
