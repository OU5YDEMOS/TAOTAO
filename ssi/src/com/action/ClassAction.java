package com.action;
import java.util.List;
import javax.annotation.Resource;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import serivce.ClassService;
import com.entity.Classes;
import com.opensymphony.xwork2.ActionSupport;

@Action(value="classAction",results={
		@Result(name="success",location="add.jsp",type="dispatcher"),
		@Result(name="error",location="student!getAll",type="redirect")
})
public class ClassAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5805903145859663439L;
	
	private ClassService classService;
	
	@Resource(name="classService")
	public void setClassService(ClassService classService) {
		this.classService = classService;
	}


	List<Classes> clist; 

	
	public String getAllCalss(){
		clist=classService.getAllClass();
		if (clist==null || clist.size()==0) {
			return ERROR;
		}
		return SUCCESS;
	}


	public List<Classes> getClist() {
		return clist;
	}
	public void setClist(List<Classes> clist) {
		this.clist = clist;
	}
	
	
}
