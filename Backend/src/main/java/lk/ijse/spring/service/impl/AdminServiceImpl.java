package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.repo.AdminRepo;
import lk.ijse.spring.service.AdminService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional

public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepo repo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public void saveAdmin(AdminDTO dto) {
        System.out.println(dto.toString());
        if (repo.existsById(dto.getId())){
            throw new RuntimeException("Admin Already exist");
            //mapper.map(dto,Admin.class);
        }
        Admin map=mapper.map(dto,Admin.class);
        repo.save(map);

        Admin admin = new Admin(dto.getId(), dto.getName(), dto.getEmail(),dto.getPassword(), dto.getContact());
        repo.save(admin);

    }

    @Override
    public void deleteAdmin(String Id) {
        repo.deleteById(Id);

    }

    @Override
    public void updateAdmin(AdminDTO dto) {
        System.out.println(dto);
        if (!repo.existsById(dto.getId())){
            throw new RuntimeException("Admin doesn't exist");
        }
        Admin map=mapper.map(dto,Admin.class);
        repo.save(map);

        Admin admin = new Admin(dto.getId(), dto.getName(), dto.getEmail(), dto.getPassword(), dto.getContact());
        repo.save(admin);

    }

    @Override
    public ArrayList<AdminDTO> getAllAdmin() {
        List<Admin> all = repo.findAll();
       return mapper.map(all,new TypeToken<ArrayList<AdminDTO>>(){}.getType());
    }
}
