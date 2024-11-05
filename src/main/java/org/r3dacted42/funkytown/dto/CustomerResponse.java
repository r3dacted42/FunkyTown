package org.r3dacted42.funkytown.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CustomerResponse(
        @JsonProperty("id")
        Long id,
        @JsonProperty("email")
        String email,
        @JsonProperty("first_name")
        String firstName,
        @JsonProperty("last_name")
        String lastName,
        @JsonProperty("phone")
        String phone,
        @JsonProperty("city")
        String city,
        @JsonProperty("zip")
        String zip,
        @JsonProperty("country")
        String country
) {
}
