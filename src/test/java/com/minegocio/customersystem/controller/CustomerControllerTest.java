package com.minegocio.customersystem.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import com.minegocio.customersystem.dto.CustomerDTO;
import com.minegocio.customersystem.model.BranchAddress;
import com.minegocio.customersystem.model.Customer;

class CustomerControllerTest {

    @Test
    @Disabled("TODO: Complete this test")
    void testGetCustomers() {

        (new CustomerController()).getCustomers("Name");
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testCreateCustomer() {

        CustomerController customerController = new CustomerController();
        customerController.createCustomer(new CustomerDTO(new Customer()));
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testCreateCustomer2() {
        (new CustomerController()).createCustomer(null);
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testCreateCustomer3() {

        CustomerController customerController = new CustomerController();

        BranchAddress branchAddress = new BranchAddress();
        branchAddress.setAddress("42 Main St");
        branchAddress.setCity("Oxford");
        branchAddress.setId(1);
        branchAddress.setPrimaryAddress(true);
        branchAddress.setProvince("Province");

        ArrayList<BranchAddress> branchAddressList = new ArrayList<>();
        branchAddressList.add(branchAddress);

        Customer customer = new Customer();
        customer.setAddresses(branchAddressList);
        customerController.createCustomer(new CustomerDTO(customer));
    }

    @Test
    void testCreateCustomer4() {

        CustomerController customerController = new CustomerController();

        BranchAddress branchAddress = new BranchAddress();
        branchAddress.setAddress(null);
        branchAddress.setCity("Oxford");
        branchAddress.setId(1);
        branchAddress.setPrimaryAddress(true);
        branchAddress.setProvince("Province");

        ArrayList<BranchAddress> branchAddressList = new ArrayList<>();
        branchAddressList.add(branchAddress);

        Customer customer = new Customer();
        customer.setAddresses(branchAddressList);
        ResponseEntity<Boolean> actualCreateCustomerResult = customerController
                .createCustomer(new CustomerDTO(customer));
        assertFalse(actualCreateCustomerResult.getBody());
        assertEquals(406, actualCreateCustomerResult.getStatusCodeValue());
        assertTrue(actualCreateCustomerResult.getHeaders().isEmpty());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateCustomerData() {

        CustomerController customerController = new CustomerController();

        Customer customer = new Customer();
        customer.setAddresses(new ArrayList<>());
        customer.setCellPhone("4105551212");
        customer.setEmail("jane.doe@example.org");
        customer.setId("42");
        customer.setIdentificationNumber(1L);
        customer.setIdentificationType("Identification Type");
        customer.setName("Name");
        customerController.updateCustomerData(1L, customer);
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteCustomer() {

        (new CustomerController()).deleteCustomer(1L);
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testAddAddress() {

        CustomerController customerController = new CustomerController();

        BranchAddress branchAddress = new BranchAddress();
        branchAddress.setAddress("42 Main St");
        branchAddress.setCity("Oxford");
        branchAddress.setId(1);
        branchAddress.setPrimaryAddress(true);
        branchAddress.setProvince("Province");
        customerController.addAddress(1L, branchAddress);
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGetAddress() {

        (new CustomerController()).getAddress(1L);
    }
}
