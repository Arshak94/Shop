package am.shop.service;


import am.shop.payload.SignUpRequest;
import am.shop.response.ResponseUser;

public interface UserService {
    ResponseUser save(SignUpRequest userdata);

}
