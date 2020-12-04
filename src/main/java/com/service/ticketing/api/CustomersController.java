package com.service.ticketing.api;

import com.service.ticketing.models.projects.roles.Constants;
import com.service.ticketing.models.projects.roles.Customer;
import com.service.ticketing.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("api/customer")
@RestController
public class CustomersController {

    private final CustomerService customerService;

    @Autowired
    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("create")
    @PreAuthorize(Constants.ADMIN_has + " or " + Constants.MANAGER_has)
    public Customer createCustomer(@RequestBody Customer customer) throws IOException, ClassNotFoundException {
        return customerService.addCustomer(customer);
    }

}
