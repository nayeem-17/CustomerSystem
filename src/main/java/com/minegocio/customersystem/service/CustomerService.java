package com.minegocio.customersystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minegocio.customersystem.model.BranchAddress;
import com.minegocio.customersystem.model.Customer;
import com.minegocio.customersystem.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public boolean createCustomer(Customer customer) {
        try {
            this.customerRepository.save(customer);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean updateCustomer(Customer updatedCustomer, Long identificationNumber) {
        Customer customer = this.customerRepository.findByIdentificationNumber(identificationNumber);
        customer.setEmail(updatedCustomer.getEmail());
        customer.setName(updatedCustomer.getName());
        customer.setCellPhone(updatedCustomer.getCellPhone());
        customer.setAddresses(updatedCustomer.getAddresses());
        customerRepository.save(customer);
        return true;
    }

    public Customer findByIdentificationNumber(Long identificationNumber) {
        return this.customerRepository.findByIdentificationNumber(identificationNumber);
    }

    public boolean deleteCustomer(Long identificationNumber) {
        this.customerRepository.delete(this.customerRepository.findByIdentificationNumber(identificationNumber));
        return true;
    }

    public void addAddress(Long identificationNumber, BranchAddress branchAddress) {
        Customer customer = this.customerRepository.findByIdentificationNumber(identificationNumber);
        customer.getAddresses().add(branchAddress);
        this.customerRepository.save(customer);
    }

    public List<BranchAddress> getAddresses(Long identificationNumber) {
        Customer customer = this.customerRepository.findByIdentificationNumber(identificationNumber);
        return customer.getAddresses();
    }

    public List<Customer> getCustomersByName(String name) {
        return this.customerRepository.findCustomerByName(name);
    }
}
