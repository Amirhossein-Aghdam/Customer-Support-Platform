package com.service.ticketing.api;

import com.service.ticketing.models.projects.roles.Constants;
import com.service.ticketing.models.projects.roles.Customer;
import com.service.ticketing.models.projects.tickets.Ticket;
import com.service.ticketing.securityConfig.JWT.JWTProvider;
import com.service.ticketing.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequestMapping("api/customer")
@RestController
public class CustomersController {

    private final CustomerService customerService;
    private final JWTProvider jwtProvider;

    @Value("${jwt.token.prefix}")
    public String TOKEN_PREFIX;

    @Autowired
    public CustomersController(CustomerService customerService, JWTProvider jwtProvider) {
        this.customerService = customerService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("create")
    @PreAuthorize(Constants.ADMIN_has + " or " + Constants.MANAGER_has)
    public Customer createCustomer(@RequestBody Customer customer) throws IOException, ClassNotFoundException {
        return customerService.addCustomer(customer);
    }

    @PostMapping("create/ticket")
    public Ticket createTicket(@RequestHeader("Authorization") String header, @RequestBody Ticket ticket){
        String token = header.replace(TOKEN_PREFIX, "");
        String username = jwtProvider.getUsernameFromToken(token);
        return customerService.createTicketAsCustomer(ticket, username);
    }

}
