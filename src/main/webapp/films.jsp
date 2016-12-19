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
	

</script>
</head>
<body>
	<form action="#">
		<div class="page_title">films</div>
		<div class="button_bar">
			<button><a href="film.action?op=toAdd" style="font-size: 16px;">新建</a></button>
			<!-- <button class="common_button" onclick="document.forms[0].submit();">查询</button> -->
		</div>
		<div>
			<table class="query_form_table" border="0" cellPadding="3"
				cellSpacing="0">
				<tr style="text-align:center;font-size: 18px;font-weight: bold ">
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
						<td>${film.languageName }</td>
						<td><a class="deleteId"
							href="film.action?op=delete&id=${film.id}">删除</a></td>
						<td><a href="film.action?op=toModify&id=${film.id}">修改</a></td>
					</tr>
				</c:forEach>
				 <tr style="text-align: center" class="loan_tr">
				<td colspan="9" style="text-align: center">
						<font>当前页${page.curPage }</font>
						<c:if test="${page.curPage==1 }">
								首页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</c:if><c:if test="${page.curPage>1}">
							<a href="${pageContext.request.contextPath }/film.action?op=pageQuery&pageNum=1">首页</a>
								<a href="${pageContext.request.contextPath}/film.action?op=pageQuery&pageNum=${page.curPage-1 }">上一页</a>
						</c:if>
						<c:forEach var="i" begin="1"  end="${page.maxPage }" varStatus="status">
								<c:if test="${i!=page.curPage&&status.index<20 }">
								<a href="${pageContext.request.contextPath }/film.action?op=pageQuery&pageNum=${i}">${ i }</a>
								</c:if>
						</c:forEach>
						<c:if test="${ page.curPage<page.maxPage}">
								<a href="${pageContext.request.contextPath }/film.action?op=pageQuery&pageNum=${page.curPage+1 }">下一页</a>
							<a href="${pageContext.request.contextPath }/film.action?op=pageQuery&pageNum=${page.maxPage }">末页</a>
						</c:if>
			</td>
				</tr>
			</table>
	  	             
	  	            
		<%-- 	<hand:page page="${page }"></hand:page> --%>
		</div>
	</form>
</body>
</html>