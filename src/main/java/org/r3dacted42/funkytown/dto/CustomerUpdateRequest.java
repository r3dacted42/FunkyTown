package org.r3dacted42.funkytown.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CustomerUpdateRequest(
        @JsonProperty("first_name")
        @Size(min = 1, max = 255, message = "First Name must be 1 to 255 characters long")
        String firstName,

        @JsonProperty("last_name")
        @Size(max = 255, message = "Last Name must be not be longer than 255 characters")
        String lastName,

        @JsonProperty("phone")
        @Pattern(regexp = "^(\\+\\d{1,2}\\s?)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$", message = "Phone number must be valid")
        String phone,

        @JsonProperty("city")
        @Size(min = 1, max = 255, message = "City must be 1 to 255 characters long")
        String city,

        @JsonProperty("zip")
        String zip,

        @JsonProperty("country")
        @Size(min = 1, max = 255, message = "Country must be 1 to 255 characters long")
        String country
) {
}
