package own.halone.imageboard.Database.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDAO extends JpaRepository<Users,Long> {
    @Query("select u from Users u where u.username = :name")
    Users findByUsername(@Param("name") String name);
    @Query("select u from Users u where u.email = :email")
    Users findByEmail(@Param("email") String email);
}
