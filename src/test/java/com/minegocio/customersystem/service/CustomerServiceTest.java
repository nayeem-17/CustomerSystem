package com.minegocio.customersystem.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.minegocio.customersystem.model.BranchAddress;
import com.minegocio.customersystem.model.Customer;
import com.minegocio.customersystem.repository.CustomerRepository;

@ContextConfiguration(classes = { CustomerService.class })
@ExtendWith(SpringExtension.class)
class CustomerServiceTest {
    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Test
    void testGetAll() {
        ArrayList<Customer> customerList = new ArrayList<>();
        when(customerRepository.findAll()).thenReturn(customerList);
        List<Customer> actualAll = customerService.getAll();
        assertSame(customerList, actualAll);
        assertTrue(actualAll.isEmpty());
        verify(customerRepository).findAll();
    }

    @Test
    void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setAddresses(new ArrayList<>());
        customer.setCellPhone("4105551212");
        customer.setEmail("jane.doe@example.org");
        customer.setId("42");
        customer.setIdentificationNumber(1L);
        customer.setIdentificationType("Identification Type");
        customer.setName("Name");
        when(customerRepository.save((Customer) any())).thenReturn(customer);

        Customer customer1 = new Customer();
        customer1.setAddresses(new ArrayList<>());
        customer1.setCellPhone("4105551212");
        customer1.setEmail("jane.doe@example.org");
        customer1.setId("42");
        customer1.setIdentificationNumber(1L);
        customer1.setIdentificationType("Identification Type");
        customer1.setName("Name");
        assertTrue(customerService.createCustomer(customer1));
        verify(customerRepository).save((Customer) any());
    }

    @Test
    void testUpdateCustomer() {
        Customer customer = new Customer();
        customer.setAddresses(new ArrayList<>());
        customer.setCellPhone("4105551212");
        customer.setEmail("jane.doe@example.org");
        customer.setId("42");
        customer.setIdentificationNumber(1L);
        customer.setIdentificationType("Identification Type");
        customer.setName("Name");

        Customer customer1 = new Customer();
        customer1.setAddresses(new ArrayList<>());
        customer1.setCellPhone("4105551212");
        customer1.setEmail("jane.doe@example.org");
        customer1.setId("42");
        customer1.setIdentificationNumber(1L);
        customer1.setIdentificationType("Identification Type");
        customer1.setName("Name");
        when(customerRepository.save((Customer) any())).thenReturn(customer1);
        when(customerRepository.findByIdentificationNumber((Long) any())).thenReturn(customer);

        Customer customer2 = new Customer();
        customer2.setAddresses(new ArrayList<>());
        customer2.setCellPhone("4105551212");
        customer2.setEmail("jane.doe@example.org");
        customer2.setId("42");
        customer2.setIdentificationNumber(1L);
        customer2.setIdentificationType("Identification Type");
        customer2.setName("Name");
        assertTrue(customerService.updateCustomer(customer2, 1L));
        verify(customerRepository).findByIdentificationNumber((Long) any());
        verify(customerRepository).save((Customer) any());
    }

    @Test
    void testFindByIdentificationNumber() {
        Customer customer = new Customer();
        customer.setAddresses(new ArrayList<>());
        customer.setCellPhone("4105551212");
        customer.setEmail("jane.doe@example.org");
        customer.setId("42");
        customer.setIdentificationNumber(1L);
        customer.setIdentificationType("Identification Type");
        customer.setName("Name");
        when(customerRepository.findByIdentificationNumber((Long) any())).thenReturn(customer);
        assertSame(customer, customerService.findByIdentificationNumber(1L));
        verify(customerRepository).findByIdentificationNumber((Long) any());
    }

    @Test
    void testDeleteCustomer() {
        Customer customer = new Customer();
        customer.setAddresses(new ArrayList<>());
        customer.setCellPhone("4105551212");
        customer.setEmail("jane.doe@example.org");
        customer.setId("42");
        customer.setIdentificationNumber(1L);
        customer.setIdentificationType("Identification Type");
        customer.setName("Name");
        when(customerRepository.findByIdentificationNumber((Long) any())).thenReturn(customer);
        doNothing().when(customerRepository).delete((Customer) any());
        assertTrue(customerService.deleteCustomer(1L));
        verify(customerRepository).findByIdentificationNumber((Long) any());
        verify(customerRepository).delete((Customer) any());
    }

    @Test
    void testAddAddress() {
        Customer customer = new Customer();
        customer.setAddresses(new ArrayList<>());
        customer.setCellPhone("4105551212");
        customer.setEmail("jane.doe@example.org");
        customer.setId("42");
        customer.setIdentificationNumber(1L);
        customer.setIdentificationType("Identification Type");
        customer.setName("Name");

        Customer customer1 = new Customer();
        customer1.setAddresses(new ArrayList<>());
        customer1.setCellPhone("4105551212");
        customer1.setEmail("jane.doe@example.org");
        customer1.setId("42");
        customer1.setIdentificationNumber(1L);
        customer1.setIdentificationType("Identification Type");
        customer1.setName("Name");
        when(customerRepository.save((Customer) any())).thenReturn(customer1);
        when(customerRepository.findByIdentificationNumber((Long) any())).thenReturn(customer);

        BranchAddress branchAddress = new BranchAddress();
        branchAddress.setAddress("42 Main St");
        branchAddress.setCity("Oxford");
        branchAddress.setId(1);
        branchAddress.setPrimaryAddress(true);
        branchAddress.setProvince("Province");
        customerService.addAddress(1L, branchAddress);
        verify(customerRepository).findByIdentificationNumber((Long) any());
        verify(customerRepository).save((Customer) any());
    }

    @Test
    void testGetAddresses() {
        Customer customer = new Customer();
        ArrayList<BranchAddress> branchAddressList = new ArrayList<>();
        customer.setAddresses(branchAddressList);
        customer.setCellPhone("4105551212");
        customer.setEmail("jane.doe@example.org");
        customer.setId("42");
        customer.setIdentificationNumber(1L);
        customer.setIdentificationType("Identification Type");
        customer.setName("Name");
        when(customerRepository.findByIdentificationNumber((Long) any())).thenReturn(customer);
        List<BranchAddress> actualAddresses = customerService.getAddresses(1L);
        assertSame(branchAddressList, actualAddresses);
        assertTrue(actualAddresses.isEmpty());
        verify(customerRepository).findByIdentificationNumber((Long) any());
    }

    @Test
    void testGetCustomersByName() {
        ArrayList<Customer> customerList = new ArrayList<>();
        when(customerRepository.findCustomerByName((String) any())).thenReturn(customerList);
        List<Customer> actualCustomersByName = customerService.getCustomersByName("Name");
        assertSame(customerList, actualCustomersByName);
        assertTrue(actualCustomersByName.isEmpty());
        verify(customerRepository).findCustomerByName((String) any());
    }
}
