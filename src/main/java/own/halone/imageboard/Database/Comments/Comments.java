package own.halone.imageboard.Database.Comments;

import own.halone.imageboard.Database.Posts.Posts;
import own.halone.imageboard.Database.Users.Users;

import javax.persistence.*;

@Entity
@Table(name="comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    private Users fromUser;
    @ManyToOne
    private Posts ownerPost;
    private String text;
}
