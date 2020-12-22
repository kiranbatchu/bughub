package com.tb.bughub.order.demo;

import com.tb.bughub.order.demo.domain.OrderRequest;
import com.tb.bughub.order.demo.domain.OrderResponse;
import com.tb.bughub.order.demo.model.Order;
import com.tb.bughub.order.demo.repository.OrderRepository;
import com.tb.bughub.order.demo.service.OrderService;
import com.tb.bughub.order.demo.web.OrderController;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.ui.ModelExtensionsKt;
import org.springframework.util.Assert;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;




@AutoConfigureMockMvc
@SpringBootTest
@EnableWebMvc
class DemoApplicationTests extends Mockito {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private OrderService orderService;

	@MockBean
	private OrderRepository orderRepository;

	@MockBean
	private Order order;


	@Test
	void contextLoads() {
	}

	@Test
	public void postCreateOrder() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/orders/createOrder").accept(MediaType.APPLICATION_JSON).content("test"))
				.andExpect(status().isOk());
	}

	@Test
	public void createOrder_thenReturnOrderResponse () throws Exception{
		OrderRequest orderRequest = new OrderRequest();
		List<String> menuItemList = new ArrayList<String>();
		menuItemList.add("333-333-333-333");
		orderRequest.setMenuItem(menuItemList);
		orderRequest.setRestuarantId("2020");
		orderRequest.setUserId("test");
		orderRequest.setTip(25);
		when(orderRepository.save(order)).thenReturn(any());
		OrderResponse orderResponse = orderService.createOrder(orderRequest);
		Assertions.assertNotNull(orderResponse.getOrderId());
		Assertions.assertNotNull(orderResponse.getTotalPrice());
		Assertions.assertNotNull(orderResponse.getOrderTime());
		Assertions.assertNotNull(orderResponse.getExpectedDeliveryTime());
	}

}
