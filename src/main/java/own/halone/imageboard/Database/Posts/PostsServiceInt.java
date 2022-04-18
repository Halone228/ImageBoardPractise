package own.halone.imageboard.Database.Posts;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface PostsServiceInt {
    List<Posts> getAll();
    List<Posts> sortedByHashTag(String hashTah);
    List<Posts> getByPage(Pageable page);

}
