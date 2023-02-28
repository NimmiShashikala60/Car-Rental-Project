package lk.ijse.spring.service;

import lk.ijse.spring.dto.ViewScheduleDTO;

import java.util.ArrayList;

public interface ViewScheduleService {
    public void saveViewSchedule(ViewScheduleDTO dto);
    public void deleteViewSchedule(String Id);
    public void updateViewSchedule(ViewScheduleDTO dto);
    public ArrayList<ViewScheduleDTO>getAllViewSchedule();
}
