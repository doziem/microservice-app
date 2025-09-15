package com.doziem.ecommerce.customer;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest request){

        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @PutMapping
    public ResponseEntity<Void> updateCustomer(
            @RequestBody @Valid CustomerRequest request
    ){
        customerService.updateCustomer(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll(){
        return ResponseEntity.ok(customerService.findAllCustomer());
    }

    @GetMapping("/exists/{customerId}")
    public ResponseEntity<Boolean> existById(@PathVariable String customerId){
        return ResponseEntity.ok(customerService.existById(customerId));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable String customerId){
        return ResponseEntity.ok(customerService.findByCustomerId(customerId));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteById(@PathVariable String customerId){
        customerService.deleteByCustomer(customerId);
        return ResponseEntity.accepted().build();
    }
}
