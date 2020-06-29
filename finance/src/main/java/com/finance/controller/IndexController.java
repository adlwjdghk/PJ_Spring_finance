package com.finance.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finance.service.FinanceService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {
	@Autowired
	FinanceService fService;
	
	@RequestMapping("/")
	public String output(Model model) throws IOException{
		log.info(">>>index");
		//fService.financeGraph();
		model.addAttribute("one", fService.selectList());
//		log.info("이건뭘까"+fService.selectList().toString());
		return "index";
	}
	
}
