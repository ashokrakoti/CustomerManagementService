package com.ecommerce.customermanagementservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Component
public class BeanPrinter {

    private static final Logger logger = LoggerFactory.getLogger(BeanPrinter.class);

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        String[] beanNames = context.getBeanDefinitionNames();

        logger.info("======= SPRING BOOT BEANS =======");
        logger.info("Total beans configured: {}", beanNames.length);

        // Group beans by package for better readability
        Map<String, List<String>> beansByPackage = Arrays.stream(beanNames)
                .collect(groupingBy(beanName -> {
                    Object bean = context.getBean(beanName);
                    String packageName = bean.getClass().getPackageName();
                    return packageName.startsWith("com.ecommerce") ? "YOUR_BEANS" : "FRAMEWORK_BEANS";
                }));

        // Print your custom beans first
        if (beansByPackage.containsKey("YOUR_BEANS")) {
            logger.info("--- YOUR APPLICATION BEANS ---");
            beansByPackage.get("YOUR_BEANS").stream()
                    .sorted()
                    .forEach(beanName -> {
                        Object bean = context.getBean(beanName);
                        logger.info("{} -> {}", beanName, bean.getClass().getSimpleName());
                    });
        }

        // Print framework beans count (without listing all)
        if (beansByPackage.containsKey("FRAMEWORK_BEANS")) {
            logger.info("--- FRAMEWORK BEANS: {} ---", beansByPackage.get("FRAMEWORK_BEANS").size());
        }

        logger.info("===================================");
    }
}