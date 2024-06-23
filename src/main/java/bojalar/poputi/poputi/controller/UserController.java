package bojalar.poputi.poputi.controller;

import bojalar.poputi.poputi.model.User;
import bojalar.poputi.poputi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id) {
        return userService.findById(id);
    }

    @GetMapping("/by_user_name/{user_name}")
    public User getUserByName(@PathVariable String user_name) {
        return userService.findByUsername(user_name);
    }

    @GetMapping("/by_phone_number/{phone_number}")
    public User getUserByPhoneNumber(@PathVariable String phone_number) {
        return userService.findByPhoneNumber(phone_number);
    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return userService.save(user);
    }

}
