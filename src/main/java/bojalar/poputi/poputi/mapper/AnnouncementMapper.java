package bojalar.poputi.poputi.mapper;

import bojalar.poputi.poputi.dto.AnnouncementDTO;
import bojalar.poputi.poputi.model.Announcement;
import bojalar.poputi.poputi.model.User;
import bojalar.poputi.poputi.repository.AnnouncementRepository;
import bojalar.poputi.poputi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnnouncementMapper {
    private final AnnouncementRepository announcementRepository;
    private final UserRepository userRepository;

    @Autowired
    public AnnouncementMapper(AnnouncementRepository announcementRepository, UserRepository userRepository) {
        this.announcementRepository = announcementRepository;
        this.userRepository = userRepository;
    }

    public Announcement toEntity(AnnouncementDTO announcementDTO) {
        if (announcementDTO == null) { return null; }
        Announcement announcement = new Announcement();
        announcement.setId(announcementDTO.getId());
        announcement.setTitle(announcementDTO.getTitle());
        announcement.setDescription(announcementDTO.getDescription());
        announcement.setActive(announcementDTO.isActive());
        User user = userRepository.findById(announcementDTO.getUser_id()).orElseThrow(() -> new RuntimeException("User not found"));
        announcement.setUser_id(user);
        announcement.setStatus(announcementDTO.getStatus());
        announcement.setLocation_from(announcementDTO.getLocation_from());
        announcement.setLocation_to(announcementDTO.getLocation_to());
        return announcement;
    }

    public AnnouncementDTO toDTO(Announcement announcement) {
        if (announcement == null) { return null; }
        AnnouncementDTO announcementDTO = new AnnouncementDTO();
        announcementDTO.setId(announcement.getId());
        announcementDTO.setTitle(announcement.getTitle());
        announcementDTO.setDescription(announcement.getDescription());
        announcementDTO.setStatus(announcement.getStatus());
        announcementDTO.setLocation_from(announcement.getLocation_from());
        announcementDTO.setLocation_to(announcement.getLocation_to());
        announcementDTO.setActive(announcement.getActive());
        if(announcement.getUser_id() != null) { announcementDTO.setUser_id(announcementDTO.getUser_id()); }
        return announcementDTO;
    }
}
