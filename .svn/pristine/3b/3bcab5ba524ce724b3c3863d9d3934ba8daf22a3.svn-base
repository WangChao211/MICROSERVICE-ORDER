package cn.wang.microservice.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="microservice")
public class OrderProperties {

	ItemProperties item = new ItemProperties();

	public ItemProperties getItem() {
		return item;
	}

	public void setItem(ItemProperties item) {
		this.item = item;
	}
	
}
