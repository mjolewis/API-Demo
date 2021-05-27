package com.taurinustrading.dogapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiDemoApplication.class, args);
    }

//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }
//
//    @Bean
//    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//        //IexCloudConfig config = new IexCloudConfig();
//
//        String key = getEnv();
//        System.out.println(key);
//        System.out.println("https://cloud.iexapis.com/stable/tops?token=" + key + "&symbols=aapl");
//
//        return args -> {
//            Stock stock = restTemplate.getForObject(
//                    "https://cloud.iexapis.com/stable/tops?token=" + key + "&symbols=aapl", Stock.class);
//        };
//    }
}
