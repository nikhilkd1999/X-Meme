package com.nikhil.xmeme.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.nikhil.xmeme.entities.User;
import com.nikhil.xmeme.repositories.IUserRepository;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        final Optional<User> userOptional = userRepository.findById(username);

        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }

        return new CustomUserPrinciple(userOptional.get());

    }

}
