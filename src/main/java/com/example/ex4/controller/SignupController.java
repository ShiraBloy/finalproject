package com.example.ex4.controller;

import com.example.ex4.repo.User;
import com.example.ex4.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SignupController {

@Autowired
private UserRepository userRepository;


@GetMapping("/signUp")
    public String newuser(Model model, HttpSession session) {return "signUp";}

@PostMapping("/signUp")
public String signUpFormParam(@RequestParam(name = "email", required = false) String email, @RequestParam(name = "name", required = false )String nameOfUser,
                              @RequestParam(name = "id", required = false) String id,@RequestParam(name = "hmo", required = false)String hmo,
                              @RequestParam(name = "pswd", required = false) String password, @RequestParam(name = "rpswd", required = false) String repassword, Model model, HttpSession session) {



    email = email.trim();
    nameOfUser = nameOfUser.trim();
    id = id.trim();
    hmo = hmo.trim();
    password = password.trim();
    repassword = repassword.trim();

    session.setAttribute("email", email);
    session.setAttribute("name", nameOfUser);
    session.setAttribute("id", id);
    session.setAttribute("hmo", hmo);
    session.setAttribute("password", password);
    session.setAttribute("repassword", repassword);


        User user = new User(email, nameOfUser, id, hmo, password);
        userRepository.save(user);
        System.out.println(email + "  name: " + nameOfUser + "  id: " + id + "  hmo: " + hmo + "  pswd: " + password + "  re: " + repassword);

        return "login";

    }
}


