package own.halone.imageboard.Database.Posts;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsPaginRepository extends PagingAndSortingRepository<Posts,Long> {
}
