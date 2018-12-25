package am.shop.exception;

import javax.validation.constraints.Email;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(@Email String s) {

    }
}
