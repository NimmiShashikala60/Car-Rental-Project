package lk.ijse.spring.controller;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.repo.DriverRepo;
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
@RequestMapping("/driver")
public class DriverInformationController {
    @Autowired
    private DriverRepo repo;

    @Autowired
    private ModelMapper mapper;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveDriver(@ModelAttribute DriverDTO dto){
        System.out.println(dto.toString());
        if (repo.existsById(dto.getDriverId())){
            throw new RuntimeException("Driver Already exist");
            //mapper.map(dto,Admin.class);
        }
        Driver map=mapper.map(dto,Driver.class);
        repo.save(map);

//        Driver driver = new Driver(dto.getDriverId(), dto.getDriverName(), dto.getDriverAddress(), dto.getDriverContact(),dto.getDriverSalary());
//        repo.save(driver);
        return new ResponseUtil("OK","Successfully Registered!",null);

    }
    @GetMapping
    public ResponseUtil getAllDriver(){
        List<Driver> all = repo.findAll();
        ArrayList<DriverDTO> allList=mapper.map(all,new TypeToken<ArrayList<DriverDTO>>(){}.getType());
        return new ResponseUtil("ok","Successfully  :",allList);
    }

    @PutMapping
    public ResponseUtil updateDriver(@RequestBody DriverDTO dto){
        System.out.println(dto);
        if (!repo.existsById(dto.getDriverId())){
            throw new RuntimeException("Driver doesn't exist");
        }
        Driver map=mapper.map(dto,Driver.class);
        repo.save(map);

        Driver driver = new Driver(dto.getDriverId(), dto.getDriverName(), dto.getDriverAddress(), dto.getDriverContact(), dto.getDriverSalary());
        repo.save(driver);

        return new ResponseUtil("OK","Successfully Updated!",null);
    }

    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteDriver(@RequestParam String id){
        repo.deleteById(id);
        return new ResponseUtil("OK","Successfully Deleted!",null);
    }
}
