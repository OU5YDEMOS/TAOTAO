package com.test;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.entity.Students;
import com.util.MyJson;
import serivce.StudentService;


public class test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");	
		StudentService studentService=(StudentService) context.getBean("studentService");
		List<Students> list=studentService.getAll();
		
		for (Students students : list) {
			System.out.println();
			System.out.println("id为："+students.getId()+
					"\t名字为:"+students.getName()+
					"\t班级为："+students.getClassesClassId().getName()+
					"\t【"+students.getName()+"】所在的班级一共有："+students.getClassesClassId().getStudentssClassId().size()+"个学生");
		}
		
		System.out.println(MyJson.toJsonStr(list, "studentssClassId"));
	}
	
}
