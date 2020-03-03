package com.allyexample.allyauctionserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class AllyAuctionServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllyAuctionServerApplication.class, args);
	}

}
