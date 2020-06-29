package com.finance.scheduler;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.finance.service.FinanceService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FinanceScheduler {
	@Autowired
	FinanceService fService;
	
	@Scheduled(cron="0 40 22 * * *")
	public void Collect() throws IOException{
		log.info("************* :)");
		fService.financeGraph();
	}
	
}
