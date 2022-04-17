package own.halone.imageboard.Database.Posts;

import java.util.List;

public interface PostsServiceInt {
    List<Posts> getAll();
    List<Posts> sortedByHashTag(String hashTah);

}
