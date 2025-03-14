package id.putra.movierspticket.controller;

import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.putra.movierspticket.common.constant.UserRole;
import id.putra.movierspticket.entity.Role;
import id.putra.movierspticket.entity.User;
import id.putra.movierspticket.form.RegisterForm;
import id.putra.movierspticket.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("register")
    @Transactional
    public String registerUser(@ModelAttribute("register_form") RegisterForm form) {

        var user = new User();
        user.setUsername(form.getUsername());
        user.setPassword(passwordEncoder.encode(form.getPassword()));

        var role = new Role();
        role.setRole(UserRole.ROLE_USER);
        user.setRoles(Set.of(role));

        userRepository.persist(user);

        return "redirect:/login";
    }

    @GetMapping("register")
    public String registerPage(@ModelAttribute("register_form") RegisterForm form) {
        return "register";
    }

}
