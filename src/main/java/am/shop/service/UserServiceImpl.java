package am.shop.service;

import am.shop.exception.UserAlreadyExistException;
import am.shop.model.User;
import am.shop.payload.SignUpRequest;
import am.shop.response.ResponseUser;
import am.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseUser save(SignUpRequest userdata) {
        userRepository.findByEmail(userdata.getEmail())
                .ifPresent(user -> new UserAlreadyExistException("User with this email" + user.getEmail()+" already exist"));
        return fromUserToResponse(userRepository.save(fromSignUpToUser(userdata)));
    }

    private User fromSignUpToUser(SignUpRequest user){
        return User.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .city(user.getCity())
                .dob(user.getDayOfBirth())
                .gender(user.getGender())
                .password(user.getPassword())
                .zipCode(user.getZipCode())
                .state(user.getState())
                .serialNumber(user.getSerialNumber())
                .registerType("native")
                .build();
    }

    private ResponseUser fromUserToResponse(User user){
        return ResponseUser.builder().firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .city(user.getCity())
                .dayOfBirth(user.getDob())
                .gender(user.getGender())
                .password(user.getPassword())
                .zipCode(user.getZipCode())
                .state(user.getState())
                .serialNumber(user.getSerialNumber())
                .build();
    }
}