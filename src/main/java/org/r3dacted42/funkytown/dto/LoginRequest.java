package org.r3dacted42.funkytown.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest (
        @JsonProperty("email")
        @NotBlank(message = "Email is required")
        @Email(message = "Email must be valid")
        String email,

        @JsonProperty("password")
        @NotBlank(message = "Password is required")
        @Size(min = 8, max = 32, message = "Password must be 8 to 32 characters long")
        String password
) {
}
