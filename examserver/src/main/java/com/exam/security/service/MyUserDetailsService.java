package com.exam.security.service;

import com.exam.entity.User;
import com.exam.repository.UserRepository;
import com.exam.security.model.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));
        MyUserDetails myUserDetails = user.map(MyUserDetails::new).get();

        user.orElseThrow(() -> new UsernameNotFoundException("username not found"));

        return myUserDetails;
    }
}
