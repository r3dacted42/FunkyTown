package org.r3dacted42.funkytown.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record CustomerRequest(
        @JsonProperty("email")
        @NotBlank(message = "Email is required")
        @Email(message = "Email must be valid")
        String email,

        @JsonProperty("password")
        @NotBlank(message = "Password is required")
        @Size(min = 8, max = 32, message = "Password must be 8 to 255 characters long")
        String password,

        @JsonProperty("first_name")
        @NotBlank(message = "First name is required")
        @Size(min = 1, max = 255, message = "First Name must be 1 to 255 characters long")
        String firstName,

        @JsonProperty("last_name")
        @Size(max = 255, message = "Last Name must be not be longer than 255 characters")
        String lastName,

        @JsonProperty("phone")
        @NotBlank(message = "Phone Number is required")
        // https://regex101.com/r/qn94Eh/1
        @Pattern(regexp = "^(\\+\\d{1,2}\\s?)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$", message = "Phone number must be valid")
        String phone,

        @JsonProperty("city")
        @NotBlank(message = "City is required")
        @Size(min = 1, max = 255, message = "City must be 1 to 255 characters long")
        String city,

        @JsonProperty("zip")
        @NotBlank(message = "Zip Code is required")
        String zip,

        @JsonProperty("country")
        @NotBlank(message = "Country is required")
        @Size(min = 1, max = 255, message = "Country must be 1 to 255 characters long")
        String country
) {
}
