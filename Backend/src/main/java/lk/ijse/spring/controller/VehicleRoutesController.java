package lk.ijse.spring.controller;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.VehicleRoutesDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.entity.VehicleRoutes;
import lk.ijse.spring.repo.AdminRepo;
import lk.ijse.spring.repo.VehicleRoutesRepo;
import lk.ijse.spring.service.VehicleRoutesService;
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
@RequestMapping("/vehicle")
public class VehicleRoutesController {
    @Autowired
    private VehicleRoutesRepo repo;

    @Autowired
    private VehicleRoutesService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveVehicleRoutes(@ModelAttribute VehicleRoutesDTO dto) {
        service.saveVehicleRoutes(dto);
        return new ResponseUtil("OK", "Successfully Registered!", null);

    }

    @GetMapping
    public ResponseUtil getAllVehicleRoutes() {
        return new ResponseUtil("ok", "Successfully  :",  service.getAllVehicleRoutes());
    }

    @PutMapping
    public ResponseUtil updateVehicleRoutes(@RequestBody VehicleRoutesDTO dto) {
        service.updateVehicleRoutes(dto);
        return new ResponseUtil("OK", "Successfully Updated!", null);
    }

    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteVehicleRoutes(@RequestParam String id) {
        service.deleteVehicleRoutes(id);
        //repo.deleteById(id);
        return new ResponseUtil("OK", "Successfully Deleted!", null);
    }

    @GetMapping(path = "/getById")
    public ResponseUtil getVehicleById(@RequestParam String driverId){

        ;
        return new ResponseUtil("OK","Successfully Deleted!",repo.findById(driverId).get());
    }

}
