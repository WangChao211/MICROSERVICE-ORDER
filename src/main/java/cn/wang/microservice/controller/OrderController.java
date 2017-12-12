package cn.wang.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cn.wang.microservice.pojo.Order;
import cn.wang.microservice.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	OrderService service;
	
	@GetMapping(value="order/{orderId}")
	public Order queryOrderById(@PathVariable("orderId") String orderId){
		return service.queryOrderById(orderId);
	}
}
