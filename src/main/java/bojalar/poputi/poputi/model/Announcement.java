package bojalar.poputi.poputi.model;


import bojalar.poputi.poputi.model.enums.AnnouncementStatus;
import bojalar.poputi.poputi.model.enums.AnnouncementType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "announcment")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public String title;

    @Column
    public String description;

    @Enumerated(EnumType.STRING)
    @Column
    private AnnouncementType type;

    @Column
    @CreatedDate
    private LocalDate create_date;

    @Column
    private Boolean active;

    @Column(nullable = false)
    private String location_from;

    @Column(nullable = false)
    private String location_to;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user_id;

    @Column
    @Enumerated(EnumType.STRING)
    private AnnouncementStatus status;

    @PrePersist
    public void prePersist() {
        active = true;
    }
}
