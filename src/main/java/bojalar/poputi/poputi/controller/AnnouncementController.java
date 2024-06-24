package bojalar.poputi.poputi.controller;

import bojalar.poputi.poputi.dto.AnnouncementDTO;
import bojalar.poputi.poputi.model.Announcement;
import bojalar.poputi.poputi.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/announcement")
public class AnnouncementController {
    private final AnnouncementService announcementService;

    @Autowired
    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping
    public ResponseEntity<List<AnnouncementDTO>> getAnnouncements() {
        List<AnnouncementDTO> announcements = announcementService.findAllAnnouncements();
        return ResponseEntity.ok(announcements);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnnouncementDTO> getAnnouncementById(@PathVariable("id") long id) {
        AnnouncementDTO announcement = announcementService.findAnnouncementById(id);
        return ResponseEntity.ok(announcement);
    }

    @GetMapping("/{title}")
    public ResponseEntity<AnnouncementDTO> getAnnouncementByTitle(@PathVariable("title") String title) {
        List<AnnouncementDTO> announcement = announcementService.findAnnuncementByTitle(title);
        return ResponseEntity.ok((AnnouncementDTO) announcement);
    }

    @PostMapping
    public ResponseEntity<AnnouncementDTO> createAnnouncement(@RequestBody AnnouncementDTO announcement) {
        AnnouncementDTO result = announcementService.createAnnouncement(announcement);
        return ResponseEntity.ok(result);
    }

}
