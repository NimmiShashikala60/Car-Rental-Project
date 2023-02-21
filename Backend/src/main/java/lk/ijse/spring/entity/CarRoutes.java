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

public class CarRoutes {
    @Id
    private String VehicleId;
    private String VehicleBrand;
    private String VehicleType;
    private String Occupied;
    private String TransmissionType;
    private String FuelType;
    private String DailyRate;
    private String MonthlyRate;
}
