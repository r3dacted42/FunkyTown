package org.r3dacted42.funkytown.mapper;

import org.r3dacted42.funkytown.dto.CustomerRequest;
import org.r3dacted42.funkytown.dto.CustomerResponse;
import org.r3dacted42.funkytown.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toEntity(final CustomerRequest request) {
        return Customer.builder()
                .email(request.email())
                .password(request.password())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .phone(request.phone())
                .city(request.city())
                .zip(request.zip())
                .country(request.country())
                .build();
    }

    public CustomerResponse toResponse(final Customer entity) {
        return new CustomerResponse(
                entity.getId(),
                entity.getEmail(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getPhone(),
                entity.getCity(),
                entity.getZip(),
                entity.getCountry()
        );
    }
}
