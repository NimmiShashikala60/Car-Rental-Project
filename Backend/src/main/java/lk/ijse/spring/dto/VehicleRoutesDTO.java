package lk.ijse.spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class VehicleRoutesDTO {
    private String vehicleId;
    private String vehicleName;
    private String vehicleBrand;
    private String vehicleType;
    private String occupied;
    private String transmissionType;
    private String color;
    private String fuelType;
    private String dailyRate;
    private String monthlyRate;


}
