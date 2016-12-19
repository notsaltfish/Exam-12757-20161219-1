<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ taglib prefix="hand" tagdir="/WEB-INF/tags"%> --%>
<%-- <%@ include file="/commons/common.jsp"%>
 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$(".deleteId").click(function() {
			var username = $(this).parents("tr").find("td:eq(0)").text();
			var flag = confirm("您真的要删除" + username + "吗?");
			if (flag) {
				return true;
			}
			return false;
		});
		
		$("#new").click(function() {
			window.location.href = "film.action?op=toAdd";
			return false;
		});
	});

</script>
</head>
<body>
	<form action="#">
		<div class="page_title">films</div>
		<div class="button_bar">
			<a href="film.action?op=toAdd">新建</a>
			<button class="common_button" onclick="document.forms[0].submit();">查询</button>
		</div>
		<div>
			<table class="query_form_table" border="0" cellPadding="3"
				cellSpacing="0">
				<tr>
					<td>film_id</td>
					<td>title</td>
					<td>description</td>
					<td>language</td>
					<td colspan="2" align="center">操作</td>
				</tr>
				<c:forEach items="${films}" var="film">
					<tr>
						<td>${film.id }</td>
						<td>${film.title }</td>
						<td>${film.description }</td>
						<td>${film.languageId }</td>
						<td><a class="deleteId"
							href="film.action?op=delete&id=${film.id}">删除</a></td>
						<td><a href="film.action?op=toModify&id=${film.id}">修改</a></td>
					</tr>
				</c:forEach>
			</table>
		<%-- 	<hand:page page="${page }"></hand:page> --%>
		</div>
	</form>
</body>
</html>