package com.tbh.real.time.notifications.utility;

import com.tbh.real.time.notifications.entity.User;
import com.tbh.real.time.notifications.entity.Users;
import com.tbh.real.time.notifications.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Users user = userRepository.getUserByUsername(username);
        User userDetails = new User();

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        } else{
            userDetails.setUsername(user.getUsername());
            userDetails.setPassword(user.getPassword());
            userDetails.setRole(user.getRole());
        }

        return new NFUserDetails(userDetails);
    }
}
