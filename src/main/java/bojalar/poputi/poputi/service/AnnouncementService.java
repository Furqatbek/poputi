package bojalar.poputi.poputi.service;


import bojalar.poputi.poputi.dto.AnnouncementDTO;
import bojalar.poputi.poputi.mapper.AnnouncementMapper;
import bojalar.poputi.poputi.model.Announcement;
import bojalar.poputi.poputi.model.enums.AnnouncementStatus;
import bojalar.poputi.poputi.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnnouncementService {
    private final AnnouncementRepository announcementRepository;
    private final AnnouncementMapper announcementMapper;

    @Autowired
    public AnnouncementService(AnnouncementRepository announcementRepository, AnnouncementMapper announcementMapper) {
        this.announcementRepository = announcementRepository;
        this.announcementMapper = announcementMapper;
    }

    public AnnouncementDTO createAnnouncement(AnnouncementDTO announcementDTO) {
        Announcement announcement = announcementMapper.toEntity(announcementDTO);
        announcement.setActive(true);
        announcement.setStatus(AnnouncementStatus.WAITING);
        announcement.setCreate_date(LocalDate.now());
        Announcement savedAnnouncement = announcementRepository.save(announcement);
        return announcementMapper.toDTO(savedAnnouncement);
    }

    public List<AnnouncementDTO> findAllAnnouncements() {
        List<Announcement> announcements = announcementRepository.findAll();
        return announcements.stream()
                .map(announcementMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AnnouncementDTO findAnnouncementById(Long id) {
        Optional<Announcement> announcement = announcementRepository.findById(id);
        if (announcement.isPresent()) {
            return announcementMapper.toDTO(announcement.get());
        } else {
            throw new RuntimeException("No announcement found with id " + id);
        }
    }

    public List<AnnouncementDTO> findAnnuncementByTitle(String title) {
        List<Announcement> announcements = announcementRepository.findByTitle(title);
        return announcements.stream()
                .map(announcementMapper::toDTO)
                .collect(Collectors.toList());
    }
}
