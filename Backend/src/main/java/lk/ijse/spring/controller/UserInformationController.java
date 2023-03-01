package lk.ijse.spring.controller;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.repo.AdminRepo;
import lk.ijse.spring.repo.UserRepo;
import lk.ijse.spring.service.DriverInformationService;
import lk.ijse.spring.service.UserInformationService;
import lk.ijse.spring.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserInformationController {
    @Autowired
    private UserInformationService service;
    @Autowired
    private UserRepo repo;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveUser(@RequestParam String userNic, @ModelAttribute UserDTO dto){
      service.saveUser(dto);
        System.out.println(userNic);
        return new ResponseUtil("OK","Successfully Registered!",null);

    }
    @GetMapping
    public ResponseUtil getAllUser(){
        return new ResponseUtil("ok","Successfully  :", service.getAllUser());
    }

    @PutMapping
    public ResponseUtil updateUser(@RequestBody UserDTO dto){
        service.updateUser(dto);
        return new ResponseUtil("OK","Successfully Updated!",null);
    }

    @DeleteMapping(params = {"Nic"})
    public ResponseUtil deleteUser(@RequestParam String Nic){
        //repo.deleteById(Nic);
        service.deleteUser(Nic);
        return new ResponseUtil("OK","Successfully Deleted!",null);
    }
}
