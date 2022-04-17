package own.halone.imageboard.Database.Comments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsDAO extends JpaRepository<Comments,Long>   {
}
