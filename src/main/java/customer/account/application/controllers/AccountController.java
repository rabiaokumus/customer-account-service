package customer.account.application.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer/account")
@RequiredArgsConstructor
public class AccountController {
    @GetMapping()
    private String get() {
        String test = "Hello World!";
        return test;
    }
}
