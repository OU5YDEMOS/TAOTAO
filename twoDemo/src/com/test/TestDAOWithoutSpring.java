package com.test;
import com.dao.OrderdetailMapper;
import com.dao.OrdermainMapper;
import com.pojo.Orderdetail;
import com.pojo.Ordermain;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionTemplate;

/*
No spring by page query
 */
public class TestDAOWithoutSpring {


	/**
	 * ����֮��Ĺ�����ѯ
	 */
	public void cascade() throws Exception{
		Reader reader = Resources.getResourceAsReader("sqlMapConfig.xml");	
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader, "mysql");
		//factory=new SqlSessionFactoryBuilder().build(this.getClass().getResourceAsStream("/sqlMapConfig.xml"));
		SqlSession session=factory.openSession();
		//getdao
		OrderdetailMapper orderdaoMapper=session.getMapper(OrderdetailMapper.class);
		//invoke dao
		List<Orderdetail>  list = ( List<Orderdetail>) orderdaoMapper.findById(1L);
		System.out.println(list.get(0).getProductname());
		session.close();
		System.out.println(list.get(0).getOrdermainOrdermainid().getAddress());
		System.out.println("\n\n�����ͬ����id��һ���У�");
		for (Orderdetail orderdetail : list.get(0).getOrdermainOrdermainid().getOrderdetailsOrdermainid()) {
			System.out.println("������ϸid:"+orderdetail.getId()+"\t����id:"+orderdetail.getOrdermainid()+"\t\t��Ʒ����Ϊ:"+orderdetail.getProductname());
		}
	}

	

	/**
	 * �෽����������ʹ��1����Object
	 */
	public void manyParameter1() throws Exception{
		Reader reader = Resources.getResourceAsReader("sqlMapConfig.xml");	
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader, "mysql");
		SqlSession session=factory.openSession();
		//getdao
		OrderdetailMapper orderdaoMapper=session.getMapper(OrderdetailMapper.class);
		Orderdetail order=new Orderdetail();
		order.setId(1L);
		order.setOrdermainid(1L);
		order.setNum(50L);
		List<Orderdetail> list=orderdaoMapper.findByExample(order);
		System.out.println(list.size());
		System.out.println(list.get(0).getProductname());
	}
	
	

	
	/**
	 * �෽����������ʹ��2����java.util.Map
	 */
	public void manyParameter2() throws Exception{
		Reader reader = Resources.getResourceAsReader("sqlMapConfig.xml");	
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader, "mysql");
		SqlSession session=factory.openSession();
		//getdao
		OrderdetailMapper orderdaoMapper=session.getMapper(OrderdetailMapper.class);
		
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("mainid", 1L);
		map.put("num", 50L);
		map.put("chinese", "ggxg");
		
		List<Orderdetail> list=orderdaoMapper.findByMap(map);
		System.out.println(list.size());
		System.out.println(list.get(0).getProductname());
		System.out.println("�ո��޸�".length());
	}
	
	
	/**
	 * �෽����������ʹ��3����java.util.Map��ʹ��parameterMap
	 */
	public void manyParameter3() throws Exception{
		Reader reader = Resources.getResourceAsReader("sqlMapConfig.xml");	
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader, "mysql");
		SqlSession session=factory.openSession();
		//getdao
		OrderdetailMapper orderdaoMapper=session.getMapper(OrderdetailMapper.class);
		
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("mainid", 1L);
		map.put("num", 50L);
		//map.put("pname", "�ո��޸�");
		
		List<Orderdetail> list=orderdaoMapper.findByParameterMap(map);
		System.out.println(list.size());
		System.out.println(list.get(0).getProductname());
		System.out.println("�ո��޸�".length());
	}
	
	

	public static void main(String[] args) throws Exception{
		//new TestDAOWithoutSpring().manyParameter3();
		new TestDAOWithoutSpring().add();
	}
	
	
	/**
	 * add����
	 */
	public void add() throws Exception{
		Reader reader = Resources.getResourceAsReader("sqlMapConfig.xml");	
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader, "mysql");
		
		SqlSessionTemplate template=new SqlSessionTemplate(factory, ExecutorType.SIMPLE);
		
		//SqlSession session=factory.openSession();
	
		//getdao
		OrdermainMapper om=template.getMapper(OrdermainMapper.class);
		
		//��ʼadd
		Ordermain omentity=new Ordermain();
		//omentity.setId(45L);
		omentity.setCustname("huawei");
		int con=om.addOrderMain(omentity);
		System.out.println(con);
	}
}