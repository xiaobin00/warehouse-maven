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
<link href="/css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="/css/animate.css" rel="stylesheet">
<link href="/css/style.css?v=4.1.0" rel="stylesheet">
</head>
<script type="text/javascript">
$(document).ready(function(){ 
	alert("数据有误")
	var tip = "${tip}";
	if(tip != ""){
		alert(tip)
	}
}); 

function myfun()
{
    alert("this window.onload");
}
</script>
<body class="gray-bg">
<c:if test="${tip != null}">
<div class="alert alert-danger">
     ${tip}
</div>
</c:if>
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
			<div class="ibox float-e-margins">
			 <div class="ibox-title">
                        <h5>物品添加 <small></small></h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="form_basic.html#">选项1</a>
                                </li>
                                <li><a href="form_basic.html#">选项2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
			
				<div class="ibox float-e-margins">
					<form method="get" action="/goods/add" class="form-horizontal">
						<input type="hidden" name="parentId" value="${parentId }">
						<div class="form-group" style="margin-left: 15px;margin-right: 15pc">
							<div style="margin-top: 5px"></div>
							<label class="col-sm-2 control-label">名称:</label>

							<div class="col-sm-10">
								<select class="form-control m-b" name="name">
                                       <c:forEach items="${baseGoodsInfos }" var="info">
                                        <option value="${info.name }">${info.name }</option>
										</c:forEach>
                                    </select>
							</div>
							</div>
							
							<div class="form-group"  style="margin-left: 15px;margin-right: 15pc">
							<div style="margin-top: 5px"></div>
							<label class="col-sm-2 control-label">记录类型：</label>

							<div class="col-sm-10">
								<select class="form-control m-b" name="type">
                                       <c:forEach items="${typeList }" var="type">
                                        <option value="${type.id }">${type.name }</option>
										</c:forEach>
                                    </select>
							</div>
						</div>
						<div class="form-group"  style="margin-left: 15px;margin-right: 15pc">
							<div style="margin-top: 5px"></div>
							<label class="col-sm-2 control-label">数量：</label>

							<div class="col-sm-10">
								<input type="number" name="count" id="count" onchange="translation()"> 
							</div>
						</div>
						
						<div class="form-group"  style="margin-left: 15px;margin-right: 15pc">
							<div style="margin-top: 5px"></div>
							<label class="col-sm-2 control-label">价格(单位：分)：</label>

							<div class="col-sm-10">
								<input type="number" name="price" id="price" onchange="translation()"> <nobr id="priceYuan">0元</nobr>
							</div>
						</div>
						
						<div class="form-group"  style="margin-left: 15px;margin-right: 15pc">
							<div style="margin-top: 5px"></div>
							<label class="col-sm-2 control-label">总价格(单位：分)：</label>

							<div class="col-sm-10">
								<input type="number" name="tatolPrice" id="tatolPrice" readonly="true"> <nobr id="tatolPriceYuan">0元</nobr>
							</div>
						</div>
						
						<div class="form-group"  style="margin-left: 15px;margin-right: 15pc">
							<div style="margin-top: 5px"></div>
							<label class="col-sm-2 control-label">规格：</label>

							<div class="col-sm-10">
								<textarea rows="2" cols="21" name="specifications"></textarea>
							</div>
						</div>
						
						<div class="form-group"  style="margin-left: 15px;margin-right: 15pc">
							<div style="margin-top: 5px"></div>
							<label class="col-sm-2 control-label">详情：</label>

							<div class="col-sm-10">
								<textarea rows="5" cols="21" name="describe"></textarea>
							</div>
						</div>
						
						  <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <button class="btn btn-primary" type="submit">保存内容</button>
                                    <button class="btn btn-white" type="submit">取消</button>
                                </div>
                            </div>
					</form>
				</div>
				</div>
			</div>
		</div>
	</div>
</body>
<!-- 全局js -->
<script src="/js/jquery.min.js?v=2.1.4"></script>
<script src="/js/bootstrap.min.js?v=3.3.6"></script>

<!-- 自定义js -->
<script src="/js/content.js?v=1.0.0"></script>

<!-- iCheck -->
<script src="/js/plugins/iCheck/icheck.min.js"></script>
<script type="text/javascript">
function translation() {
	var price = $("#price").val();
	var count = $("#count").val();
	if(count != "" && price != ""){
		$("#tatolPrice").val(price*count);
		$("#tatolPriceYuan").html(price/100*count+"元");
	}else{
		$("#tatolPrice").val(0);
		$("#tatolPriceYuan").html("0元");
	}
	if(price != ""){
		 $("#priceYuan").html(price/100+"元");
	}
}

</script>

</html>