package lk.ijse.spring.service;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.UserDTO;

import java.util.ArrayList;

public interface UserInformationService {
    public void saveUser(UserDTO dto);
    public void deleteUser(String Nic);
    public void updateUser(UserDTO dto);
    public ArrayList<UserDTO> getAllUser();
}
