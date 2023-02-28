package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.DailySummeryDTO;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.service.DailySummeryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class DriverInformationServiceImpl implements DailySummeryService {
    @Autowired
    private DriverRepo repo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public void saveDailySummery(DailySummeryDTO dto) {
        System.out.println(dto.toString());
        if (repo.existsById(dto.getDriverId())){
            throw new RuntimeException("Driver Already exist");
            //mapper.map(dto,Admin.class);
        }
        Driver map=mapper.map(dto,Driver.class);
        repo.save(map);

    }

    @Override
    public void deleteDailySummery(String Id) {

    }

    @Override
    public void updateDailySummery(DailySummeryDTO dto) {

    }

    @Override
    public ArrayList<DailySummeryDTO> getAllDailySummery() {
        return null;
    }
}
