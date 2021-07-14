package com.app.myapp.service;

import com.app.myapp.pojo.Slot;

import java.util.ArrayList;
import java.util.List;

public interface ISlotService {

    boolean prepareSlot();

    List<Slot> getAllSlot();
}
