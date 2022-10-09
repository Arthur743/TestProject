package myproject.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {

    public StartController(){}

    @GetMapping("/")
    public String showStartPage() {
        return "start";
    }
}
