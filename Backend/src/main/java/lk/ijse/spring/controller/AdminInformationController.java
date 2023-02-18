package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping()
public class AdminInformationController {

    @GetMapping
    public void Customer(){
        System.out.println("get invoked");
    }
}
