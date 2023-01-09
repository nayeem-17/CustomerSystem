package com.minegocio.customersystem.dto;

import com.minegocio.customersystem.model.BranchAddress;
import com.minegocio.customersystem.model.Customer;

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
        BranchAddress mainAddress = c.getAddresses().stream().filter(a -> a.isPrimaryAddress()).findFirst().get();
        this.mainProvince = mainAddress.getProvince();
        this.mainCity = mainAddress.getCity();
        this.mainAddress = mainAddress.getAddress();
    }


    public Long getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(Long identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getMainProvince() {
        return mainProvince;
    }

    public void setMainProvince(String mainProvince) {
        this.mainProvince = mainProvince;
    }

    public String getMainCity() {
        return mainCity;
    }

    public void setMainCity(String mainCity) {
        this.mainCity = mainCity;
    }

    public String getMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(String mainAddress) {
        this.mainAddress = mainAddress;
    }
}
