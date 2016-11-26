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
    
    <title>学员列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<SCRIPT type="text/javascript">
	  function del(id){
	    if(confirm("确认要删除吗?")){
	      location='student!delete?stu.id='+id;
	    }
	  }
	  function toUpdate(id){
	     location='student!toUpdate?stu.id='+id;
	  }
	  function detail(id){
	    location='student!getStudent?stu.id='+id;
	  }
	</SCRIPT>
  </head>
  
  <body>
    <form action="#" id="myForm" method="post">
    
      <table border="1" align="center">
        <tr style="background: gray;text-align: center">
          <td colspan="7">学员列表</td>
        </tr>
        <tr  style="background:#CCC;font-weight: bold;text-align: center">
          <td width="50">编号</td>
          <td width="60">姓名</td>
          <td width="50">年龄</td>
          <td width="100">所在班级</td>
          <td width="">班级总人数</td>
          <td width="">同班的人</td>
          <td width="125">操作</td>
        </tr>
        <s:iterator value="#list" var="temp" status="other">
          <s:if test="#other.isOdd()">
            <tr  style="background: #FFCCCC;">
	          <td><s:property value="id"/></td>
	          <td><s:property value="name"/></td>
	          <td><s:property value="age"/></td>
	          <td><s:property value="classesClassId.name" default="空班级"/></td>
	          <td style="text-align: center"><s:property value="classesClassId.studentssClassId.size()" default="没有人"/></td>
	           <td>
	             <s:iterator value="classesClassId.studentssClassId" var="subItem" status="subOther">
	               <s:property value="name"/>
	               <s:if test="!#subOther.last">,</s:if>
	             </s:iterator>
	           </td>
	          <td>
	             <input type="button" onclick="del('<s:property value="id"/>')" value="删除"/>
	             <input type="button" onclick="toUpdate('<s:property value="id"/>')" value="修改"/>
	             <input type="button" onclick="detail('<s:property value="id"/>')" value="详情"/>
	          </td>
	        </tr>
          </s:if>   
          <s:else>
            <tr  style="background:#FFFFCC;">
	          <td><s:property value="id"/></td>
	          <td><s:property value="name"/></td>
	          <td><s:property value="age"/></td>
	          <td><s:property value="classesClassId.getName()" default="空班级"/></td>
	          <td style="text-align: center"><s:property value="classesClassId.studentssClassId.size()" default="没有人"/></td>
	           <td>
	             <s:iterator value="classesClassId.studentssClassId" var="subItem" status="subOther">
	               <s:property value="name"/>
	               <s:if test="!#subOther.last">,</s:if>
	             </s:iterator>
	           </td>
	          <td>
	             <input type="button" onclick="del('<s:property value="id"/>')" value="删除"/>
	             <input type="button" onclick="toUpdate('<s:property value="id"/>')" value="修改"/>
	             <input type="button" onclick="detail('<s:property value="id"/>')" value="详情"/>
	          </td>
	        </tr>
          </s:else>
               
        </s:iterator>
        <tr  style="background:#fff;font-weight: bold;text-align: center">
          <td colspan="7">
            <input type="button" value="添加学生" onclick="location.href='classAction!getAllCalss';"/>
          </td>
        </tr>
      </table>
    
    
    </form>
  </body>
</html>
