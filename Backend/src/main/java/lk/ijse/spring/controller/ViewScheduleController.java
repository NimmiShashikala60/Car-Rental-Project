package lk.ijse.spring.controller;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.ViewScheduleDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.entity.ViewSchedule;
import lk.ijse.spring.repo.AdminRepo;
import lk.ijse.spring.repo.ViewScheduleRepo;
import lk.ijse.spring.service.ViewScheduleService;
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
    private ViewScheduleService service;

//    @Autowired
//    private ViewScheduleRepo repo;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveViewSchedule(@ModelAttribute ViewScheduleDTO dto){
        service.saveViewSchedule(dto);
        return new ResponseUtil("OK","Successfully Registered!",null);

    }
    @GetMapping
    public ResponseUtil getAllViewSchedule(){
        return new ResponseUtil("ok","Successfully  :", service.getAllViewSchedule());
    }

    @PutMapping
    public ResponseUtil updateViewSchedule(@RequestBody ViewScheduleDTO dto){
        service.updateViewSchedule(dto);

        return new ResponseUtil("OK","Successfully Updated!",null);
    }

    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteViewSchedule(@RequestParam String id){
        service.deleteViewSchedule(id);
        return new ResponseUtil("OK","Successfully Deleted!",null);
    }

}
