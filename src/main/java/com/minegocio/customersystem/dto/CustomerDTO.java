package com.minegocio.customersystem.dto;

import java.util.List;

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

    public CustomerDTO() {
    }

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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "CustomerDTO [identificationNumber=" + identificationNumber + ", identificationType="
                + identificationType + ", name=" + name + ", email=" + email + ", cellPhone=" + cellPhone
                + ", mainProvince=" + mainProvince + ", mainCity=" + mainCity + ", mainAddress=" + mainAddress + "]";
    }

}
