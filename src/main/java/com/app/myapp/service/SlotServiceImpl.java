package com.app.myapp.service;
import com.app.myapp.controller.CarController;
import com.app.myapp.pojo.Slot;
import com.app.myapp.repository.ISlotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class SlotServiceImpl implements ISlotService {
    @Autowired
    ISlotRepository slotRepository;
    private static final Logger logger= LoggerFactory.getLogger(SlotServiceImpl.class);

    @Override
    public boolean prepareSlot() {
        Slot newSlot;
        logger.info("in slot :prepareSlot");
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
        logger.info("in slot:getAllSlot");
        return slotRepository.findAll();
    }

}