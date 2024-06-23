package bojalar.poputi.poputi.service;


import bojalar.poputi.poputi.model.Announcement;
import bojalar.poputi.poputi.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementService {
    private final AnnouncementRepository announcementRepository;

    @Autowired
    public AnnouncementService(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    public Announcement save(Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    public List<Announcement> findAll() {
        return (List<Announcement>) announcementRepository.findAll();
    }

    public Announcement findById(long id) {
        return announcementRepository.findById(id);
    }

    public Announcement findByTitle(String title) {
        return announcementRepository.findByTitle(title);
    }
}
