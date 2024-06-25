package bojalar.poputi.poputi.dto;

import bojalar.poputi.poputi.model.enums.UserType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private String user_name;
    private String password;
    private String phone_number;
    private boolean active;
    private String last_name;
    private LocalDate create_date;
    private UserType user_type;
}
