package own.halone.imageboard.Database.Users;

import org.springframework.beans.factory.annotation.Autowired;
import own.halone.imageboard.Database.Posts.Posts;

import java.util.List;

public class UserServiceImpl implements UserServiceInt{
    @Autowired
    private UsersDAO usersDAO;
    @Override
    public Users getById(long id) {
        return usersDAO.getById(id);
    }

    @Override
    public List<Users> getAll() {
        return usersDAO.findAll();
    }
}
