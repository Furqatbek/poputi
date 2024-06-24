package bojalar.poputi.poputi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
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
    @CreatedDate
    private LocalDate create_date;

    @OneToMany(mappedBy = "id",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Announcement> announcements;
}
