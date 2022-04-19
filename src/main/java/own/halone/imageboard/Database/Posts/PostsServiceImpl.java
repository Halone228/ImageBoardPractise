package own.halone.imageboard.Database.Posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class PostsServiceImpl implements PostsServiceInt{
    @Autowired
    private PostsDAO postsDAO;
    @Autowired
    private PostsPaginRepository paginRepository;
    @Override
    public List<Posts> getAll() {
        return postsDAO.findAllSortedByDate();
    }
    @Override
    public List<Posts> sortedByHashTag(String hashTag) {
        return postsDAO.getConsistsHashTag(hashTag);
    }
    @Override
    public List<Posts> getByPage(Pageable page) {
        return paginRepository.findAll(page).toList();
    }
}
