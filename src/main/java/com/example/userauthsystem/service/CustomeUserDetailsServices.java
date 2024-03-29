package com.example.userauthsystem.service;

import com.example.userauthsystem.MODEL.User;
import com.example.userauthsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class CustomeUserDetailsServices implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Username or Password not found");
        }
        return new CustomeUserDetails(user.getUsername(),user.getPassword(),authorities(),user.getFullname());
    }
    public Collection<?extends GrantedAuthority>authorities(){
        return Arrays.asList(new SimpleGrantedAuthority("USER"));
    }
}













