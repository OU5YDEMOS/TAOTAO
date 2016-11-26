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
    
    <title>增加学生信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
 function megers(){
      var obj=document.getElementById("myForm");
      obj.submit();
 }
</script>
  </head>
  
  <body>
  <form action="student!add" method="post" id="myForm">
      <table border="1" align="center">
         <tr>
          <td>姓名</td>
          <td>
            <input type="text" name="stu.name" value=""/>
          </td>
        </tr>
         <tr>
          <td>年龄</td>
          <td>
            <input type="text" name="stu.age" value=""/>
          </td>
        </tr>
         <tr>
          <td>所在班级</td>
          <td>
            <SELECT name="stu.classId" style="width: 155px; text-align: center;">
              <s:iterator value="clist" var="temp" status="other">
                <s:if test="#other.first">
                  <option value="<s:property value='id'/>" selected="selected"><s:property value="name"/></option>
                </s:if>
                <s:else>
                  <option value="<s:property value='id'/>"><s:property value="name"/></option>
                </s:else>
              </s:iterator>
            </SELECT>
          </td>
        </tr>
          <tr>
          <td colspan="2" style="text-align: center;">
           <input type="button" value="添加" onclick="javascript:megers();" />
           <input type="button" value="返回" onclick="javascript:history.back();" />
          </td>
        </tr>
      </table>
      </form>
  </body>
</html>
