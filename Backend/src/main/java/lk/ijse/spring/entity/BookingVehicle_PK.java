package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class BookingVehicle_PK implements Serializable {
    private String bookingId;
    private  String vehicleId;
}
