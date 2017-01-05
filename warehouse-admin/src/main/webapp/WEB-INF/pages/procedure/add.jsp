<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
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
		<div class="alert alert-danger">${tip}</div>
	</c:if>
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>
							生产计划添加 <small></small>
						</h5>
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a> <a class="dropdown-toggle" data-toggle="dropdown"
								href="form_basic.html#"> <i class="fa fa-wrench"></i>
							</a>
							<ul class="dropdown-menu dropdown-user">
								<li><a href="form_basic.html#">选项1</a></li>
								<li><a href="form_basic.html#">选项2</a></li>
							</ul>
							<a class="close-link"> <i class="fa fa-times"></i>
							</a>
						</div>
					</div>

					<div class="ibox float-e-margins">
						<form method="get" action="/procedure/add" class="form-horizontal">
							<div class="form-group"
								style="margin-left: 15px; margin-right: 15pc">
								<div style="margin-top: 5px"></div>
								<label class="col-sm-2 control-label">名称:</label>

								<div class="col-sm-10">
									<input type="text" class="form-control" style="width: 20%"
										name="name">
								</div>
							</div>

							<div class="form-group"
								style="margin-left: 15px; margin-right: 15pc">
								<div style="margin-top: 5px"></div>
								<label class="col-sm-2 control-label">选择流程：</label>

								<div class="col-sm-10">
									<select class="form-control m-b" name="procedureId" style="width: 20%">
										<option value="0">==请选择==</option>
										<c:forEach items="${procedures }" var="item">
											<option value="${item.id }">${item.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group"
								style="margin-left: 15px; margin-right: 15pc">
								<div style="margin-top: 5px"></div>
								<label class="col-sm-2 control-label">数量：</label>

								<div class="col-sm-10">
									<input type="number" name="count" class="form-control"
										style="width: 20%">
								</div>
							</div>

							<div class="form-group"
								style="margin-left: 15px; margin-right: 15pc">
								<div style="margin-top: 5px"></div>
								<label class="col-sm-2 control-label">进度：</label>

								<div class="col-sm-10">
								<select class="form-control m-b" name="percentage" style="width: 20%">
										<option value="0">0%</option>
										<option value="10">10%</option>
										<option value="20">20%</option>
										<option value="30">30%</option>
										<option value="40">40%</option>
										<option value="50">50%</option>
										<option value="60">60%</option>
										<option value="70">70%</option>
										<option value="80">80%</option>
										<option value="90">90%</option>
										<option value="100">100%</option>
									</select>
									
								</div>
							</div>

							<div class="form-group"
								style="margin-left: 15px; margin-right: 15pc">
								<div style="margin-top: 5px"></div>
								<label class="col-sm-2 control-label">开始时间：</label>

								<div class="col-sm-10">
									<input placeholder="开始日期" class="form-control layer-date"
										id="start" style="width: 20%" name="startTime">
								</div>
							</div>

							<div class="form-group"
								style="margin-left: 15px; margin-right: 15pc">
								<div style="margin-top: 5px"></div>
								<label class="col-sm-2 control-label">结束时间：</label>

								<div class="col-sm-10">
									<input placeholder="结束日期" class="form-control layer-date"
										id="end" style="width: 20%" name="endTime">
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
<!-- layerDate plugin javascript -->
<script src="/js/plugins/layer/laydate/laydate.js"></script>
<script type="text/javascript">
//日期范围限制
var start = {
    elem: '#start',
    format: 'YYYY/MM/DD hh:mm:ss',
    min: laydate.now(), //设定最小日期为当前日期
    max: '2099-06-16 23:59:59', //最大日期
    istime: true,
    istoday: false,
    choose: function (datas) {
        end.min = datas; //开始日选好后，重置结束日的最小日期
        end.start = datas //将结束日的初始值设定为开始日
    }
};
var end = {
    elem: '#end',
    format: 'YYYY/MM/DD hh:mm:ss',
    min: laydate.now(),
    max: '2099-06-16 23:59:59',
    istime: true,
    istoday: false,
    choose: function (datas) {
        start.max = datas; //结束日选好后，重置开始日的最大日期
    }
};
laydate(start);
laydate(end);


function addGoods(){
	
}
</script>
</html>