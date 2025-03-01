package com.example.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveApplication.class, args);
		
//		StockPriceMonitor.startStockPriceMonitoring();
		TrafficMonitoringSystem.startTrafficMonitoring();
	}

}
