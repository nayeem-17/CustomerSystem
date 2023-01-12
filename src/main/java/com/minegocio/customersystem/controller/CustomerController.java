package com.minegocio.customersystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minegocio.customersystem.dto.CustomerDTO;
import com.minegocio.customersystem.model.BranchAddress;
import com.minegocio.customersystem.model.Customer;
import com.minegocio.customersystem.service.CustomerService;

@RestController
@RequestMapping("/api/v01/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    // Functionality to search for and obtain a list of customers.
    @PostMapping("/{name}")
    public List<CustomerDTO> getCustomers(@PathVariable String name) {
        List<Customer> customers = customerService.getCustomersByName(name);
        List<CustomerDTO> result = new ArrayList<>();
        for (Customer c : customers) {
            CustomerDTO customerDTO = new CustomerDTO(c);
            result.add(customerDTO);
        }
        return result;
    }

    // Functionality to create a new customer with the head office address
    @PostMapping("/create")
    public ResponseEntity<Boolean> createCustomer(@RequestBody CustomerDTO customerDTO) {
        // System.out.println(customerDTO);

        if (customerDTO.getMainAddress() == null) {
            // send an error message with http response 404
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
        }
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setCellPhone(customerDTO.getCellPhone());
        customer.setEmail(customerDTO.getEmail());
        customer.setIdentificationType(customerDTO.getIdentificationType());
        customer.setIdentificationNumber(customerDTO.getIdentificationNumber());
        BranchAddress address = new BranchAddress();
        address.setAddress(customerDTO.getMainAddress());
        address.setPrimaryAddress(true);
        address.setCity(customerDTO.getMainCity());
        address.setProvince(customerDTO.getMainProvince());
        customer.setAddresses(new ArrayList<>());
        customer.getAddresses().add(address);
        // System.out.println(customer);
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }

    // Functionality to edit customer data
    @PutMapping("/{identificationNumber}")
    public boolean updateCustomerData(@PathVariable("identificationNumber") Long identificationNumber,
            Customer customer) {
        return this.customerService.updateCustomer(customer, identificationNumber);
    }

    // Functionality to delete a customer
    @DeleteMapping("/{identificationNumber}")
    public boolean deleteCustomer(@PathVariable Long identificationNumber) {

        return this.customerService.deleteCustomer(identificationNumber);
    }

    // Functionality to register a new address per customer
    @PostMapping("/{identificationNumber}/address")
    public void addAddress(@PathVariable Long identificationNumber, BranchAddress address) {
        this.customerService.addAddress(identificationNumber, address);
    }

    // Functionality to list the additional addresses of the customer
    @GetMapping("/{identificationNumber}/address")
    public List<BranchAddress> getAddress(@PathVariable Long identificationNumber) {
        return this.customerService.getAddresses(identificationNumber);
    }
}
