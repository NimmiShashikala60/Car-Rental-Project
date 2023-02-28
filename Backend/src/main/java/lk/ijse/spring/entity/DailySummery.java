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
public class DailySummery {
    @Id
    private String summeryId;
    private String userName;
    private String vehicleId;
    private String driverId;
    private String occupied;
    private String activeDay;
    private String reservedDay;
    private String reservedCar;


}
