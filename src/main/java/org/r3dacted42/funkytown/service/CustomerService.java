package org.r3dacted42.funkytown.service;

import lombok.RequiredArgsConstructor;
import org.r3dacted42.funkytown.dto.CustomerRequest;
import org.r3dacted42.funkytown.entity.Customer;
import org.r3dacted42.funkytown.mapper.CustomerMapper;
import org.r3dacted42.funkytown.repo.CustomerRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;

    public String createCustomer(CustomerRequest request) {
        Customer customer = customerMapper.toEntity(request);
        customerRepo.save(customer);
        return "Customer created";
    }

}
