package id.putra.movierspticket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("admin")
public class AdminController {
    @GetMapping("")
    public String admin(@RequestParam(name = "view", required = false, defaultValue = "") String view) {
        return "admin/index";
    }
}
