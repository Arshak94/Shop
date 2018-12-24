package am.shop.repository;


import am.shop.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {


    boolean findUserByEmailAndPassword(String email, String password);

    Optional<Users> findUserByEmail(String email);

    Users findUserByPassword(Users user);

    Users findUserById(Long id);


    @Override
    List<Users> findAll();

}
