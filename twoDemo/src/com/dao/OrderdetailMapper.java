package com.dao;

import java.util.List;
import java.util.Map;

import com.pojo.Orderdetail;

public interface OrderdetailMapper {

	List<Orderdetail> findById(Long id);

	List<Orderdetail> findByMainId(Long mid);

	List<Orderdetail> findByExample(Orderdetail orderdetail);

	List<Orderdetail> findByMap(Map<String, Object> map);

	List<Orderdetail> findByParameterMap(Map<String, Object> map);

}