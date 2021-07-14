package com.app.myapp.pojo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;


@Document(collection = "car")
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ObjectId _id;
    private String color;
    private String plateNumber;

    public Car() {
    }

    public Car(ObjectId _id, String color, String plateNumber) {
        this._id = _id;
        this.color = color;
        this.plateNumber = plateNumber;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void setCarIdd(ObjectId _id) {
        this._id = _id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }


    @Override
    public String toString() {
        return "Car{" +
                "carId='" + _id + '\'' +
                ", color='" + color + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                '}';
    }
}
