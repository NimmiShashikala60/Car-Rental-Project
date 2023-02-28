package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.DailySummeryDTO;
import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.service.DailySummeryService;
import lk.ijse.spring.service.DriverInformationService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional

public class DriverInformationServiceImpl implements DriverInformationService {
    @Autowired
    private DriverRepo repo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public void saveDriver(DriverDTO dto) {
        System.out.println(dto.toString());
        if (repo.existsById(dto.getDriverId())){
            throw new RuntimeException("Driver Already exist");
            //mapper.map(dto,Admin.class);
        }
        Driver map=mapper.map(dto,Driver.class);
        repo.save(map);

    }

    @Override
    public void deleteDriver(String Id) {
        repo.deleteById(Id);

    }

    @Override
    public void updateDriver(DriverDTO dto) {
        System.out.println(dto);
        if (!repo.existsById(dto.getDriverId())){
            throw new RuntimeException("Driver doesn't exist");
        }
        Driver map=mapper.map(dto,Driver.class);
        repo.save(map);

//        Driver driver = new Driver(dto.getDriverId(), dto.getDriverName(), dto.getDriverAddress(), dto.getDriverContact(), dto.getDriverSalary());
//        repo.save(driver);

    }

    @Override
    public ArrayList<DriverDTO> getAllDriver() {
        List<Driver> all = repo.findAll();
       return mapper.map(all,new TypeToken<ArrayList<DriverDTO>>(){}.getType());
    }
}
