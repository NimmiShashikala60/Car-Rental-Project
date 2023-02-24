package lk.ijse.spring.controller;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.DailySummeryDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.entity.DailySummery;
import lk.ijse.spring.repo.AdminRepo;
import lk.ijse.spring.repo.DailySummeryRepo;
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
@RequestMapping("/summery")
public class DailySummeryController {
    @Autowired
    private DailySummeryRepo repo;

    @Autowired
    private ModelMapper mapper;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveDailySummery(@ModelAttribute DailySummeryDTO dto){
        System.out.println(dto.toString());
        if (repo.existsById(dto.getSummeryId())){
            throw new RuntimeException("Summery Already exist");
            //mapper.map(dto,Admin.class);
        }
        DailySummery map=mapper.map(dto,DailySummery.class);
        repo.save(map);

        DailySummery dailySummery = new DailySummery(dto.getSummeryId(), dto.getUserName(), dto.getVehicleId(), dto.getDriverName(), dto.getOccupied(), dto.getActiveDay(), dto.getReservedDay());
        repo.save(dailySummery);
        return new ResponseUtil("OK","Successfully Registered!",null);

    }
    @GetMapping
    public ResponseUtil getAllAdmin(){
        List<DailySummery> all = repo.findAll();
        ArrayList<DailySummeryDTO> allList=mapper.map(all,new TypeToken<ArrayList<DailySummeryDTO>>(){}.getType());
        return new ResponseUtil("ok","Successfully  :",allList);
    }

    @PutMapping
    public ResponseUtil updateDailySummery(@RequestBody DailySummeryDTO dto){
        System.out.println(dto);
        if (!repo.existsById(dto.getSummeryId())){
            throw new RuntimeException("DailySummery doesn't exist");
        }
        DailySummery map=mapper.map(dto,DailySummery.class);
        repo.save(map);

        DailySummery dailySummery = new DailySummery(dto.getSummeryId(), dto.getUserName(), dto.getVehicleId(), dto.getDriverName(),dto.getOccupied(),dto.getActiveDay(), dto.getReservedDay());
        repo.save(dailySummery);

        return new ResponseUtil("OK","Successfully Updated!",null);
    }

    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteAdmin(@RequestParam String id){
        repo.deleteById(id);
        return new ResponseUtil("OK","Successfully Deleted!",null);
    }

}
