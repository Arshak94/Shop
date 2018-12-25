package am.shop.repository;

import am.shop.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

       Users getOne(Long id);

}
