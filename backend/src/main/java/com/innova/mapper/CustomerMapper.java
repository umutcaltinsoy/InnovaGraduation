package com.innova.mapper;

import com.innova.dto.CustomerDto;
import com.innova.model.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
     Customer mapCustomerDtoToCustomer(CustomerDto customerDto);
     CustomerDto mapCustomerToCustomerDto(Customer customer);
}
