package com.app.myapp.controller;

import com.app.myapp.AutoParkingSystemApplication;
import com.app.myapp.repository.ICarRepository;
import com.app.myapp.repository.ISlotRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    classes = AutoParkingSystemApplication.class
)
@AutoConfigureMockMvc
@TestPropertySource(
    locations = "classpath:application-test.properties"
)
class CarControllerTest {

    private static final Logger logger= LoggerFactory.getLogger(CarController.class);

    @Autowired
    private MockMvc mvc;

    @MockBean
    ICarRepository carRepository;

    @MockBean
    ISlotRepository slotRepository;

    @BeforeEach
    void setup() {
        logger.info("before test start");
    }

    @AfterEach
    void afterEach() {
        logger.info("test was finished");
    }



    @Test
    void carEntry() throws Exception {
        RequestBuilder request = get("/AutoParking/cars");
        logger.info("request:"+request.toString());
        MvcResult result = mvc.perform(request).andReturn();
        logger.info("response: "+result.getResponse().getContentAsString());
        assertEquals("Hello, World", result.getResponse().getContentAsString());
    }

    @Test
    void getCarByColor() {


    }
}