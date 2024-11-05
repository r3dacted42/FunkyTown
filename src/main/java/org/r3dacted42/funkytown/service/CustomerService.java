package org.r3dacted42.funkytown.service;

import lombok.RequiredArgsConstructor;
import org.r3dacted42.funkytown.dto.CustomerRequest;
import org.r3dacted42.funkytown.dto.CustomerResponse;
import org.r3dacted42.funkytown.dto.CustomerUpdateRequest;
import org.r3dacted42.funkytown.entity.Customer;
import org.r3dacted42.funkytown.exception.CustomerNotFoundException;
import org.r3dacted42.funkytown.helper.EncryptionService;
import org.r3dacted42.funkytown.mapper.CustomerMapper;
import org.r3dacted42.funkytown.repo.CustomerRepo;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;
    private final EncryptionService encryptionService;

    public String createCustomer(CustomerRequest request) {
        Customer customer = customerMapper.toEntity(request);
        customer.setPassword(encryptionService.encode(customer.getPassword()));
        customerRepo.save(customer);
        return "Customer created";
    }

    protected Customer getCustomer(String email) {
        return customerRepo.findByEmail(email)
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Cannot get Customer:: No customer found with the provided email:: %s", email)
                ));
    }

    public CustomerResponse retrieveCustomer(String email) {
        Customer customer = getCustomer(email);
        return customerMapper.toResponse(customer);
    }

    public String updateCustomer(String email, CustomerUpdateRequest request) {
        Customer customer = getCustomer(email);
        if (request.firstName() != null) { customer.setFirstName(request.firstName()); }
        if (request.lastName() != null) { customer.setLastName(request.lastName()); }
        if (request.phone() != null) { customer.setPhone(request.phone()); }
        if (request.city() != null) { customer.setCity(request.city()); }
        if (request.zip() != null) { customer.setZip(request.zip()); }
        if (request.country() != null) { customer.setCountry(request.country()); }
        customerRepo.save(customer);
        return "Customer updated";
    }

    public String deleteCustomer(String email) {
        Customer customer = getCustomer(email);
        customerRepo.delete(customer);
        return "Customer deleted";
    }

}
