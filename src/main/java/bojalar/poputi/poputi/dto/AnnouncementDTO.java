package bojalar.poputi.poputi.dto;

import bojalar.poputi.poputi.model.enums.AnnouncementStatus;
import bojalar.poputi.poputi.model.enums.AnnouncementType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AnnouncementDTO {
    private Long id;
    private Long user_id;
    private String title;
    private String description;
    private LocalDate create_date;
    private boolean active;
    private AnnouncementStatus status;
    private AnnouncementType type;
    private String location_from;
    private String location_to;
}
