package de.langomatisch.test.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping("/account/get")
    public @ResponseBody
    Account getAccount(@RequestParam(value = "id", defaultValue = "-1") int id) {
        Optional<Account> byId = accountRepository.findById(id);
        return byId.orElse(null);
    }

    @RequestMapping("/account/add")
    public @ResponseBody
    String addAccount(@RequestParam(value = "email") String email, @RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        if (email == null || email.isEmpty()) return "no email";
        Account account = new Account();
        account.setEmail(email);
        account.setPassword(password);
        account.setUsername(username);
        accountRepository.save(account);
        return "success";
    }

}
