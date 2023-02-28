package lk.ijse.spring.service;

import lk.ijse.spring.dto.AdminDTO;

import java.util.ArrayList;

public interface AdminService {
    public void saveAdmin(AdminDTO dto);
    public void deleteAdmin(String Id);
    public void updateAdmin(AdminDTO dto);
    public ArrayList<AdminDTO> getAllAdmin();
}
