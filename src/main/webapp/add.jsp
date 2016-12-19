<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form action="film.action?op=add" method="post">
   	<input type="hidden" name="id" />   <br>
title:   	<input type="text" name="title" />   <br>
   	<br>     
     language: 		<select name="languageId" style="width:125px" >
	<c:forEach items="${lans }" var="lan">
   			<option value="${lan.id }" >${lan.name }</option>
  		</c:forEach>
   		</select>
  
   	<br><br>
   	description:<input type="text" name="description"  style="width:600px"/>   <br>
   	<br>	<input type="submit" name="sub"  value="确认"/>
   </form>


</body>
</html>