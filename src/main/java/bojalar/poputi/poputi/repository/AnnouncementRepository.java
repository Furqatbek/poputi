package bojalar.poputi.poputi.repository;

import bojalar.poputi.poputi.model.Announcement;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnnouncementRepository extends CrudRepository<Announcement, Long> {
    Announcement findById(long id);
    Announcement findByTitle(String title);
    Announcement save(Announcement announcement);
    List<Announcement> findAll();
}
