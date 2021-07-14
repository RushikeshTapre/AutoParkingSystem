package com.app.myapp.service;

import com.app.myapp.pojo.Car;
import com.app.myapp.pojo.Slot;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICarService {

    List<Car> getCarList();
    Slot carEntry(Car c);
    Car carExit(String plateNumber);
    Slot findSlotNumberByPlateNumber(String registrationNumber );
    List<Car> getCarListByColor(String colour);
    Car getCar(String id);
}
