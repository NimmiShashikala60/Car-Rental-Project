package lk.ijse.spring.service;

import lk.ijse.spring.dto.DailySummeryDTO;
import lk.ijse.spring.entity.DailySummery;

import java.util.ArrayList;

public interface DailySummeryService {
    public void saveDailySummery(DailySummeryDTO dto);
    public void deleteDailySummery(String Id);
    public void updateDailySummery(DailySummeryDTO dto);
    public ArrayList<DailySummeryDTO> getAllDailySummery();
}
