package com.app.myapp.service;

import com.app.myapp.controller.CarController;
import com.app.myapp.pojo.Car;
import com.app.myapp.pojo.Slot;
import com.app.myapp.repository.ICarRepository;
import com.app.myapp.repository.ISlotRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CarServiceImpl implements ICarService {

    private static final Logger logger= LoggerFactory.getLogger(CarServiceImpl.class);

    @Autowired
    ICarRepository carRepository;

    @Autowired
    ISlotRepository slotRepository;

    public CarServiceImpl() {
        logger.info("In CarServiceImpl");
    }

    @Override
    public List<Car> getCarList(){

        List<Car> carList=carRepository.findAll();
        if(!carList.isEmpty())
            return carList;
        logger.info("car list empty");
        return null;
    }

    @Override
    public Slot carEntry(Car car) {
        try {
            Slot slot=slotRepository.findFirstByCarIdNull();
            logger.info("in carEntry :slot"+slot);
            if(slot.equals(null))
            {
                logger.info("slot not found");
                return null;
            }
            car=carRepository.save(car);
            logger.info("car.save()"+car.get_id().toString());
            slot.setCarId(car.get_id());
            return  slotRepository.save(slot);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Car carExit(String plateNumber) {
        Car car=carRepository.findOneBy_id((carRepository.findByPlateNumber(plateNumber).get_id()));
        if(!(car==null)){
            logger.info("carId :not found"+plateNumber);
           return null;
        }
        Slot slot=slotRepository.findFirstByCarId(car.get_id());
        if(!slot.equals(null)){
            carRepository.deleteById(String.valueOf(car.get_id()));
            slot.setCarId(null);
            slotRepository.save(slot);
        return car;
        }
        logger.info("slot with car id not found"+plateNumber);
            return null;

    }

    @Override
    public Slot findSlotNumberByPlateNumber(String plateNumber) {
        Car car=null;
        Slot slot=null;
        car=carRepository.findByPlateNumber(plateNumber);
        if(car==null){
            logger.info("car not found"+plateNumber);
            return null;
        }
        slot=slotRepository.findFirstByCarId(car.get_id());
        if(slot==null) {
            logger.info("slot not found");
            return null;
        }
        return slot;
    }

    @Override
    public List<Car> getCarListByColor(String color) {
        List<Car> carList=carRepository.findByColor(color);
        if(!carList.isEmpty()){
            return carList;
        }
        logger.info("car with "+color+"not found");
        return null;
    }

    @Override
    public Car getCar(String plateNumber) {
        Car car = carRepository.findByPlateNumber(plateNumber);
        if (car.equals(null)) {
            logger.info("Car not Found");
            return null;
        }
        return car;
    }
}
