package lk.ijse.spring.service;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.DriverDTO;

import java.util.ArrayList;

public interface DriverInformationService {
    public void saveDriver(DriverDTO dto);
    public void deleteDriver(String Id);
    public void updateDriver(DriverDTO dto);
    public ArrayList<DriverDTO> getAllDriver();
}
