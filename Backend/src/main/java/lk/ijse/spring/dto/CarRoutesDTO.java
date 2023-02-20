package lk.ijse.spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CarRoutesDTO {
    private String id;
    private String brand;
    private String type;
    private String numOfPassenger;
    private String transmissiontype;
    private String fueltype;
    private String dailyRate;
    private String monthlyRate;


}
