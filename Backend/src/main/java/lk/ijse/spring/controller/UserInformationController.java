package lk.ijse.spring.controller;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.repo.UserRepo;
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
    private UserRepo repo;

    @Autowired
    private ModelMapper mapper;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveUser(@ModelAttribute UserDTO dto){
        System.out.println(dto.toString());
        if (repo.existsById(dto.getUserNic())){
            throw new RuntimeException("User Already exist");
            //mapper.map(dto,Admin.class);
        }
        User map=mapper.map(dto, User.class);
        repo.save(map);

//        User user = new User(dto.getUserNic(), dto.getName(), dto.getPassword(), dto.getEmail(),dto.getContact(),dto.getAddress());
//        repo.save(user);
        return new ResponseUtil("OK","Successfully Registered!",null);

    }
    @GetMapping
    public ResponseUtil getAllUser(){
        List<User> all = repo.findAll();
        ArrayList<UserDTO> allList=mapper.map(all,new TypeToken<ArrayList<UserDTO>>(){}.getType());
        return new ResponseUtil("ok","Successfully  :",allList);
    }

    @PutMapping
    public ResponseUtil updateUser(@RequestBody UserDTO dto){
        System.out.println(dto);
        if (!repo.existsById(dto.getUserNic())){
            throw new RuntimeException("User doesn't exist");
        }
        User map=mapper.map(dto,User.class);
        repo.save(map);

        User user = new User(dto.getUserNic(), dto.getName(), dto.getPassword(), dto.getEmail(), dto.getContact(), dto.getAddress());
        repo.save(user);

        return new ResponseUtil("OK","Successfully Updated!",null);
    }

    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteUser(@RequestParam String id){
        repo.deleteById(id);
        return new ResponseUtil("OK","Successfully Deleted!",null);
    }
}
