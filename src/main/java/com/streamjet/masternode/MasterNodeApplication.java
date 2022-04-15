package com.streamjet.masternode;

import com.streamjet.masternode.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MasterNodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MasterNodeApplication.class, args);
    }

}
