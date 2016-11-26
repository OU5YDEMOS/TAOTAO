package com.dao;

import com.pojo.Ordermain;

public interface OrdermainMapper {


	Ordermain selectByPrimaryKey(Long id);

	//Ôö
	int addOrderMain(Ordermain om);

}