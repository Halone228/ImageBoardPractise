package own.halone.imageboard.Database.Posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsDAO extends JpaRepository<Posts,Long> {
    @Query("SELECT p FROM Posts p WHERE p.hashTags LIKE '%:hashtag%'")
    List<Posts> getConsistsHashTag(@Param("hashtag") String hashtag);
    @Query("select p from Posts p ORDER BY p.creationDate")
    List<Posts> findAllSortedByDate();
}
