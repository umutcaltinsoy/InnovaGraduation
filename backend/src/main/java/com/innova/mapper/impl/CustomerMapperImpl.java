package com.innova.mapper.impl;

import com.innova.dto.CustomerDto;
import com.innova.mapper.CustomerMapper;
import com.innova.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperImpl implements CustomerMapper {


    @Override
    public Customer mapCustomerDtoToCustomer(CustomerDto customerDto) {

        return Customer.builder().customerName(customerDto.getCustomerName())
                .customerSurname(customerDto.getCustomerSurname())
                .customerPhoneNumber(customerDto.getCustomerPhoneNumber())
                .identityNumber(customerDto.getIdentityNumber())
                .customerSalary(customerDto.getCustomerSalary()).build();

    }

    @Override
    public CustomerDto mapCustomerToCustomerDto(Customer customer) {

        return CustomerDto.builder().customerName(customer.getCustomerName())
                .customerSalary(customer.getCustomerSalary())
                .customerPhoneNumber(customer.getCustomerPhoneNumber())
                .identityNumber(customer.getIdentityNumber())
                .customerSurname(customer.getCustomerSurname()).build();
    }
}
