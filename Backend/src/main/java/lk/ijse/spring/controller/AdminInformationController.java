package lk.ijse.spring.controller;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.repo.AdminRepo;
import lk.ijse.spring.service.AdminService;
import lk.ijse.spring.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminInformationController {
    @Autowired
    private AdminService service;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveAdmin(@ModelAttribute AdminDTO dto){
        service.saveAdmin(dto);
        return new ResponseUtil("OK","Successfully Registered!",null);

    }
    @GetMapping
    public ResponseUtil getAllAdmin(){
        return new ResponseUtil("ok","Successfully  :",service.getAllAdmin());
    }

    @PutMapping
    public ResponseUtil updateAdmin(@RequestBody AdminDTO dto){
         service.updateAdmin(dto);
        return new ResponseUtil("OK","Successfully Updated!",null);
    }

    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteAdmin(@RequestParam String id){
        service.deleteAdmin(id);
        return new ResponseUtil("OK","Successfully Deleted!",null);
    }


}
