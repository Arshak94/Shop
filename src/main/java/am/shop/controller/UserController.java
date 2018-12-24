package am.shop.controller;


import am.shop.model.Users;
import am.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/allUsers")
    public List<Users> users() {
        return userService.findAll();
    }

    @PostMapping(value = "/register")
    public Map<String, Object> registerNewUser(@RequestBody Users user) {
        return userService.registerNewUser(user);
    }

    @PostMapping(value = "/login")
    public Map<String, Object> userLogin(@RequestBody Users user) {
        return userService.login(user);
    }

}
