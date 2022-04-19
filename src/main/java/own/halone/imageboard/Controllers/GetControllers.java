package own.halone.imageboard.Controllers;

import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import own.halone.imageboard.Database.Posts.PostsPaginRepository;
import own.halone.imageboard.Database.Users.Users;
import own.halone.imageboard.Security.CustomUserPrincipal;

@Controller
public class GetControllers {
    private PostsPaginRepository paginRepository;

    public GetControllers(PostsPaginRepository paginRepository) {
        this.paginRepository = paginRepository;
    }
//Todo: Посмотреть что с авторизацией
    @GetMapping("/")
    private String mainView(Model model, @RequestParam(name = "page",
            defaultValue = "0",
            required = false) int page){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("items",paginRepository.findAll(PageRequest.of(page,10)));
        if(auth.getPrincipal() instanceof CustomUserPrincipal){
            CustomUserPrincipal userPrincipal = (CustomUserPrincipal) auth.getPrincipal();
            System.out.println(userPrincipal.toString());
            model.addAttribute("user",userPrincipal);
            model.addAttribute("isAuth",true);
        } else {
            model.addAttribute("isAuth",false);
        }
        return "index";
    }
    @GetMapping("/register")
    private String registerView(Model model){
        model.addAttribute("users",new Users());
        return "registration";
    }
}
