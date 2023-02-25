package lk.ijse.spring.controller;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.repo.AdminRepo;
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
    private AdminRepo repo;

    @Autowired
    private ModelMapper mapper;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveAdmin(@ModelAttribute AdminDTO dto){
        System.out.println(dto.toString());
        if (repo.existsById(dto.getId())){
            throw new RuntimeException("Admin Already exist");
            //mapper.map(dto,Admin.class);
        }
        Admin map=mapper.map(dto,Admin.class);
        repo.save(map);

        Admin admin = new Admin(dto.getId(), dto.getName(), dto.getEmail(),dto.getPassword(), dto.getContactNumber());
        repo.save(admin);
        return new ResponseUtil("OK","Successfully Registered!",null);

    }
    @GetMapping
    public ResponseUtil getAllAdmin(){
        List<Admin> all = repo.findAll();
        ArrayList<AdminDTO>allList=mapper.map(all,new TypeToken<ArrayList<AdminDTO>>(){}.getType());
        return new ResponseUtil("ok","Successfully  :",allList);
    }

    @PutMapping
    public ResponseUtil updateAdmin(@RequestBody AdminDTO dto){
        System.out.println(dto);
        if (!repo.existsById(dto.getId())){
            throw new RuntimeException("Admin doesn't exist");
        }
        Admin map=mapper.map(dto,Admin.class);
        repo.save(map);

        Admin admin = new Admin(dto.getId(), dto.getName(), dto.getEmail(), dto.getPassword(), dto.getContactNumber());
        repo.save(admin);

        return new ResponseUtil("OK","Successfully Updated!",null);
    }

    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteAdmin(@RequestParam String id){
        repo.deleteById(id);
        return new ResponseUtil("OK","Successfully Deleted!",null);
    }


}
