package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.VehicleRoutesDTO;
import lk.ijse.spring.entity.VehicleRoutes;
import lk.ijse.spring.repo.VehicleRoutesRepo;
import lk.ijse.spring.service.VehicleRoutesService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VehicleRoutesServiceImpl implements VehicleRoutesService {
    @Autowired
    private VehicleRoutesRepo repo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public void saveVehicleRoutes(VehicleRoutesDTO dto) {
        System.out.println(dto.toString());
        if (repo.existsById(dto.getVehicleId())) {
            throw new RuntimeException("Vehicle Already exist");
            //mapper.map(dto,Admin.class);
        }
        VehicleRoutes map = mapper.map(dto, VehicleRoutes.class);
        repo.save(map);

        VehicleRoutes vehicleRoutes = new VehicleRoutes(dto.getVehicleId(), dto.getVehicleName(), dto.getVehicleBrand(), dto.getVehicleType(), dto.getOccupied(), dto.getTransmissionType(), dto.getColor(), dto.getFuelType(), dto.getDailyRate(), dto.getMonthlyRate());
        repo.save(vehicleRoutes);
    }

    @Override
    public void deleteVehicleRoutes(String Id) {
        repo.deleteById(Id);
    }

    @Override
    public void updateVehicleRoutes(VehicleRoutesDTO dto) {
        System.out.println(dto);
        if (!repo.existsById(dto.getVehicleId())) {
            throw new RuntimeException("Vehicle doesn't exist");
        }
        VehicleRoutes map = mapper.map(dto, VehicleRoutes.class);
        repo.save(map);

        VehicleRoutes vehicleRoutes = new VehicleRoutes(dto.getVehicleId(), dto.getVehicleName(), dto.getVehicleBrand(), dto.getVehicleType(), dto.getOccupied(), dto.getTransmissionType(), dto.getColor(), dto.getFuelType(), dto.getDailyRate(), dto.getMonthlyRate());
        repo.save(vehicleRoutes);

    }

    @Override
    public ArrayList<VehicleRoutesDTO> getAllVehicleRoutes() {
        List<VehicleRoutes> all = repo.findAll();
        return  mapper.map(all, new TypeToken<ArrayList<VehicleRoutesDTO>>() {}.getType());

    }
}
