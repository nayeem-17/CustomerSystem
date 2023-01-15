package com.minegocio.customersystem.dto;

import java.util.List;

import com.minegocio.customersystem.model.BranchAddress;
import com.minegocio.customersystem.model.Customer;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class CustomerDTO {
    private Long identificationNumber;
    private String identificationType;
    private String name;
    private String email;
    private String cellPhone;

    private String mainProvince;
    private String mainCity;
    private String mainAddress;

    public CustomerDTO(Customer c) {
        this.identificationType = c.getIdentificationType();
        this.identificationNumber = c.getIdentificationNumber();
        this.email = c.getEmail();
        this.name = c.getName();
        this.cellPhone = c.getCellPhone();
        List<BranchAddress> mainAddress = c.getAddresses();
        for (BranchAddress b : mainAddress) {
            if (b.isPrimaryAddress()) {
                this.mainProvince = b.getProvince();
                this.mainCity = b.getCity();
                this.mainAddress = b.getAddress();
                break;
            }
        }

    }

}
