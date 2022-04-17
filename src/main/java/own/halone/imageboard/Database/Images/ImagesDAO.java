package own.halone.imageboard.Database.Images;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagesDAO extends JpaRepository<Images,Long> {
}
