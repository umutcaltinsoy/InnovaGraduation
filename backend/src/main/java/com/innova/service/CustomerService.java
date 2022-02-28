package com.innova.service;

import com.innova.dto.CustomerDto;
import com.innova.model.CreditResult;
import com.innova.model.Customer;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> getCustomers();

    Boolean saveCustomer(CustomerDto customerDto);

    CustomerDto updateCustomer(String identity, CustomerDto detail);

    void deleteCustomer(String id);

    CustomerDto getCustomerByIdentityNumber(String identityNumber);

    CreditResult getCreditResultByIdentityNumber(String identityNumber);
}

