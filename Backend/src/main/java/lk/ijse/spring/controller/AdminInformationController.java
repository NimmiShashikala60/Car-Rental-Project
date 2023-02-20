package lk.ijse.spring.controller;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminInformationController {


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveAdmin(@ModelAttribute AdminDTO dto){
        System.out.println(dto.toString());
        return new ResponseUtil("OK","Successfully Registered!",null);
    }

    @PutMapping
    public ResponseUtil updateAdmin(@RequestBody AdminDTO adminDTO){
        System.out.println(adminDTO);
        return new ResponseUtil("OK","Successfully Updated!",null);
    }

    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteAdmin(@ModelAttribute String id){
        System.out.println("Deleted");
        return new ResponseUtil("OK","Successfully Deleted!",null);
    }

}
