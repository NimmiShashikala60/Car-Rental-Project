package lk.ijse.spring.controller;

import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.repo.AdminRepo;
import lk.ijse.spring.repo.UserRepo;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    AdminRepo adminRepo;

    @PostMapping
    public ResponseUtil login(@RequestParam String userNic, @RequestParam String password){
        User user = userRepo.findById(userNic).get();
        System.out.println(user);
        if (user.getPassword().equals(password)){
            return new ResponseUtil("Ok","Loaded","Correct");
        }else{
            return new ResponseUtil("Ok","Loaded","Wrong");
        }
//        return new ResponseUtil("OK","Successfully Login",false);

    }

    @PostMapping(path = "/admin")
    public ResponseUtil loginAdmin(@RequestParam String userNic, @RequestParam String password){
        Admin user = adminRepo.findById(userNic).get();
        System.out.println(user);
        if (user.getPassword().equals(password)){
            return new ResponseUtil("Ok","Loaded","Correct");
        }else{
            return new ResponseUtil("Ok","Loaded","Wrong");
        }
//        return new ResponseUtil("OK","Successfully Login",false);

    }

}
