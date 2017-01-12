<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@page import="light.mvc.model._enum.GoodsDealType"%>
<%
request.setAttribute("typeList", GoodsDealType.values());
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
			<c:if test="${status <= 0 }">
				<form role="form" class="form-inline" action="/procedure/addGoods">
					<input type="hidden" name="planId" value="${planId }">
					<div class="form-group">
						<label for="exampleInputEmail2" class="sr-only">物品名</label> <select
							class="form-control" name="goodsInfo" placeholder="选择物品">
							<c:forEach items="${baseGoodsInfos }" var="item">
								<option value="${item.id }-${item.name }">${item.name }</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword2" class="sr-only">出入库类型</label> <input
							type="number" name="count" placeholder="数量">
					</div>
					<button class="btn btn-white" type="submit">添加</button>
				</form>
			</c:if>
		</div>
		<table
			class="table table-striped table-bordered table-hover dataTables-example">
			<thead>
				<tr>
					<th>id</th>
					<th>名字</th>
					<th>数量</th>
					<th>创建人</th>
					<th>创建时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${goodsRecordInfos }" var="item">
					<tr>
						<td>${item.id }</td>
						<td>${item.name }</td>
						<td>${item.count }</td>
						<td>${item.userId }</td>
						<td>${item.createTime }</td>
						<td><a href="/goods/toAdd?parentId=${planId}">出库</a>&nbsp;&nbsp;&nbsp;&nbsp;
							<c:if test="${status <= 0 }">
								<a href="/procedure/delGoods?id=${item.id }&planId=${planId}"
									onclick="if(confirm('确认删除吗？')==false)return false;">删除</a></td>
						</c:if>
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