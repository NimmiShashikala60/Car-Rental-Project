package lk.ijse.spring.controller;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.repo.AdminRepo;
import lk.ijse.spring.util.ResponseUtil;
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
    private AdminRepo repo;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveAdmin(@ModelAttribute AdminDTO dto){
        System.out.println(dto.toString());
        if (repo.existsById(dto.getId())){
            throw new RuntimeException("Admin Already exist");
        }
        Admin admin = new Admin(dto.getId(), dto.getName(), dto.getEmail(), dto.getContact());
        repo.save(admin);
        return new ResponseUtil("OK","Successfully Registered!",null);

    }
    @GetMapping
    public ResponseUtil getAllAdmin(){
        List<Admin> all = repo.findAll();
        return new ResponseUtil("ok","Successfully  :",all);
    }

    @PutMapping
    public ResponseUtil updateAdmin(@RequestBody AdminDTO dto){
        System.out.println(dto);
        if (!repo.existsById(dto.getId())){
            throw new RuntimeException("Admin doesn't exist");
        }
        Admin admin = new Admin(dto.getId(), dto.getName(), dto.getEmail(), dto.getContact());
        repo.save(admin);

        return new ResponseUtil("OK","Successfully Updated!",null);
    }

    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteAdmin(@RequestParam String id){
        repo.deleteById(id);
        return new ResponseUtil("OK","Successfully Deleted!",null);
    }


}
