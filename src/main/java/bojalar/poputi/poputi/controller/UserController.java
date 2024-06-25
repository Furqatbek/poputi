package bojalar.poputi.poputi.controller;

import bojalar.poputi.poputi.dto.UserDTO;
import bojalar.poputi.poputi.model.User;
import bojalar.poputi.poputi.security.JwtUtil;
import bojalar.poputi.poputi.service.UserDetailsService;
import bojalar.poputi.poputi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }






    //GET
    @PostMapping("/register")
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserDTO user) {
        UserDTO createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable long id) {
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users/by_user_name/{user_name}")
    public ResponseEntity<UserDTO> getUserByUserName(@PathVariable String user_name) {
        UserDTO user = userService.getUserByUsername(user_name);
        return ResponseEntity.ok(user);
    }

    static class JwtResponse {
        private final String jwt;

        JwtResponse(String jwt) {
            this.jwt = jwt;
        }

        public String getJwt() { return jwt; }
    }


}
