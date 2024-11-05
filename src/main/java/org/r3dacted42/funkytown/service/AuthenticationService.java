package org.r3dacted42.funkytown.service;

import lombok.RequiredArgsConstructor;
import org.r3dacted42.funkytown.dto.LoginRequest;
import org.r3dacted42.funkytown.entity.Customer;
import org.r3dacted42.funkytown.helper.EncryptionService;
import org.r3dacted42.funkytown.helper.JWTService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final CustomerService customerService;
    private final EncryptionService encryptionService;
    private final JWTService jwtService;

    public String login(LoginRequest loginRequest) {
        Customer customer = customerService.getCustomer(loginRequest.email());
        if (!encryptionService.validate(loginRequest.password(), customer.getPassword())) {
            return "Wrong password or email";
        }
        return jwtService.generateToken(loginRequest.email());
    }
}
