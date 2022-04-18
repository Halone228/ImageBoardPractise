package own.halone.imageboard.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import own.halone.imageboard.Database.Posts.Posts;
import own.halone.imageboard.Database.Posts.PostsServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostControllers {
    @Autowired
    private PostsServiceImpl postsService;
    @PostMapping("/")
    public List<Posts> getPostPagin(@RequestParam(name = "p",defaultValue = "0") int page){
        Pageable pages = PageRequest.of(page,10);
        List<Posts> postsList = postsService.getByPage(pages);
        return postsList;
    }
}
