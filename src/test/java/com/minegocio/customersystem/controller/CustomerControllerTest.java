package com.minegocio.customersystem.controller;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class CustomerControllerTest {
    /**
     * Method under test: {@link CustomerController#createCustomer()}
     */
    @Test
    void testCreateCustomer() {

        assertFalse((new CustomerController()).createCustomer());
    }

    /**
     * Method under test: {@link CustomerController#updateCustomerData(String)}
     */
    @Test
    void testUpdateCustomerData() {

        assertFalse((new CustomerController()).updateCustomerData("Parameter"));
    }

    /**
     * Method under test: {@link CustomerController#deleteCustomer(String)}
     */
    @Test
    void testDeleteCustomer() {

        assertFalse((new CustomerController()).deleteCustomer("42"));
    }

    /**
     * Method under test: {@link CustomerController#getAddress()}
     */
    @Test
    void testGetAddress() {

        assertNull((new CustomerController()).getAddress());
    }

    @Test
    void testConstructor() {
        CustomerController actualCustomerController = new CustomerController();
        actualCustomerController.addAddress();
        assertNull(actualCustomerController.getCustomers());
    }
}
