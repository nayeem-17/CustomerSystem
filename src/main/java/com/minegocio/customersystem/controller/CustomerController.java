package com.minegocio.customersystem.controller;

import com.minegocio.customersystem.model.BranchAddress;
import com.minegocio.customersystem.model.Customer;
import com.minegocio.customersystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v01/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    //    Functionality to search for and obtain a list of customers.
    @PostMapping("/")
    public List<Customer> getCustomers() {
        return null;
    }


    //    Functionality to create a new customer with the head office address
    @PostMapping("/create")
    public boolean createCustomer() {
        return false;
    }

    //    Functionality to edit customer data
    @PutMapping("/{identificationNumber}")
    public boolean updateCustomerData(@PathVariable("identificationNumber") String parameter) {
        return false;
    }

    //    Functionality to delete a customer
    @DeleteMapping("/{identificationNumber}")
    public boolean deleteCustomer(@PathVariable String identificationNumber) {
        return false;
    }

    //    Functionality to register a new address per customer
    @PostMapping("/{identificationNumber}/address")
    public void addAddress() {

    }

    //    Functionality to list the additional addresses of the customer
    @GetMapping("/{identificationNumber}/address")
    public List<BranchAddress> getAddress() {
        return null;
    }
}
