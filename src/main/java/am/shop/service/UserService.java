package am.shop.service;


import am.shop.model.client_request.RequestUser;
import am.shop.model.client_response.ResponseUser;

public interface UserService {

    //esi chishtn asac uzum ei void grei vorohetev indz tvum  a tenc chishta
    ResponseUser save(RequestUser userdata, ResponseUser responseUser);

}
