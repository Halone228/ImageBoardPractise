package own.halone.imageboard.Database.Users;

import own.halone.imageboard.Database.Posts.Posts;

import java.util.List;

public interface UserServiceInt {
    Users getById(long id);
    List<Users> getAll();

}
