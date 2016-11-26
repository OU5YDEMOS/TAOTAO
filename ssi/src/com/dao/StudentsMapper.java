package com.dao;
import java.util.List;
import com.entity.Students;

public interface StudentsMapper {
	
	//select
	List<Students> selectAll();
	Students selectByPrimaryKey(Integer id);
	List<Students> selectByClassId(Integer classId);
	//delete
	int deleteByPrimaryKey(Integer id);
	//update
	int updateByExample(Students stu);
	//insert
	int insert(Students record);
}