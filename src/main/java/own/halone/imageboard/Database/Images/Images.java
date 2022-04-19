package own.halone.imageboard.Database.Images;

import own.halone.imageboard.Database.Posts.Posts;

import javax.persistence.*;

@Entity
@Table(name="images")
public class Images {
    @Id
    @GeneratedValue
    private long id;
    private String fileName;
    private Long size;
    private String ContentType;
    @Lob
    private byte[] bytes;
    @ManyToOne
    private Posts ownerPost;

    public Images() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getContentType() {
        return ContentType;
    }

    public void setContentType(String contentType) {
        ContentType = contentType;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public Posts getOwnerPost() {
        return ownerPost;
    }

    public void setOwnerPost(Posts ownerPost) {
        this.ownerPost = ownerPost;
    }
}
