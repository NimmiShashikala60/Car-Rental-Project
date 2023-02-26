package lk.ijse.spring.dto;

import lk.ijse.spring.entity.BookingDetail;
import lk.ijse.spring.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public class BookingDTO {

    private String bookingId;

    private UserDTO userId;
    private BigDecimal cost;
    private LocalDate date;
    private LocalTime time;


    List<BookingDetail> bookingDetails;

}
