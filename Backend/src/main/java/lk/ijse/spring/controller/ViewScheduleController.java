package lk.ijse.spring.controller;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.ViewScheduleDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.entity.ViewSchedule;
import lk.ijse.spring.repo.AdminRepo;
import lk.ijse.spring.repo.ViewScheduleRepo;
import lk.ijse.spring.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("schedule")
public class ViewScheduleController {
    @Autowired
    private ViewScheduleRepo repo;

    @Autowired
    private ModelMapper mapper;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveViewSchedule(@ModelAttribute ViewScheduleDTO dto){
        System.out.println(dto.toString());
        if (repo.existsById(dto.getScheduleId())){
            throw new RuntimeException("Admin Already exist");
            //mapper.map(dto,Admin.class);
        }
        ViewSchedule map=mapper.map(dto,ViewSchedule.class);
        repo.save(map);

        ViewSchedule viewSchedule = new ViewSchedule(dto.getScheduleId(), dto.getVehicleName(), dto.getDriverId(), dto.getUserName(),dto.getDate(),dto.getTime());
        repo.save(viewSchedule);
        return new ResponseUtil("OK","Successfully Registered!",null);

    }
    @GetMapping
    public ResponseUtil getAllViewSchedule(){
        List<ViewSchedule> all = repo.findAll();
        ArrayList<ViewScheduleDTO> allList=mapper.map(all,new TypeToken<ArrayList<ViewScheduleDTO>>(){}.getType());
        return new ResponseUtil("ok","Successfully  :",allList);
    }

    @PutMapping
    public ResponseUtil updateViewSchedule(@RequestBody ViewScheduleDTO dto){
        System.out.println(dto);
        if (!repo.existsById(dto.getScheduleId())){
            throw new RuntimeException("Schedule doesn't exist");
        }
        ViewSchedule map=mapper.map(dto,ViewSchedule.class);
        repo.save(map);

        ViewSchedule viewSchedule = new ViewSchedule(dto.getScheduleId(), dto.getVehicleName(), dto.getDriverId(), dto.getUserName(),dto.getDate(),dto.getTime());
        repo.save(viewSchedule);

        return new ResponseUtil("OK","Successfully Updated!",null);
    }

    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteViewSchedule(@RequestParam String id){
        repo.deleteById(id);
        return new ResponseUtil("OK","Successfully Deleted!",null);
    }

}
