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
    private String VehicleId;
    private String VehicleBrand;
    private String VehicleType;
    private String Occupied;
    private String TransmissionType;
    private String FuelType;
    private String DailyRate;
    private String MonthlyRate;


}
