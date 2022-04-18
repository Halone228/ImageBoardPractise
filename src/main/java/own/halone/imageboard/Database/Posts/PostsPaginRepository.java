package own.halone.imageboard.Database.Posts;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface PostsPaginRepository extends PagingAndSortingRepository<Posts,Long> {
}
