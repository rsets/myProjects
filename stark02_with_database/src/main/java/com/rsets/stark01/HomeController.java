package com.rsets.stark01;

import com.rsets.stark01.models.User;
import com.rsets.stark01.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
public class HomeController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    HttpSession session;


    @GetMapping("/")
    public String home(Model model) {
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "home";
    }

    @GetMapping("/contacts")
    public String contacts(Model model) {
        return "contacts";
    }


    @PostMapping("/")
    public String mainPost(@RequestParam(required = false) Long id, String command, String firstName, String lastName, String faculty, String dateOfBirth, String age, Model model) {
        if ("remove".equals(command)) {
            try {
                userRepository.deleteById(id);
            } catch (Exception e) {

            }
        } else if ("add".equals(command)) {
            User user = new User(firstName, lastName, faculty, dateOfBirth, age);
            userRepository.save(user);
        } else if ("edit".equals(command)) {
            //Дописать код для редактирования
            //<input type="hidden" name="command" value="edit">
        }
        return home(model);
    }
}
