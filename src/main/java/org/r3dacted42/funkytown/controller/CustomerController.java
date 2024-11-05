package org.r3dacted42.funkytown.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.r3dacted42.funkytown.dto.CustomerRequest;
import org.r3dacted42.funkytown.dto.CustomerResponse;
import org.r3dacted42.funkytown.dto.CustomerUpdateRequest;
import org.r3dacted42.funkytown.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest request) {
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @GetMapping("/{email}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable("email") String email) {
        return ResponseEntity.ok(customerService.retrieveCustomer(email));
    }

    @PatchMapping("/{email}")
    public ResponseEntity<String> updateCustomer(
            @PathVariable("email") String email,
            @RequestBody @Valid CustomerUpdateRequest request)
    {
        return ResponseEntity.ok(customerService.updateCustomer(email, request));
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("email") String email) {
        return ResponseEntity.ok(customerService.deleteCustomer(email));
    }
}
