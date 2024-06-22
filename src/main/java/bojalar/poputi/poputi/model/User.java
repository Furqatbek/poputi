package bojalar.poputi.poputi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String last_name;

    @Column(nullable = false)
    private String phone_number;

    @Column(nullable = false)
    private String password;

    @Column
    private String username;

    @Column
    private Boolean active;

    @Column
    private String surname;

    @Column
    private LocalDate create_date;

    @OneToMany(mappedBy = "user",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Announcement> announcements;
}
