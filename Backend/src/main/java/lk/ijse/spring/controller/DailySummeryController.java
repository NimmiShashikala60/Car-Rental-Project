package lk.ijse.spring.controller;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.DailySummeryDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.entity.DailySummery;
import lk.ijse.spring.repo.AdminRepo;
import lk.ijse.spring.repo.DailySummeryRepo;
import lk.ijse.spring.service.AdminService;
import lk.ijse.spring.service.DailySummeryService;
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
    private DailySummeryService service;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveDailySummery(@ModelAttribute DailySummeryDTO dto){
       service.saveDailySummery(dto);
        return new ResponseUtil("OK","Successfully Registered!",null);

    }
    @GetMapping
    public ResponseUtil getAllDailySummery(){
        return new ResponseUtil("ok","Successfully  :", service.getAllDailySummery());
    }

    @PutMapping
    public ResponseUtil updateDailySummery(@RequestBody DailySummeryDTO dto){
        service.updateDailySummery(dto);

        return new ResponseUtil("OK","Successfully Updated!",null);
    }

    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteDailySummery(@RequestParam String id){
        service.deleteDailySummery(id);
        return new ResponseUtil("OK","Successfully Deleted!",null);
    }

}
