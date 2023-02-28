package lk.ijse.spring.controller;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.service.DriverInformationService;
import lk.ijse.spring.util.ResponseUtil;
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
    private DriverInformationService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveDriver(@ModelAttribute DriverDTO dto){
        service.saveDriver(dto);
//        Driver driver = new Driver(dto.getDriverId(), dto.getDriverName(), dto.getDriverAddress(), dto.getDriverContact(),dto.getDriverSalary());
//       repo.save(driver);
        return new ResponseUtil("OK","Successfully Registered!",null);

    }
    @GetMapping
    public ResponseUtil getAllDriver(){
        return new ResponseUtil("ok","Successfully  :", service.getAllDriver());
    }

    @PutMapping
    public ResponseUtil updateDriver(@RequestBody DriverDTO dto){
        service.updateDriver(dto);
//        Driver driver = new Driver(dto.getDriverId(), dto.getDriverName(), dto.getDriverAddress(), dto.getDriverContact(), dto.getDriverSalary());
//        repo.save(driver);

        return new ResponseUtil("OK","Successfully Updated!",null);
    }

    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteDriver(@RequestParam String id){
        service.deleteDriver(id);
        repo.deleteById(id);
        return new ResponseUtil("OK","Successfully Deleted!",null);
    }

    @GetMapping(path = "/getById")
    public ResponseUtil getDriverById(@RequestParam String driverId){
        //repo.deleteById(id);
        ;
        return new ResponseUtil("OK","Successfully Deleted!",repo.findById(driverId).get());
    }

}