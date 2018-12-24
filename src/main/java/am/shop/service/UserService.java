package am.shop.service;


import am.shop.model.Users;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {

    Optional<Users> findUserByEmail(String email);
    Map<String, Object> login(Users user);
    Map<String, Object> registerNewUser(Users user);
    List<Users> findAll();

}
