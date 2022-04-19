package own.halone.imageboard.Database.Users;

import java.util.List;

public interface UserServiceInt {
    Users getById(long id);
    List<Users> getAll();

}
