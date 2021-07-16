package com.app.myapp.controller;

import com.app.myapp.pojo.Car;
import com.app.myapp.pojo.Slot;
import com.app.myapp.service.ISlotService;
import com.app.myapp.service.SlotServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/slots")
public class SlotController {
    private static final Logger logger= LoggerFactory.getLogger(SlotController.class);

   @Autowired
    SlotServiceImpl slotService;

    @GetMapping
    public ResponseEntity<?> prepareSlot() {
        try {
            if(slotService.prepareSlot())
                return new ResponseEntity<>(HttpStatus.OK);
            else
                throw new RuntimeException("error in prepareSlot");
        } catch (RuntimeException e) {
            logger.info("err in prepareSlot" + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/search")
    public ResponseEntity<?> getAllSlot() {
        try {
            List<Slot> slotList=slotService.getAllSlot();
            if(!slotList.isEmpty())
                return new ResponseEntity<>(slotList,HttpStatus.OK);
            else
                throw new RuntimeException("error in prepareSlot");
        } catch (RuntimeException e) {
            logger.info("err in prepareSlot" + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
