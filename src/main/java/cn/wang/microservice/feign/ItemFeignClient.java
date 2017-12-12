package cn.wang.microservice.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.wang.microservice.pojo.Item;
@FeignClient(value="wang-microservice-item")
public interface ItemFeignClient {
	@RequestMapping(value="/item/{id}",method=RequestMethod.GET)
	public Item queryItemById(@PathVariable("id") Long id);

}
