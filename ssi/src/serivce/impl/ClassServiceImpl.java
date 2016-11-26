package serivce.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ClassesMapper;
import com.entity.Classes;

import serivce.ClassService;

@Service("classService")
public class ClassServiceImpl implements ClassService{


	public ClassServiceImpl(){
		System.err.println("注解了……………………………………………………………………StudentServiceImpl");
	}

	private ClassesMapper classesMapper;

    @Resource(name="classesMapper")
	public void setClassesMapper(ClassesMapper classesMapper) {
		this.classesMapper = classesMapper;
	}



	public List<Classes> getAllClass() {
		return classesMapper.selectAll();
	}




}
