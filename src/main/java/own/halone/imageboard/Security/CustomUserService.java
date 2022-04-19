package own.halone.imageboard.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import own.halone.imageboard.Database.Users.ROLES;
import own.halone.imageboard.Database.Users.Users;
import own.halone.imageboard.Database.Users.UsersDAO;

import javax.persistence.EntityExistsException;
import java.util.List;

@Service
public class CustomUserService implements UserDetailsService {
    private final UsersDAO usersDAO;
    private final PasswordEncoder passwordEncoder;

    public CustomUserService(UsersDAO usersDAO, PasswordEncoder passwordEncoder) {
        this.usersDAO = usersDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUserPrincipal userPrincipal = new CustomUserPrincipal(usersDAO.findByUsername(username));
        return userPrincipal;
    }
    public boolean saveUser(Users user) throws EntityExistsException {
        if ((usersDAO.findByUsername(user.getUsername()) != null) && (usersDAO.findByEmail(user.getEmail())!= null)) {
            return false;
        }
        user.setRole(ROLES.USER);
        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersDAO.save(user);
        return true;
    }
}
