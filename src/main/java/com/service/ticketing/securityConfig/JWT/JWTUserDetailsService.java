package com.service.ticketing.securityConfig.JWT;

import com.service.ticketing.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JWTUserDetailsService implements UserDetailsService {

    @Autowired
    private DataService dataService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.service.ticketing.models.response.User user = null;
        try {
            user = (com.service.ticketing.models.response.User)
                    dataService.loadUserByUsername(username);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(user == null){
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return new User(user.getUsername(), user.getPassword(), user.getRoles());
    }
}
