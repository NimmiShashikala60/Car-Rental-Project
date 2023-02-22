package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ViewScheduleDTO {
    private String schduleId;
    private String vehicleiId;
    private String driverId;
    private String userName;
    private String date;
    private String time;
}
