package com.app.myapp.pojo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.*;
@Document(collection = "slot")
public class Slot {

    @Id
    ObjectId _id;
    String slotNumber;
    ObjectId carId;

    public Slot() {
    }

    public Slot(String slotNumber, ObjectId carId) {
        this.slotNumber = slotNumber;
        this.carId = carId;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public ObjectId getCarId() {
        return carId;
    }

    public void setCarId(ObjectId carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "slotId='" + _id + '\'' +
                ", slotNumber='" + slotNumber + '\'' +
                ", carId='" + carId+ '\'' +
                '}';
    }
}
