package com.finance.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.domain.FinanceDTO;
import com.finance.persistence.FinanceDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FinanceService {
	FinanceDAO fDao;
	
	@Autowired
	private SqlSession sqlSession;
	 
	@Autowired 
	public void query() {
		fDao = sqlSession.getMapper(FinanceDAO.class);
	}
	
	public void financeGraph() throws IOException {
		List<String> BaseUrl = new ArrayList<>();
		BaseUrl.add("https://finance.naver.com/sise/sise_index_time.nhn?code=KOSPI&thistime=20200626185900&page=");
		BaseUrl.add("https://finance.naver.com/sise/sise_index_time.nhn?code=KOSDAQ&thistime=20200626185900&page=");
		BaseUrl.add("https://finance.naver.com/sise/sise_index_time.nhn?code=FUT&thistime=20200626153459&page=");
		
		for(int i=0;i<BaseUrl.size();i++) {
			int page=65;
			labal: while(true) {
				String url = BaseUrl.get(i) + page;
				log.info(url+" >> "+page);
				System.out.println(url+" >> !"+page);
				String type = "";
				
				if(BaseUrl.get(i) == BaseUrl.get(0)) {
					type = "kospi";
				} else if(BaseUrl.get(i) == BaseUrl.get(1)) {
					type = "kosdaq";
				} else {
					type = "fut";
				}
				
				Document naverDoc = Jsoup.connect(url).get();
				Elements naverTime = naverDoc.select("tbody > tr > td.date");
				Elements naverPrice = naverDoc.select("tbody > tr > td:nth-child(2)");
				
				for (int j=5; j>=0; j--) {
					String time = naverTime.get(j).text(); // 시간
					String price = naverPrice.get(j).text(); // 가격
				
					log.info( "type" +" <><><>"+time+"<><><>: "+ price);
					System.out.println( type +" <><><>"+time+"<><><>: "+ price);
					// DB
					fDao.addData(type, time, price);
				}
				if(page == 1) {
					break labal;
				}
				page--;
			}
		}
	}

	public List<FinanceDTO> selectList() {
		return fDao.selectList();
	}
}
