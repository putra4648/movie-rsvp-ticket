package id.putra.movierspticket.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/redirect")
    public String redirect(Authentication authentication) {
        var authorities = authentication.getAuthorities().stream().map(authority -> authority.getAuthority()).toList();
        if (authorities.contains("ROLE_USER")) {
            return "redirect:/user";
        }
        if (authorities.contains("ROLE_ADMIN")) {
            return "redirect:/admin";
        }
        return "error";
    }

    @GetMapping("/unknown")
    public String unknown() {
        return "unknown";
    }

}
