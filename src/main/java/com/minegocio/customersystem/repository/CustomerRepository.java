package com.minegocio.customersystem.repository;

import com.minegocio.customersystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    Customer findByIdentificationNumber(Long identificationNumber);

    List<Customer> findCustomerByName(String name);

}
