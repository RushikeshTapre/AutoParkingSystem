package com.app.myapp.repository;

import com.app.myapp.pojo.Car;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface ICarRepository extends MongoRepository<Car , String> {
    Car findByPlateNumber(String plateNumber);
    List<Car> findByColor(String color);
    Car findOneBy_id(ObjectId carId);
    Car deleteById(String id);
}
