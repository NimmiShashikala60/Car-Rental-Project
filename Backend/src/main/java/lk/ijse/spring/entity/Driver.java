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

public class Driver {
    @Id
    private String DriverId;

    private String DriverName;
    private String DriverAddress;
    private String DriverContact;
    private double DriverSalary;

}
