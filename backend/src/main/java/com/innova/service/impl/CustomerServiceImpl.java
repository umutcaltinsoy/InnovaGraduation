package com.innova.service.impl;
import com.innova.dto.CustomerDto;
import com.innova.exception.ResourceNotFoundException;
import com.innova.feign.client.FeignService;
import com.innova.feign.model.CreditResponse;
import com.innova.feign.model.CreditScoreRequest;
import com.innova.mapper.CustomerMapper;
import com.innova.model.CreditResult;
import com.innova.model.Customer;
import com.innova.repository.CreditResultRepository;
import com.innova.repository.CustomerRepository;
import com.innova.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final FeignService feignService;
    private final CreditResultRepository creditResultRepository;

    @Override
    public List<CustomerDto> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map((customerMapper::mapCustomerToCustomerDto))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean saveCustomer(CustomerDto customerDto) {
        Boolean isSaved = false;
        Customer customer = customerMapper.mapCustomerDtoToCustomer(customerDto);
        Optional<Customer> isCustomerExist = customerRepository.findByIdentityNumber(customerDto.getIdentityNumber());
        if (isCustomerExist.isEmpty()) {
            customerRepository.save(customer);
            isSaved = true;
            CreditScoreRequest creditScoreRequest = createRequestForApplication(customerDto);
            //Call Credit Service By Feign
            setCreditResult(customer, creditScoreRequest);
            log.info("Get customers credit result...");
        }
        return isSaved;
    }


    @Override
    public CustomerDto updateCustomer(String identity, CustomerDto detail) {
        // Optional
        Customer customer = customerRepository.findByIdentityNumber(identity).orElseThrow(
                () -> new ResourceNotFoundException("Customer does not exist with id " + identity));
        setCustomerFields(detail, customer);
        Customer updatedCustomer = customerRepository.save(customer);
        log.info("Updated customer detail...");
        return customerMapper.mapCustomerToCustomerDto(updatedCustomer);
    }

    @Override
    public void deleteCustomer(String identityNumber) {
        log.info("Customer deleting...");
        customerRepository.deleteByIdentityNumber(identityNumber);
    }

    @Override
    public CustomerDto getCustomerByIdentityNumber(String identityNumber) {
        CustomerDto customerDto = new CustomerDto();
        Optional<Customer> customer = customerRepository.findByIdentityNumber(identityNumber);
        if (customer.isPresent()) {
            customerDto = customerMapper.mapCustomerToCustomerDto(customer.get());
            return customerDto;
        } else {
            return customerDto;
        }
    }

    @Override
    public CreditResult getCreditResultByIdentityNumber(String identityNumber) {
        return creditResultRepository.findByIdentityNumber(identityNumber);
    }

    private void setCustomerFields(CustomerDto detail, Customer customer) {
        customer.setIdentityNumber(detail.getIdentityNumber());
        customer.setCustomerName(detail.getCustomerName());
        customer.setCustomerSurname(detail.getCustomerSurname());
        customer.setCustomerSalary(detail.getCustomerSalary());
        customer.setCustomerPhoneNumber(detail.getCustomerPhoneNumber());
    }

    private CreditScoreRequest createRequestForApplication(CustomerDto customerDto) {
        CreditScoreRequest creditScoreRequest = new CreditScoreRequest();
        creditScoreRequest.setSalary(customerDto.getCustomerSalary());
        creditScoreRequest.setIdentityNumber(customerDto.getIdentityNumber());
        return creditScoreRequest;
    }

    private void setCustomerCreditResult(CreditResponse response, Customer customer) {
        CreditResult creditResult = new CreditResult();
        creditResult.setCreditResult(response.getCreditResult().name());
        creditResult.setCreditLimit(response.getCreditLimit());
        creditResult.setIdentityNumber(customer.getIdentityNumber());

        creditResultRepository.save(creditResult);

        customer.setCreditResult(creditResult);
        customerRepository.save(customer);
    }

    private void setCreditResult(Customer customer, CreditScoreRequest creditScoreRequest) {
        log.info("Invoking credit microservice...");
        CreditResponse response = feignService.callCreditResultService(creditScoreRequest);
        log.info("Got response from credit microservice...");
        setCustomerCreditResult(response, customer);
    }

}
