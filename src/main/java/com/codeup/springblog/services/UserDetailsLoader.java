package com.codeup.springblog.services;

import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.RoleRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.security.UserWithRoles;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("customerUserDetailsService")
public class UserDetailsLoader implements UserDetailsService {
    private final UserRepository users;
    private final RoleRepository roles;

    public UserDetailsLoader(UserRepository users, RoleRepository roles) {
        this.roles = roles;
        this.users = users;
    }

    @Override
    public UserWithRoles loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }

        return new UserWithRoles(user, roles.ofUserWith(username));
    }
}