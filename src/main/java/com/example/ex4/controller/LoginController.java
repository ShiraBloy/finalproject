package com.example.ex4.controller;

import com.example.ex4.repo.User;
import com.example.ex4.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    private Map<String,String> sessions = new HashMap<>();

@Autowired
private UserRepository userRepository;

@GetMapping("/")
    public String main(Model model, HttpSession session){
        session.removeAttribute("email");
        session.removeAttribute("pswd");
        session.removeAttribute("error");

        return"login";
    }

@RequestMapping("/login")
    public String postWithParam(@RequestParam(name = "email", required = false) String email,@RequestParam(name = "pswd", required = false) String password, Model model, HttpSession session) {
        if (email != null && password!=null){

            email = email.trim();
            password = password.trim();

            session.setAttribute("mail", email);
            session.setAttribute("pswd", password);

            List<User> byEmail = userRepository.findByEmail(email);
            if (byEmail.isEmpty()){
                model.addAttribute("isempty", "false");
                return "login";
            }
            List<User> byPswd = userRepository.findByPswd(password);
            System.out.println(byPswd);

            System.out.println("result: "+ byEmail);
            System.out.println(email + " " + password);

            return "openpage";
        }else {
            session.setAttribute("error", "the name is not valid, pls try again.");
            return "login";
        }
}

}
