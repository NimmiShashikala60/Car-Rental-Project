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

public class VehicleRoutes {
    @Id
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
