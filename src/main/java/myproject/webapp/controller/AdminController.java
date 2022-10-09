package myproject.webapp.controller;

import myproject.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import myproject.service.abstracts.UserService;
import java.security.Principal;
import java.util.List;

@RequestMapping("/admin")
@Controller
public class AdminController {

    private final UserService userService;


    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String printAllUsers(ModelMap model, Principal principal) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        model.addAttribute("newUser", new User());
        model.addAttribute("activeUser", userService.getSpecificUser(principal.getName()));;
        return "users";
    }
}
