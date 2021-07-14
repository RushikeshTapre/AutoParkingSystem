package com.app.myapp.util;

import com.app.myapp.pojo.Car;
import com.app.myapp.pojo.Slot;

import java.util.ArrayList;

public class ResponseMessage {

        String message;
        Car car;
        Slot slot;
        ArrayList<Object> list;

    public ResponseMessage(String message, Car car, Slot slot, ArrayList<Car> carList, ArrayList<Slot> slotList) {
        this.message = message;
        this.car = car;
        this.slot = slot;
    }

    public ResponseMessage(String message) {
        this.message = message;
    }

    public ResponseMessage(Car car) {
        this.car = car;
    }

    public ResponseMessage(Slot slot) {
        this.slot = slot;
    }

}
