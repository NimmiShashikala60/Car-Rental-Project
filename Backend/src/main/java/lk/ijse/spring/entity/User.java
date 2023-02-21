package lk.ijse.spring.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class User {
        @Id
        private String UserNic;
        private String Name;
        private String Password;
        private String Email;
        private String Contact;
        private String Address;



    }

