package com.util;

import net.sf.json.JSONSerializer; 
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

public class MyJson {
	
	/**
	 * 根据参数指定， 不转换参数中的属性
	 * @param obj
	 * @param propertyNames
	 * @return
	 */
	public static String toJsonStr(Object obj,final String...propertyNames){
	
		JsonConfig config=new JsonConfig();
		
		
		config.setJsonPropertyFilter(new PropertyFilter(){public boolean apply(Object arg0, String arg1, Object arg2) {
			for (String str : propertyNames) {
				if (arg1.equals(str)) {
					return true;//不执行json转换
				}
			}
			return false;
		}});
		
		String msg=JSONSerializer.toJSON(obj,config).toString();
		
		return msg;
		
		
	}
	
	
	/**
	 * 不转换空值
	 * @param obj
	 * @return
	 */
	public static String toJsonStrNotNull(Object obj){
		
		JsonConfig config=new JsonConfig();
		
		
		config.setJsonPropertyFilter(new PropertyFilter(){public boolean apply(Object arg0, String arg1, Object arg2) {
			
//			System.out.println("arg0::::"+arg0);
//			System.out.println("arg1::::"+arg1);
//			System.out.println("arg2::::"+arg2);
//			
//			System.out.println("--------------------------");
			try{
			arg2.toString();
			}catch (Exception e) {
				//System.out.println("为空值JSON不转换");
				return true;
			}
			return false;
		}});
		
		String msg=JSONSerializer.toJSON(obj,config).toString();
		
		return msg;
		
		
	}
}
