package own.halone.imageboard.Database.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class UserServiceImpl implements UserServiceInt{
    @Autowired
    private UsersDAO usersDAO;
    @Override
    public Users getById(long id) {
        return usersDAO.getById(id);
    }
    public List<Users> getAll() {
        return usersDAO.findAll();
    }
}
