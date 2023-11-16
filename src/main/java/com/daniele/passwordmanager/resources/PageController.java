package com.daniele.passwordmanager.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("${password-manager-base-url}/login-page")
    public String login() {
        return "login-page";
    }

}
