package bojalar.poputi.poputi.repository;

import bojalar.poputi.poputi.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    User findById(long id);
    Optional<User> findByUsername(String username);
    User save(User user);
    List<User> findAll();

    @Query("SELECT u FROM User u WHERE u.phone_number = :phone_number")
    User findByPhoneNumber(@Param("phone_number") String phone_number);
}
