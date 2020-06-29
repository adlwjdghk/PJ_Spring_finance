package com.finance.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.finance.domain.FinanceDTO;

public interface FinanceDAO {
	public void addData(@Param("type") String option, @Param("time") String time, @Param("p") String price);
	public List<FinanceDTO> selectList();
}
