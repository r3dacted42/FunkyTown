package org.r3dacted42.funkytown.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductRequest (
        @JsonProperty("name")
        @NotBlank(message = "Name is required")
        String name,

        @JsonProperty("description")
        @Size(max = 255, message = "Description must not be longer than 255 characters")
        String description,

        @JsonProperty("price")
        @NotNull(message = "Price is required")
        double price
) {
}
