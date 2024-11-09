package org.r3dacted42.funkytown.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductResponse (
        @JsonProperty("id")
        long id,
        @JsonProperty("name")
        String name,
        @JsonProperty("description")
        String description,
        @JsonProperty("price")
        double price
) {
}
