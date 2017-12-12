package cn.wang.microservice.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cn.wang.microservice.feign.ItemFeignClient;
import cn.wang.microservice.pojo.Item;
import cn.wang.microservice.properties.OrderProperties;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
@Service
public class ItemService {
	// Spring框架对RESTful方式的http请求做了封装，来简化操作
		@Autowired
		private RestTemplate restTemplate;
		
		@Autowired
		DiscoveryClient discoveryClient;
		
		@Autowired
		OrderProperties properties;
		@Autowired
		ItemFeignClient itemFeignClient;
		
		@HystrixCommand(fallbackMethod="queryItemByIdFallbackMethod")
		public Item queryItemById(Long id) {
			return itemFeignClient.queryItemById(id);
		}
		
		public Item queryItemByIdFallbackMethod(Long id){
			return new Item(id,"调用商品服务是出错了!!",null,null,null);
		}
}
