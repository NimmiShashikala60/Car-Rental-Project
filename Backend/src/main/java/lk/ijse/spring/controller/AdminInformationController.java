package lk.ijse.spring.controller;

import lk.ijse.spring.dto.AdminDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/Admin")
public class AdminInformationController {

    @PostMapping
    public void SaveCustomer(AdminDTO dto){
        System.out.println(dto.toString());
    }
}
