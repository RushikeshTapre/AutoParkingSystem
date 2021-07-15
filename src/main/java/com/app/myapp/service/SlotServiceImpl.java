package com.app.myapp.service;
import com.app.myapp.pojo.Slot;
import com.app.myapp.repository.ISlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class SlotServiceImpl implements ISlotService {
    @Autowired
    ISlotRepository slotRepository;

    @Override
    public boolean prepareSlot() {
        Slot newSlot;
        try {
            for (int i = 1; i <= 10; i++) {
                newSlot = new Slot(String.valueOf(i), null);
                slotRepository.save(newSlot);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    @Override
    public List<Slot> getAllSlot() {
        return slotRepository.findAll();
    }

}