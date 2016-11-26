<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
      <table border="1" align="center">
        <tr>
          <td width="77">编号</td>
          <td width="77"><s:property value="stu.id"/></td>
        </tr>
         <tr>
          <td>姓名</td>
          <td><s:property value="stu.name"/></td>
        </tr>
         <tr>
          <td>年龄</td>
          <td><s:property value="stu.age"/></td>
        </tr>
         <tr>
          <td>所在班级</td>
          <td><s:property value="stu.classesClassId.name"/></td>
        </tr>
          <tr>
          <td colspan="2" style="text-align: center;">
           <input type="button" value="返回" onclick="javascript:history.back();" />
          </td>
        </tr>
      </table>
  </body>
</html>
