package de.langomatisch.test.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/user/get")
    public @ResponseBody
    User getUser(@RequestParam(value = "id", defaultValue = "-1") int id) {
        Optional<User> byId = userRepository.findById(id);
        return byId.orElse(null);
    }

    @RequestMapping("/user/add")
    public @ResponseBody
    String addUser(@RequestParam(value = "name") String name) {
        if (name == null || name.isEmpty()) {
            return "no name";
        }
        User user = new User();
        user.setName(name);
        user.setGold(0);
        user.setLevel(1);
        user.setRubies(0);
        user.setXp(0);
        userRepository.save(user);
        return "success";
    }

}
