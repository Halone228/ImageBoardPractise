package own.halone.imageboard.Database.Users;

import own.halone.imageboard.Database.Posts.Posts;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Users_Table")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String password;
    private String username;
    private String email;
    private ROLES role;
    @OneToMany
    private List<Posts> ownPosts;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="users_likedPosts",
                joinColumns = @JoinColumn(name="user_id"),
                inverseJoinColumns = @JoinColumn(name="post_id"))
    private List<Posts> likedPosts;
    private boolean isEnabled;

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public Users() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ROLES getRole() {
        return role;
    }

    public void setRole(ROLES role) {
        this.role = role;
    }

    public List<Posts> getOwnPosts() {
        return ownPosts;
    }

    public void setOwnPosts(List<Posts> ownPosts) {
        this.ownPosts = ownPosts;
    }

    public List<Posts> getLikedPosts() {
        return likedPosts;
    }

    public void setLikedPosts(List<Posts> likedPosts) {
        this.likedPosts = likedPosts;
    }
    public void addPost(Posts post){
        this.ownPosts.add(post);
    }
}
