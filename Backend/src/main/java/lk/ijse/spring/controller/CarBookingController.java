package lk.ijse.spring.controller;

import lk.ijse.spring.dto.BookingDTO;
import lk.ijse.spring.entity.Booking;
import lk.ijse.spring.entity.BookingDetail;
import lk.ijse.spring.repo.BookingRepo;
import lk.ijse.spring.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@CrossOrigin
@RequestMapping("/booking")
public class CarBookingController {

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    ModelMapper mapper;

    @PostMapping
    public ResponseUtil booking(@RequestBody Booking bookingDTO){

        String lastRentId = bookingRepo.getLastId();
        String id = lastRentId != null ? String.format("B%03d", (Integer.parseInt(lastRentId.replace("B", "")) + 1)) : "RID-001";
        bookingDTO.setBookingId(id);
        for (BookingDetail bookingDetail : bookingDTO.getBookingDetails()) {
            bookingDetail.setBookingId(id);
        }
        bookingDTO.setDate(LocalDate.now());
        bookingDTO.setTime(LocalTime.now());
        bookingRepo.save(bookingDTO);
        return new ResponseUtil("Ok","Successfully Added","");

    }

}
