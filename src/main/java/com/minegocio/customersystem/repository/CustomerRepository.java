package com.minegocio.customersystem.repository;

import com.minegocio.customersystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    Customer findByIdentificationNumber(Long identificationNumber);
}
