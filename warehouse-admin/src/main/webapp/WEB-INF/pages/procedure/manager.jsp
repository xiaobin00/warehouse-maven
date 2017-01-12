<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@page import="light.mvc.model._enum.ProcedurePlanStatus"%>
<%
request.setAttribute("statusList", ProcedurePlanStatus.values());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="favicon.ico">
<link href="/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="/css/font-awesome.css?v=4.4.0" rel="stylesheet">

<!-- Data Tables -->
<link href="/css/plugins/dataTables/dataTables.bootstrap.css"
	rel="stylesheet">
<link href="/css/animate.css" rel="stylesheet">
<link href="/css/style.css?v=4.1.0" rel="stylesheet">
</head>
<body>
	<c:if test="${tip != null}">
		<div class="alert alert-danger">${tip}</div>
	</c:if>
	<div class="ibox-content">
		<div class="ibox-content">
			<form role="form" class="form-inline" action="/procedure/manager">
				<div class="form-group">
					<label>名字:</label> <input type="text" name="name"
						placeholder="请输入名字" id="exampleInputEmail2" class="form-control">
				</div>
				<div class="form-group">
					<label>流程:</label> <select class="form-control" name="type">
						<option value="0">全部</option>
						<c:forEach items="${procedures }" var="item">
							<option value="${item.id }">${item.name }</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label>状态:</label> <select class="form-control" name="status">
						<option value="-1">全部</option>
						<c:forEach items="${statusList }" var="item">
							<option value="${item.id }">${item.name }</option>
						</c:forEach>
					</select>
				</div>
				<button class="btn btn-white" type="submit">查询</button>
			</form>
		</div>
		<table
			class="table table-striped table-bordered table-hover dataTables-example">
			<thead>
				<tr>
					<th>id</th>
					<th>名字</th>
					<th>流程</th>
					<th>数量</th>
					<th>进度</th>
					<th>开始时间</th>
					<th>结束时间</th>
					<th>状态</th>
					<th>创建人</th>
					<th>创建时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${procedurePlanInfos }" var="item">
					<tr>
						<td>${item.id }</td>
						<td>${item.name }</td>
						<td><c:forEach items="${procedures }" var="p">
								<c:if test="${p.id == item.procedureId }"> ${p.name }</c:if>
							</c:forEach></td>
						<td>${item.count }</td>
						<td>${item.percentage }%</td>
						<td>${item.startTime }</td>
						<td>${item.endTime }</td>
						<td><c:forEach items="${statusList }" var="i">
								<c:if test="${item.status == i.id }">${i.name }</c:if>
							</c:forEach></td>
						<td>${item.userId }</td>
						<td>${item.createTime }</td>
						<td><a href="/procedure/toUpdate?planId=${item.id }">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
							href="/procedure/toGoodsManager?planId=${item.id }&status=${item.status}">原料配置</a></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
<!-- 全局js -->
<script src="/js/jquery.min.js?v=2.1.4"></script>
<script src="/js/bootstrap.min.js?v=3.3.6"></script>
<script src="/js/plugins/jeditable/jquery.jeditable.js"></script>
<!-- Data Tables -->
<script src="/js/plugins/dataTables/jquery.dataTables.js"></script>
<script src="/js/plugins/dataTables/dataTables.bootstrap.js"></script>
<!-- 自定义js -->
<script src="/js/content.js?v=1.0.0"></script>
</html>