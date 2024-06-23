package bojalar.poputi.poputi.repository;

import bojalar.poputi.poputi.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
    User findById(long id);
    User findByUsername(String username);
    User save(User user);
    Iterable<User> findAll();

    @Query("SELECT u FROM User u WHERE u.phone_number = :phone_number")
    User findByPhoneNumber(@Param("phone_number") String phone_number);
}
