package com.minegocio.customersystem.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.minegocio.customersystem.dto.CustomerDTO;
import com.minegocio.customersystem.model.BranchAddress;
import com.minegocio.customersystem.model.Customer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

class CustomerControllerTest {
    /**
     * Method under test: {@link CustomerController#getCustomers(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetCustomers() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        (new CustomerController()).getCustomers("Name");
    }

    /**
     * Method under test: {@link CustomerController#createCustomer(CustomerDTO)}
     */
    @Test
    void testCreateCustomer() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        CustomerController customerController = new CustomerController();
        ResponseEntity<Boolean> actualCreateCustomerResult = customerController.createCustomer(new CustomerDTO());
        assertFalse(actualCreateCustomerResult.getBody());
        assertEquals(406, actualCreateCustomerResult.getStatusCodeValue());
        assertTrue(actualCreateCustomerResult.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link CustomerController#createCustomer(CustomerDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateCustomer2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.minegocio.customersystem.dto.CustomerDTO.getMainAddress()" because "customerDTO" is null
        //       at com.minegocio.customersystem.controller.CustomerController.createCustomer(CustomerController.java:54)
        //   See https://diff.blue/R013 to resolve this issue.

        (new CustomerController()).createCustomer(null);
    }

    /**
     * Method under test: {@link CustomerController#createCustomer(CustomerDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateCustomer3() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.minegocio.customersystem.service.CustomerService.createCustomer(com.minegocio.customersystem.model.Customer)" because "this.customerService" is null
        //       at com.minegocio.customersystem.controller.CustomerController.createCustomer(CustomerController.java:72)
        //   See https://diff.blue/R013 to resolve this issue.

        CustomerController customerController = new CustomerController();

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setMainAddress("42 Main St");
        customerController.createCustomer(customerDTO);
    }

    /**
     * Method under test: {@link CustomerController#updateCustomerData(Long, Customer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateCustomerData() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

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

    /**
     * Method under test: {@link CustomerController#deleteCustomer(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteCustomer() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        (new CustomerController()).deleteCustomer(1L);
    }

    /**
     * Method under test: {@link CustomerController#addAddress(Long, BranchAddress)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddAddress() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        CustomerController customerController = new CustomerController();

        BranchAddress branchAddress = new BranchAddress();
        branchAddress.setAddress("42 Main St");
        branchAddress.setCity("Oxford");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        branchAddress.setCreatedAt(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        branchAddress.setId(1);
        branchAddress.setPrimaryAddress(true);
        branchAddress.setProvince("Province");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        branchAddress.setUpdatedAt(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        customerController.addAddress(1L, branchAddress);
    }

    /**
     * Method under test: {@link CustomerController#addAddress(Long, BranchAddress)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddAddress2() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        CustomerController customerController = new CustomerController();

        BranchAddress branchAddress = new BranchAddress();
        branchAddress.setAddress("42 Main St");
        branchAddress.setCity("Oxford");
        branchAddress.setCreatedAt(mock(java.sql.Date.class));
        branchAddress.setId(1);
        branchAddress.setPrimaryAddress(true);
        branchAddress.setProvince("Province");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        branchAddress.setUpdatedAt(java.util.Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        customerController.addAddress(1L, branchAddress);
    }

    /**
     * Method under test: {@link CustomerController#getAddress(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAddress() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        (new CustomerController()).getAddress(1L);
    }
}

