package bojalar.poputi.poputi.service;

import bojalar.poputi.poputi.model.User;
import bojalar.poputi.poputi.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findById(long id) {
        return userRepository.findById(id);
    }

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    public User findByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber);
    }
}
