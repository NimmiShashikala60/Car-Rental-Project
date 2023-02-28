package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.VehicleRoutesDTO;
import lk.ijse.spring.dto.ViewScheduleDTO;
import lk.ijse.spring.entity.VehicleRoutes;
import lk.ijse.spring.entity.ViewSchedule;
import lk.ijse.spring.repo.ViewScheduleRepo;
import lk.ijse.spring.service.VehicleRoutesService;
import lk.ijse.spring.service.ViewScheduleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional

public class ViewScheduleServiceImpl implements ViewScheduleService {
    @Autowired
    private ViewScheduleRepo repo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public void saveViewSchedule(ViewScheduleDTO dto) {
        System.out.println(dto.toString());
        if (repo.existsById(dto.getScheduleId())){
            throw new RuntimeException("schedule Already exist");
            //mapper.map(dto, VehicleRoutes.class);
        }
        ViewSchedule map=mapper.map(dto,ViewSchedule.class);
        repo.save(map);

//        ViewSchedule viewSchedule = new ViewSchedule(dto.getScheduleId(), dto.getVehicleName(), dto.getDriverId(), dto.getUserName(),dto.getDate(),dto.getTime());
//        repo.save(viewSchedule);
    }

    @Override
    public void deleteViewSchedule(String Id) {
        repo.deleteById(Id);
    }

    @Override
    public void updateViewSchedule(ViewScheduleDTO dto) {
        System.out.println(dto);
//        if (!repo.existsById(dto.getScheduleId())){
//            throw new RuntimeException("Schedule doesn't exist");
//        }
        ViewSchedule map=mapper.map(dto,ViewSchedule.class);
        repo.save(map);

//        ViewSchedule viewSchedule = new ViewSchedule(dto.getScheduleId(), dto.getVehicleName(), dto.getDriverId(), dto.getUserName(),dto.getDate(),dto.getTime());
//        repo.save(viewSchedule);

    }

    @Override
    public ArrayList<ViewScheduleDTO> getAllViewSchedule() {
        List<ViewSchedule> all = repo.findAll();
        return mapper.map(all,new TypeToken<ArrayList<ViewScheduleDTO>>(){}.getType());
    }
}
