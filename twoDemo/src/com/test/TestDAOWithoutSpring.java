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
	 * 俩表之间的关联查询
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
		System.out.println("\n\n这个相同订单id的一共有：");
		for (Orderdetail orderdetail : list.get(0).getOrdermainOrdermainid().getOrderdetailsOrdermainid()) {
			System.out.println("订单详细id:"+orderdetail.getId()+"\t订单id:"+orderdetail.getOrdermainid()+"\t\t产品名称为:"+orderdetail.getProductname());
		}
	}

	

	/**
	 * 多方参数方法的使用1：传Object
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
	 * 多方参数方法的使用2：传java.util.Map
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
		System.out.println("刚刚修改".length());
	}
	
	
	/**
	 * 多方参数方法的使用3：传java.util.Map并使用parameterMap
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
		//map.put("pname", "刚刚修改");
		
		List<Orderdetail> list=orderdaoMapper.findByParameterMap(map);
		System.out.println(list.size());
		System.out.println(list.get(0).getProductname());
		System.out.println("刚刚修改".length());
	}
	
	

	public static void main(String[] args) throws Exception{
		//new TestDAOWithoutSpring().manyParameter3();
		new TestDAOWithoutSpring().add();
	}
	
	
	/**
	 * add方法
	 */
	public void add() throws Exception{
		Reader reader = Resources.getResourceAsReader("sqlMapConfig.xml");	
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader, "mysql");
		
		SqlSessionTemplate template=new SqlSessionTemplate(factory, ExecutorType.SIMPLE);
		
		//SqlSession session=factory.openSession();
	
		//getdao
		OrdermainMapper om=template.getMapper(OrdermainMapper.class);
		
		//开始add
		Ordermain omentity=new Ordermain();
		//omentity.setId(45L);
		omentity.setCustname("huawei");
		int con=om.addOrderMain(omentity);
		System.out.println(con);
	}
}