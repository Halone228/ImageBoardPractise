package own.halone.imageboard.Database.Posts;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class PostsServiceImpl implements PostsServiceInt{
    @Autowired
    private PostsDAO postsDAO;
    @Override
    public List<Posts> getAll() {
        return postsDAO.findAllSortedByDate();
    }

    @Override
    public List<Posts> sortedByHashTag(String hashTag) {
        return postsDAO.getConsistsHashTag(hashTag);
    }
}
