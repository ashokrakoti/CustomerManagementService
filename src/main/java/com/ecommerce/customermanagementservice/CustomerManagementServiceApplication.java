package com.ecommerce.customermanagementservice;

import com.ecommerce.customermanagementservice.config.SecurityConfig;
import com.ecommerce.customermanagementservice.service.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@SpringBootApplication//(exclude = {SecurityConfig.class}) can be used to exclude a auto config item only
//below is example to exclude a specific component class.
//@ComponentScan(
//		excludeFilters =@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
//				classes = {SecurityConfig.class}))
public class CustomerManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerManagementServiceApplication.class, args);
	}

}
