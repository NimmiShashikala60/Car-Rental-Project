package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.repo.UserRepo;
import lk.ijse.spring.service.DriverInformationService;
import lk.ijse.spring.service.UserInformationService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional

public class UserInformationServiceImpl implements UserInformationService {
    @Autowired
    private UserRepo repo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public void saveUser(UserDTO dto) {
        System.out.println(dto.toString());
     if (repo.existsById(dto.getUserNic())){
           throw new RuntimeException("User Already exist");
            //mapper.map(dto,Admin.class);
        }
        User map=mapper.map(dto, User.class);
        System.out.println(map);
        repo.save(map);

//        User user = new User(dto.getUserNic(), dto.getName(), dto.getPassword(), dto.getEmail(),dto.getAddress(),dto.getContact());
//        repo.save(user);
    }

    @Override
    public void deleteUser(String Nic) {
        repo.deleteById(Nic);

    }

    @Override
    public void updateUser(UserDTO dto) {
        System.out.println(dto);
        if (!repo.existsById(dto.getUserNic())){
            throw new RuntimeException("User doesn't exist");
        }
        User map=mapper.map(dto,User.class);
        repo.save(map);

        User user = new User(dto.getUserNic(), dto.getName(), dto.getPassword(), dto.getEmail(),dto.getAddress(), dto.getContact());
        repo.save(user);

    }

    @Override
    public ArrayList<UserDTO> getAllUser() {
        List<User> all = repo.findAll();
       return mapper.map(all,new TypeToken<ArrayList<UserDTO>>(){}.getType());
    }
}
