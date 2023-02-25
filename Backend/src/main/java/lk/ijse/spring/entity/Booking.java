package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Booking {

    @Id
    private String bookingId;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH} )
    @JoinColumn(name = "userNic", referencedColumnName = "userNic", nullable = false)
    private User userId;
    private BigDecimal cost;
    private LocalDate date;
    private LocalTime time;

}
