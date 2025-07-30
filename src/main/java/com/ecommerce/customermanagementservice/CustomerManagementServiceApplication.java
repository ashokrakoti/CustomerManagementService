package com.ecommerce.customermanagementservice;

import com.ecommerce.customermanagementservice.config.SecurityConfig;
import com.ecommerce.customermanagementservice.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@SpringBootApplication//(exclude = {SecurityConfig.class}) can be used to exclude a auto config item only
//below is example to exclude a specific component class.
//@ComponentScan(
//		excludeFilters =@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
//				classes = {SecurityConfig.class}))
public class CustomerManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerManagementServiceApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner printBeans(ApplicationContext context) {
//		return args -> {
//			String[] beanNames = context.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//
//			System.out.println("======= CONFIGURED BEANS =======");
//			System.out.println("Total beans: " + beanNames.length);
//
//			for (String beanName : beanNames) {
//				Object bean = context.getBean(beanName);
//				System.out.println(beanName + " -> " + bean.getClass().getSimpleName());
//			}
//			System.out.println("================================");
//		};
//	}
}

//@Bean
//public CommandLineRunner printBeansByType(ApplicationContext context) {
//	return args -> {
//		System.out.println("======= BEANS BY TYPE =======");
//
//		// Print all Services
//		Map<String, Object> services = context.getBeansWithAnnotation(Service.class);
//		System.out.println("Services (" + services.size() + "):");
//		services.forEach((name, bean) ->
//				System.out.println("  " + name + " -> " + bean.getClass().getSimpleName()));
//
//		// Print all Controllers
//		Map<String, Object> controllers = context.getBeansWithAnnotation(RestController.class);
//		System.out.println("Controllers (" + controllers.size() + "):");
//		controllers.forEach((name, bean) ->
//				System.out.println("  " + name + " -> " + bean.getClass().getSimpleName()));
//
//		// Print all Repositories
//		Map<String, Object> repositories = context.getBeansWithAnnotation(Repository.class);
//		System.out.println("Repositories (" + repositories.size() + "):");
//		repositories.forEach((name, bean) ->
//				System.out.println("  " + name + " -> " + bean.getClass().getSimpleName()));
//
//		System.out.println("=============================");
//	};
//}
