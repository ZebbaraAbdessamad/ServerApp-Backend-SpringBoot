package com.zebbara.routerfullstack;

import com.zebbara.routerfullstack.enumeration.Status;
import com.zebbara.routerfullstack.model.Server;
import com.zebbara.routerfullstack.repository.ServerRepository;
import org.springframework.web.filter.CorsFilter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@SpringBootApplication

public class RouterFullStackApplication {

    public static void main(String[] args) {
        SpringApplication.run(RouterFullStackApplication.class, args);

    }
    //pour le test de method repository
    @Bean
    CommandLineRunner run(ServerRepository serverRepo){
        return args ->{
       /*     serverRepo.save(new Server(null,"192.168.1.18" ,"Ubuntu","16GB","Personal PC",
                    "http://localhost:8080/server/image/server2.png", Status.SERVER_UP));
            serverRepo.save(new Server(null,"192.128.1.10" ,"Ubuntu","36GB","VIP PC",
                    "http://localhost:8080/server/image/server3.png", Status.SERVER_UP));*/
        };
    }







}
