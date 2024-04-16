package nl.kick.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/open")
public class OpenController {

    @GetMapping(path = "", produces = "application/json")
    public String openGetMethod() {
        return "This API should always be reachable";
    }

}
