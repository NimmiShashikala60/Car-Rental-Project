package lk.ijse.spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UserDTO {

        private String userNic;
        private String name;
        private String password;
        private String email;
        private String address;
        private String contact;


    }
