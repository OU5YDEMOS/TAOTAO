package com.dao;

import java.util.List;

import com.entity.Classes;

public interface ClassesMapper {
	//select 
	Classes selectByPrimaryKey(Integer id);
	List<Classes> selectAll();

}