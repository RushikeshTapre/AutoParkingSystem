package com.app.myapp.service;

import com.app.myapp.pojo.Car;
import com.app.myapp.pojo.Slot;
import com.app.myapp.repository.ICarRepository;
import com.app.myapp.repository.ISlotRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CarServiceImpl implements ICarService {

    @Autowired
    ICarRepository carRepository;

    @Autowired
    ISlotRepository slotRepository;

    public CarServiceImpl() {
        System.out.println("In CarServiceImpl");
    }

    @Override
    public List<Car> getCarList(){

        List<Car> carList=carRepository.findAll();
        if(!carList.isEmpty())
            return carList;
        System.out.println("car list empty");
        return null;
    }

    @Override
    public Slot carEntry(Car car) {
        try {
            Slot slot=slotRepository.findFirstByCarIdNull();
            System.out.println("in carEntry :slot"+slot);
            if(slot.equals(null))
            {
                System.out.println("slot not found");
                return null;
            }
            car=carRepository.save(car);
            System.out.println("car.save()"+car.get_id().toString());
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
            System.out.println("carId :not found"+plateNumber);
           return null;
        }
        Slot slot=slotRepository.findFirstByCarId(car.get_id());
        if(!slot.equals(null)){
            carRepository.deleteById(String.valueOf(car.get_id()));
            slot.setCarId(null);
            slotRepository.save(slot);
        return car;
        }
        System.out.println("slot with car id not found"+plateNumber);
            return null;

    }

    @Override
    public Slot findSlotNumberByPlateNumber(String plateNumber) {
        Car car=null;
        Slot slot=null;
        car=carRepository.findByPlateNumber(plateNumber);
        if(car==null){
            System.out.println("car not found"+plateNumber);
            return null;
        }
        slot=slotRepository.findFirstByCarId(car.get_id());
        if(slot==null) {
            System.out.println("slot not found");
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
        System.out.println("car with "+color+"not found");
        return null;
    }

    @Override
    public Car getCar(String plateNumber) {
        Car car = carRepository.findByPlateNumber(plateNumber);
        if (car.equals(null)) {
            System.out.println("Car not Found");
            return null;
        }
        return car;
    }
}
