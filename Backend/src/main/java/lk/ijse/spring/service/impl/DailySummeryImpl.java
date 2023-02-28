package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.DailySummeryDTO;
import lk.ijse.spring.repo.DailySummeryRepo;
import lk.ijse.spring.service.DailySummeryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional

public class DailySummeryImpl implements DailySummeryService {
    @Autowired
    private DailySummeryRepo repo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public void saveDailySummery(DailySummeryDTO dto) {
        System.out.println(dto.toString());
        if (repo.existsById(dto.getSummeryId())){
            throw new RuntimeException("Summery Already exist");
            //mapper.map(dto,Admin.class);
        }
        lk.ijse.spring.entity.DailySummery map=mapper.map(dto, lk.ijse.spring.entity.DailySummery.class);
        repo.save(map);

        lk.ijse.spring.entity.DailySummery dailySummery = new lk.ijse.spring.entity.DailySummery(dto.getSummeryId(), dto.getUserName(), dto.getVehicleId(), dto.getDriverId(), dto.getOccupied(), dto.getActiveDay(), dto.getReservedDay(), dto.getReservedCar());
        repo.save(dailySummery);
    }

    @Override
    public void deleteDailySummery(String Id) {
        repo.deleteById(Id);

    }

    @Override
    public void updateDailySummery(DailySummeryDTO dto) {
        System.out.println(dto);
        if (!repo.existsById(dto.getSummeryId())){
            throw new RuntimeException("DailySummery doesn't exist");
        }
        lk.ijse.spring.entity.DailySummery map=mapper.map(dto, lk.ijse.spring.entity.DailySummery.class);
        repo.save(map);

        lk.ijse.spring.entity.DailySummery dailySummery = new lk.ijse.spring.entity.DailySummery(dto.getSummeryId(), dto.getUserName(), dto.getVehicleId(), dto.getDriverId(),dto.getOccupied(),dto.getActiveDay(), dto.getReservedDay(), dto.getReservedCar());
        repo.save(dailySummery);

    }

    @Override
    public ArrayList<DailySummeryDTO> getAllDailySummery() {
        List<lk.ijse.spring.entity.DailySummery> all = repo.findAll();
        return mapper.map(all,new TypeToken<ArrayList<DailySummeryDTO>>(){}.getType());
    }
}
