package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@IdClass(BookingVehicle_PK.class)
public class BookingDetail {
    @Id
    private String bookingId;
    @Id
    private  String vehicleId;
    private String driverId;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH} )
    @JoinColumn(name = "bookingId", referencedColumnName = "bookingId", insertable = false, updatable = false)
    Booking booking;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH} )
    @JoinColumn(name = "vehicleId", referencedColumnName = "vehicleId", insertable = false, updatable = false)
    VehicleRoutes vehicleRoutes;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH} )
    @JoinColumn(name = "driverId", referencedColumnName = "driverId", insertable = false, updatable = false)
    Driver driver;

}
