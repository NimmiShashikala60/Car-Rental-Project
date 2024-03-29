package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class DriverDTO {
    private String DriverId;
    private String UserNic;
    private String DriverName;
    private String DriverAddress;
    private String DriverContact;
    private double DriverSalary;


}
