package serivce;
import java.util.List;
import com.entity.Students;

public interface StudentService {
	
	/**
	 * 获取所有的学员信息
	 * @return  所有的学员信息集合
	 */
	public abstract List<Students> getAll();
	
	/**
	 * 根据id删除学生信息
	 */
	public abstract void delete(Integer id);
	
	/**
	 * 根据id获取学生信息
	 */
	public abstract Students get(Integer id);
	
	/**
	 * 更新学生信息
	 */
	public abstract void update(Students stu);
	
	/**
	 *增加学生信息
	 */
	public abstract void add(Students stu);
}
