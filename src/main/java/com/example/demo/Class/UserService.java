package com.example.demo.Class;

import com.example.demo.Repositories.RoleRepository;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.Arrays;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    {
        this.userRepository = userRepository;
    }

    public User findByEmail (String email)
    {
        return userRepository.findByEmail(email);
    }

    public Long countByEmail(String email)
    {
        return userRepository.countByEmail (email);
    }

    public User findByUsername (String username)
    {
        return userRepository.findByUsername(username);
    }

    public void saveUser(User user){
        user.setRoles(Arrays.asList(roleRepository.findByRole("USER")));
        user.setEnabled(true);
        userRepository.save(user);
    }


    public void saveAdmin(User user)
    {
        user.setRoles(Arrays.asList(roleRepository.findByRole("ADMIN")));
        user.setEnabled(true);
        userRepository.save(user);
    }
}