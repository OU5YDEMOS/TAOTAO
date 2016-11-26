package com.action;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import serivce.StudentService;
import com.entity.Students;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Results({
	@Result(name = "success",location = "${paths}"),
	@Result(name = "redirect", location = "${paths}",type="redirect")
})
@Action("student")
public class StudentAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5350504689176245476L;
	public StudentAction(){
		System.err.println("注解了……………………………………………………………………StudentAction");
	}


	private StudentService studentService;

	@Resource(name="studentService")
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	//页面的跳转路径
	private String paths;
	//student对象
	private Students stu;

	/**
	 * 获取全部学生对象
	 */
	@Action(value="start")
	public String getAll(){
		List<Students> list=studentService.getAll();
		ActionContext.getContext().put("list", list);
		paths="studentList.jsp";
		return SUCCESS;
	}

	/**
	 * 根据id删除学生信息
	 */
	public String delete(){
		studentService.delete(stu.getId());
		paths="student!getAll";
		return "redirect";
	}

	/**
	 * 根据id获取学生信息
	 */
	public String getStudent(){
		stu = studentService.get(stu.getId());
		paths="detail.jsp";
		return SUCCESS;
	}

	/**
	 * 到update页面
	 */
	public String toUpdate(){
		stu = studentService.get(stu.getId());
		paths="update.jsp";
		return SUCCESS;
	}

	/**
	 * 更新学生信息
	 */
	public String update(){

		//Classes classes=new Classes();
		//classes.setId(1);
		//stu.setClasses(classes);
		studentService.update(stu);
		paths="student!getAll";
		return "redirect";
	}
	
	/**
	 * 增加学生信息
	 */
	public String add(){

		//Classes classes=new Classes();
		//classes.setId(1);
		//stu.setClasses(classes);
		studentService.add(stu);
		paths="student!getAll";
		return "redirect";
	}




	public String getPaths() {
		return paths;
	}
	public void setPaths(String paths) {
		this.paths = paths;
	}
	public Students getStu() {
		return stu;
	}
	public void setStu(Students stu) {
		this.stu = stu;
	}
}
