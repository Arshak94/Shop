package am.shop.controller;

import am.shop.model.client_request.RequestUser;
import am.shop.model.client_response.ResponseUser;
import am.shop.repository.UserRepository;
import am.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/signup")
    public ResponseUser signup(@RequestBody RequestUser users, ResponseUser responseUser) {
        userService.save(users, responseUser);
        return responseUser;
    }
}
