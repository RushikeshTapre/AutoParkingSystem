package com.app.myapp;

import com.app.myapp.controller.CarController;
import com.app.myapp.pojo.Car;
import com.app.myapp.repository.ICarRepository;
import com.app.myapp.repository.ISlotRepository;
import org.bson.types.ObjectId;
import org.json.JSONException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes = AutoParkingSystemApplication.class
)
@AutoConfigureMockMvc
@TestPropertySource(
		locations = "classpath:application-test.properties"
)
class AutoParkingSystemApplicationTests {

	private static final Logger logger= LoggerFactory.getLogger(CarController.class);

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	ICarRepository carRepository;

	@MockBean
	ISlotRepository slotRepository;

	@BeforeEach
	void init() {
		logger.info("before test start");
//		Car car=new Car(new ObjectId("123"),"red","1234");
//		when(carRepository.findOneBy_id(new ObjectId("123"))).thenReturn(car);
	}

	@Test
	public void findByColorNotFound_404() throws Exception {
		mockMvc.perform(get("/cars/red")).andExpect(status().isNotFound());
	}


	@AfterEach
	void afterEach() {
		logger.info("test was finished");
	}



	@Test
	void carEntry() throws Exception {
//		MvcResult mvcResult=MockMvc.perform(
//				MockMvcRequestBuilders.post("/AutoParking/cars")
//				.accept(MediaType.APPLICATION_JSON)
//		).andReturn();
//		logger.info("result:"+mvcResult.toString());

//		RequestBuilder request = post("/AutoParking/cars");
//		logger.info("request:"+request.toString());
//		MvcResult result = mvc.perform(request).andReturn();
//		logger.info("response: "+result.getResponse().getContentAsString());
//		assertEquals("Hello, World", result.getResponse().getContentAsString());
	}

	@Test
	void getCarByColor() {


	}

	@Test
	void contextLoads() {
	}

}
