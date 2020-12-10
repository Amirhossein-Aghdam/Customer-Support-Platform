package com.service.ticketing.models.response.auth;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class AuthResponse {
    @JsonProperty("token")
    private String token;
    @JsonProperty("username")
    private String username;
    @JsonProperty("role")
    private String role;
    @JsonProperty("id")
    private UUID id;

    public AuthResponse(String token, String username, String role, UUID id) {
        this.token = token;
        this.username = username;
        this.role = role;
        this.id = id;
    }
}
