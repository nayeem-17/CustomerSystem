package com.minegocio.customersystem.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import com.minegocio.customersystem.dto.CustomerDTO;
import com.minegocio.customersystem.model.BranchAddress;
import com.minegocio.customersystem.model.Customer;

class CustomerControllerTest {
    /**
     * Method under test: {@link CustomerController#getCustomers(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetCustomers() {
        // TODO: Complete this test.
        (new CustomerController()).getCustomers("Name");
    }

    /**
     * Method under test: {@link CustomerController#createCustomer(CustomerDTO)}
     */
    @Test
    void testCreateCustomer() {
        // so wrote a non-Spring test instead.
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
    void testCreateCustomer3() {

        CustomerController customerController = new CustomerController();

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setMainAddress("42 Main St");
        customerController.createCustomer(customerDTO);
    }

    /**
     * Method under test:
     * {@link CustomerController#updateCustomerData(Long, Customer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateCustomerData() {
        // TODO: Complete this test.
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
        (new CustomerController()).deleteCustomer(1L);
    }

    /**
     * Method under test: {@link CustomerController#addAddress(Long, BranchAddress)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddAddress() {
        // TODO: Complete this test.
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
        (new CustomerController()).getAddress(1L);
    }
}
