package am.shop.service;


import am.shop.model.Token;
import am.shop.model.Users;
import am.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    private Users user = new Users();
    private Map<String, Object> userMap = new HashMap<>();

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public Optional<Users> findUserByEmail(String email) {
        return userRepository.findUserByEmail(user.getEmail());
    }

    @Override
    public Map<String, Object> login(Users user) {
        if (userRepository.findUserByEmail(user.getEmail()).isPresent()) {
            if (userRepository.findUserByEmailAndPassword(user.getEmail(), user.getPassword())) {
                userMap.put("success", "true");
                userMap.put("message", "Login Successfully");
                userMap.put("user", userRepository.getOne(user.getId()));
                userMap.put("data", new Token());
            }
        } else {
            userMap.put("success", "false");
            userMap.put("Login failed", new Users());
        }
        return userMap;
    }
    @Override
    public Map<String, Object> registerNewUser(Users user) {
        if (userRepository.findUserByEmail(user.getEmail()).isPresent()) {
            userMap.put("success", "false");
            userMap.put("message", "Registration Failed,");
            userMap.put("data", userRepository.findUserById(user.getId()));
        } else {
            userRepository.saveAndFlush(user);
            userMap.put("success", "true");
            userMap.put("message", "Registration Successfully");
            userMap.put("user", user);
            userMap.put("data", new Token());
        }
        return userMap;
    }
    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }
}