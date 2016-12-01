<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
   <link rel="shortcut icon" href="favicon.ico"> <link href="/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <!-- Data Tables -->
    <link href="/css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">

    <link href="/css/animate.css" rel="stylesheet">
    <link href="/css/style.css?v=4.1.0" rel="stylesheet">
</head>
<body>
	<div class="ibox-content">

		<table
			class="table table-striped table-bordered table-hover dataTables-example">
			<thead>
				<tr>
					<th>id</th>
					<th>名字</th>
					<th>创建时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listData }" var="item">
					<tr>
						<td>${item.id }</td>
						<td>${item.name }</td>
						<td>${item.createTime }</td>
						<td><a href="/procedure/toUpdate?id=${item.id }">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="/procedure/delete?id=${item.id }" onclick="if(confirm('确认删除吗？')==false)return false;">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="/procedure/toDetail?id=${item.id }">详细</a></td>
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