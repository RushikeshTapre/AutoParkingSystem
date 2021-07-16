package com.app.myapp.controller;
import com.app.myapp.pojo.ApiResponse;
import com.app.myapp.pojo.Car;
import com.app.myapp.pojo.Slot;
import com.app.myapp.service.ICarService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/cars")
public class CarController extends Throwable{

    private static final Logger logger= LoggerFactory.getLogger(CarController.class);


    @Autowired
    private ICarService carService;

    @GetMapping
    public ResponseEntity<?> getAllCarDetails() {
        try {
            Map<String,Object> response;
            List<Car> list = carService.getCarList();
            if(!list.isEmpty()) {
                response=new HashMap<String ,Object>();
                response.put("message",ApiResponse.generateResponse(true));
                response.put("payload",list);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            logger.info("exception in getAllCarDetails:"+e);
        }
        return new ResponseEntity<>(ApiResponse.generateResponse(false,"car list empty"),HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{plateNumber}")
    public ResponseEntity<?> getCarById(@PathVariable String plateNumber) {
        Map<String,Object> response;
        try {
            Car car=carService.getCar(plateNumber);
            if(car!=null){
                response=new HashMap<String ,Object>();
                response.put("message",ApiResponse.generateResponse(true));
                response.put("data",car);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            logger.info("err in getCarById" + e);
        }
        return new ResponseEntity<>(ApiResponse.generateResponse(false,"car not found with "+plateNumber),HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<?> carEntry(@RequestBody Car newCar) {

        Map<String,Object> response;
        try {
            Slot slot=carService.carEntry(newCar);
            if(slot!=null) {
                response=new HashMap<String ,Object>();
                response.put("message",ApiResponse.generateResponse(true));
                response.put("data",slot);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (RuntimeException e) {
            logger.info("exception in carEntry:"+e);
        }
        return new ResponseEntity<>(ApiResponse.generateResponse(false,"slot not available"),HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{plateNumber}")
    public ResponseEntity<?> carExit(@PathVariable String plateNumber) {
        Map<String,Object> response;
        try {
            Car car=carService.carExit(plateNumber);
            if(car!=null) {
                response=new HashMap<String ,Object>();
                response.put("message",ApiResponse.generateResponse(true));
                response.put("data",car);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (RuntimeException e) {
            logger.info("error in car exit "+e);
        }
        return new ResponseEntity<>(ApiResponse.generateResponse(false,"car not found "+plateNumber),HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search/plateNumber/{plateNumber}")
    public ResponseEntity<?> getSlotNumber(@PathVariable String plateNumber) {

        Map<String,Object> response;
        try {
            Slot slot = this.carService.findSlotNumberByPlateNumber(plateNumber);
            if (slot!=null) {
                response=new HashMap<String ,Object>();
                response.put("message",ApiResponse.generateResponse(true));
                response.put("data",slot);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        }catch (Exception e){
            logger.info(e.toString());
        }
        return new ResponseEntity<>(ApiResponse.generateResponse(false,"slot not found"),HttpStatus.NOT_FOUND);
    }
    @GetMapping("/search/color/{color}")
    public ResponseEntity<?> getCarByColor(@PathVariable String color) {
        Map<String,Object> response;
        List<Car> list=null;
        try {
            list = carService.getCarListByColor(color);
            if(!list.isEmpty()){
                response=new HashMap<String ,Object>();
                response.put("message",ApiResponse.generateResponse(true));
                response.put("data",list);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        }catch (Exception e){
            logger.info("in getCarByColor:"+e);
        }
        return new ResponseEntity<>(ApiResponse.generateResponse(false,"car not found with "+color),HttpStatus.NOT_FOUND);
    }
}
