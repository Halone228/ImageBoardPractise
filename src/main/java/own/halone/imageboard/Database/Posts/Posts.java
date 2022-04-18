package own.halone.imageboard.Database.Posts;

import own.halone.imageboard.Database.Comments.Comments;
import own.halone.imageboard.Database.Images.Images;
import own.halone.imageboard.Database.Users.Users;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Posts_Table")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;
    private String title;
    private String hashTags;
    @ManyToOne
    private Users owner;
    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "likedPosts")
    private List<Users> likedBy;
    @OneToMany
    private List<Images> images;
    public Posts() {
    }
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @OneToMany
    private List<Comments> comments;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHashTags() {
        return hashTags;
    }

    public void setHashTags(String hashTags) {
        this.hashTags = hashTags;
    }

    public Users getOwner() {
        return owner;
    }

    public void setOwner(Users Owner) {
        owner = Owner;
    }

    public List<Users> getLikedBy() {
        return likedBy;
    }

    public void setLikedBy(List<Users> likedBy) {
        this.likedBy = likedBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }


    @PrePersist
    void init(){
        this.creationDate = new Date();
    }
    public void setDefaults(String description, String hashTags, Users owner, List<Users> likedBy, List<Images> images) {
        this.description = description;
        this.hashTags = hashTags;
        this.owner = owner;
        this.likedBy = likedBy;
        this.images = images;
    }
}
