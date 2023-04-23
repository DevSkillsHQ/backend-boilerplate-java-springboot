package co.devskills.springbootboilerplate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

import java.util.List;

@RestController
public class PingController {

    @GetMapping(value = "/ping")
    @ResponseStatus(HttpStatus.OK)
    public String healthCheck(){
        return "pong";
    }
}
