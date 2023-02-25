package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ViewScheduleDTO {
    private String scheduleId;
    private String vehicleName;
    private String driverId;
    private String userName;
    private String Date;
    private String Time;
}
