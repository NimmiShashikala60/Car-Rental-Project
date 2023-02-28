package lk.ijse.spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class DailySummeryDTO {
    private String summeryId;
    private String userName;
    private String vehicleId;
    private String driverId;
    private String occupied;
    private String activeDay;
    private String reservedDay;
    private String reservedCar;


}
