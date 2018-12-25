package am.shop.service;

import am.shop.entity.Users;
import am.shop.model.client_request.RequestUser;
import am.shop.model.client_response.ResponseUser;
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
    public ResponseUser save(RequestUser userdata, ResponseUser responseUser) {
        Users users = fromRequestUserToUsersTable(userdata);
        userRepository.save(users);
        responseUser = fromUserTableToResponseUser(users);
        //Arshak jan stex chem karoxanum es metodic datan tam responseUser-in
        return responseUser;
    }

    private ResponseUser fromUserTableToResponseUser(Users userstable) {
        ResponseUser responseUser = new ResponseUser();
        userstable = userRepository.getOne(userstable.getId());
        responseUser.setCity(userstable.getCity());
        responseUser.setDayOfBirth(userstable.getDob());
        responseUser.setEmail(userstable.getEmail());
        responseUser.setFirstName(userstable.getFirstName());
        responseUser.setLastName(userstable.getLastName());
        responseUser.setGender(userstable.getGender());
        responseUser.setPassword(userstable.getPassword());
        responseUser.setSerialNumber(userstable.getSerialNumber());
        responseUser.setZipCode(userstable.getZipCode());
        responseUser.setState(userstable.getState());
        responseUser.setPhone(userstable.getPhone());
        return responseUser;
    }

    private Users fromRequestUserToUsersTable(RequestUser requestUser) {
        Users usertable = new Users();
        usertable.setCity(requestUser.getCity());
        usertable.setDob(requestUser.getDayOfBirth());
        usertable.setEmail(requestUser.getEmail());
        usertable.setFirstName(requestUser.getFirstName());
        usertable.setLastName(requestUser.getLastName());
        usertable.setGender(requestUser.getGender());
        usertable.setPassword(requestUser.getPassword());
        usertable.setSerialNumber(requestUser.getSerialNumber());
        usertable.setZipCode(requestUser.getZipCode());
        usertable.setState(requestUser.getState());
        usertable.setPhone(requestUser.getPhone());
        return usertable;
    }
}