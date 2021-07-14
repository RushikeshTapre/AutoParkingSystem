package com.app.myapp.repository;

import com.app.myapp.pojo.Car;
import com.app.myapp.pojo.Slot;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface ISlotRepository extends MongoRepository<Slot, String> {
    ArrayList<Slot> findByCarId(String plateNumber);
    Slot findFirstByCarIdNull();
    Slot findFirstByCarId(ObjectId carId);
}
