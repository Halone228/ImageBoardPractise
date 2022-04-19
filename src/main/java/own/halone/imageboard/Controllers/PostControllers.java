package own.halone.imageboard.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import own.halone.imageboard.Database.Posts.Posts;
import own.halone.imageboard.Database.Posts.PostsServiceImpl;
import own.halone.imageboard.Database.Users.Users;
import own.halone.imageboard.Security.CustomUserService;

import java.util.List;
//TODO: Make security
@RestController
public class PostControllers {
    private PostsServiceImpl postsService;
    private CustomUserService userService;
    public PostControllers(PostsServiceImpl postsService, CustomUserService userService) {
        this.postsService = postsService;
        this.userService = userService;
    }
    @PostMapping("/")
    private List<Posts> getPostPagin(@RequestParam(name = "p",defaultValue = "0") int page){
        Pageable pages = PageRequest.of(page,10);
        List<Posts> postsList = postsService.getByPage(pages);
        return postsList;
    }
    @PostMapping("/register")
    private RedirectView registrationPost(@Validated @ModelAttribute Users user, BindingResult result){
        if (result.hasErrors()){
            return new RedirectView("/register?error=1");
        } else {
            boolean error = userService.saveUser(user);
            if (!error){
                return new RedirectView("/register?error=2");
            }
        }
        return new RedirectView("/login");
    }
}
