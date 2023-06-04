package com.alash.todolist.service.serviceImpl;

import com.alash.todolist.entity.User;
import com.alash.todolist.repository.UserRepository;
import com.alash.todolist.service.UserService;
import jakarta.persistence.NonUniqueResultException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User getUser(User user) {
        System.out.println("Service GET *****");
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean getUserByUsername(String username, String password) {
        boolean usernamePresent;
        boolean passwordPresent;

        try {
            usernamePresent = userRepository.findTopByUsername(username) != null;
            System.out.println("Username present: " + usernamePresent);

            passwordPresent = userRepository.findTopByPassword(password) != null;
            System.out.println("Password present: " + passwordPresent);
        } catch (NonUniqueResultException e) {
            return true;
        }
        return usernamePresent && passwordPresent;
    }

    @Override
    public boolean findUserByUsername(String username) {
        boolean usernamePresent;

        try {
            usernamePresent = userRepository.findTopByUsername(username) != null;
            System.out.println("Username present (U): " + usernamePresent);
        } catch (NonUniqueResultException e) {
            return true;
        }
        return usernamePresent;
    }

    @Override
    public String saveUser(User user) {
        userRepository.save(user);
        return "User saved successfully";
    }


}
