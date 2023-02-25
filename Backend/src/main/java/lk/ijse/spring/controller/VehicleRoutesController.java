package lk.ijse.spring.controller;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.VehicleRoutesDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.entity.VehicleRoutes;
import lk.ijse.spring.repo.AdminRepo;
import lk.ijse.spring.repo.VehicleRoutesRepo;
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
    private ModelMapper mapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveVehicleRoutes(@ModelAttribute VehicleRoutesDTO dto) {
        System.out.println(dto.toString());
        if (repo.existsById(dto.getVehicleId())) {
            throw new RuntimeException("Vehicle Already exist");
            //mapper.map(dto,Admin.class);
        }
        VehicleRoutes map = mapper.map(dto, VehicleRoutes.class);
        repo.save(map);

        VehicleRoutes vehicleRoutes = new VehicleRoutes(dto.getVehicleId(), dto.getVehicleName(), dto.getVehicleBrand(), dto.getVehicleType(), dto.getOccupied(), dto.getTransmissionType(), dto.getFuelType(), dto.getDailyRate(), dto.getMonthlyRate());
        repo.save(vehicleRoutes);
        return new ResponseUtil("OK", "Successfully Registered!", null);

    }

    @GetMapping
    public ResponseUtil getAllVehicleRoutes() {
        List<VehicleRoutes> all = repo.findAll();
        ArrayList<VehicleRoutesDTO> allList = mapper.map(all, new TypeToken<ArrayList<VehicleRoutesDTO>>() {
        }.getType());
        return new ResponseUtil("ok", "Successfully  :", allList);
    }

    @PutMapping
    public ResponseUtil updateVehicleRoutes(@RequestBody VehicleRoutesDTO dto) {
        System.out.println(dto);
        if (!repo.existsById(dto.getVehicleId())) {
            throw new RuntimeException("Vehicle doesn't exist");
        }
        VehicleRoutes map = mapper.map(dto, VehicleRoutes.class);
        repo.save(map);

        VehicleRoutes vehicleRoutes = new VehicleRoutes(dto.getVehicleId(), dto.getVehicleName(), dto.getVehicleBrand(), dto.getVehicleType(), dto.getOccupied(), dto.getTransmissionType(), dto.getFuelType(), dto.getDailyRate(), dto.getMonthlyRate());
        repo.save(vehicleRoutes);

        return new ResponseUtil("OK", "Successfully Updated!", null);
    }

    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteVehicleRoutes(@RequestParam String id) {
        repo.deleteById(id);
        return new ResponseUtil("OK", "Successfully Deleted!", null);
    }

}
