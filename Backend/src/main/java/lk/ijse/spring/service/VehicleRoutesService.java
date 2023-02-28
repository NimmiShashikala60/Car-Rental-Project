package lk.ijse.spring.service;

import lk.ijse.spring.dto.VehicleRoutesDTO;

import java.util.ArrayList;

public interface VehicleRoutesService {
    public void saveVehicleRoutes(VehicleRoutesDTO dto);
    public void deleteVehicleRoutes(String Id);
    public void updateVehicleRoutes(VehicleRoutesDTO dto);
    public ArrayList<VehicleRoutesDTO> getAllVehicleRoutes();
}
