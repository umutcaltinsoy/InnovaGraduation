package com.innova.controller;

import com.innova.dto.CustomerDto;
import com.innova.model.CreditResult;
import com.innova.model.Customer;
import com.innova.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class CustomerController {

    // Inject
    private final CustomerService customerService;

    @GetMapping("/customer")
    public List<CustomerDto> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping("/customer")
    public ResponseEntity<Boolean> saveCustomer(@RequestBody CustomerDto customerDto) {
        Boolean isSaved = customerService.saveCustomer(customerDto);
        return ResponseEntity.ok(isSaved);
    }

    @GetMapping(value = "/customer", params = "identity")
    public ResponseEntity<CustomerDto> getCustomerByIdentityNumber(@RequestParam(name = "identity") String identity) {
        CustomerDto customerDto = customerService.getCustomerByIdentityNumber(identity);
        return ResponseEntity.ok(customerDto);
    }

    @PutMapping("/customer/{identity}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable(name = "identity") String identity, @RequestBody CustomerDto details) {
        CustomerDto customerDto = customerService.updateCustomer(identity, details);
        return ResponseEntity.ok(customerDto);
    }


    @DeleteMapping("/customer/{identity}")
    public ResponseEntity<?> deleteCustomer(@PathVariable(name = "identity") String identity) {
        customerService.deleteCustomer(identity);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/customer/result/{identityNumber}")
    public ResponseEntity<CreditResult> getCreditResult(@PathVariable(name = "identityNumber") String identityNumber) {
        CreditResult creditResult = customerService.getCreditResultByIdentityNumber(identityNumber);
        return ResponseEntity.ok(creditResult);
    }
}
