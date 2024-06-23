package bojalar.poputi.poputi.controller;

import bojalar.poputi.poputi.model.Announcement;
import bojalar.poputi.poputi.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Announcement> getAnnouncements() {
        return announcementService.findAll();
    }

    @GetMapping("/{id}")
    public Announcement getAnnouncement(@PathVariable long id) {
        return announcementService.findById(id);
    }

    @GetMapping("/{title}")
    public Announcement getAnnouncementByTitle(@PathVariable String title) {
        return announcementService.findByTitle(title);
    }

    @PostMapping
    public Announcement createAnnouncement(@RequestBody Announcement announcement) {
        return announcementService.save(announcement);
    }
}
