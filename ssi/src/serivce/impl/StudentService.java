package serivce.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.StudentsMapper;
import com.entity.Students;

@Service("studentService")
public class StudentService implements serivce.StudentService{


	public StudentService(){
		System.err.println("注解了……………………………………………………………………StudentServiceImpl");
	}

	private StudentsMapper studentsMapper;

	@Resource(name="studentsMapper")
	public void setStudentsMapper(StudentsMapper studentsMapper) {
		this.studentsMapper = studentsMapper;
	}

	/**
	 * 获取所有的学员信息
	 * @return  所有的学员信息集合
	 */
	public List<Students> getAll(){
		try {
			List<Students> list=studentsMapper.selectAll();
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 根据id删除学生信息
	 */
	public void delete(Integer id){
		studentsMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 根据id获取学生信息
	 */
	public Students get(Integer id){
		return studentsMapper.selectByPrimaryKey(id);
	}

	/**
	 * 更新学生信息
	 */
	public void update(Students stu){
		stu.setClassId(null);
		studentsMapper.updateByExample(stu);
	}

	/**
	 * 增加学生信息
	 */
	public void add(Students stu) {
		studentsMapper.insert(stu);
	}


}
