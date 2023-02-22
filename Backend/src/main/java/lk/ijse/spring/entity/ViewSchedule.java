package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ViewSchedule {
    @Id
    private String schduleId;
    private String vehicleiId;
    private String driverId;
    private String userName;
    private LocalDate date;
    private LocalTime time;
}
