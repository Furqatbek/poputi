package bojalar.poputi.poputi.mapper;

import bojalar.poputi.poputi.dto.UserDTO;
import bojalar.poputi.poputi.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(UserDTO dto) {
        if (dto == null) return null;
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setUsername(dto.getUser_name());
        user.setPassword(dto.getPassword());
        user.setSurname(dto.getSurname());
        user.setPhone_number(dto.getPhone_number());
        user.setActive(dto.isActive());
        user.setLast_name(dto.getLast_name());
        user.setUser_type(dto.getUser_type());
        return user;
    }
    public UserDTO toDto(User user) {
        if (user == null) return null;
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setPassword(user.getPassword());
        dto.setSurname(user.getSurname());
        dto.setPhone_number(user.getPhone_number());
        dto.setActive(user.getActive());
        dto.setUser_name(user.getUsername());
        dto.setLast_name(user.getLast_name());
        dto.setUser_type(user.getUser_type());
        return dto;
    }
}
