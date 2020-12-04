package com.service.ticketing.services;

import com.service.ticketing.dao.ProjectDao;
import com.service.ticketing.models.projects.roles.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CustomerService {

    private final ProjectDao projectDao;

    @Autowired
    public CustomerService(@Qualifier("LinkedDao") ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    //create new customer
    public Customer addCustomer(Customer customer) throws IOException, ClassNotFoundException {
        return projectDao.addCustomer(customer);
    }
}
