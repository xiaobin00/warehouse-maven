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
<link href="../css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
<link href="../css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="../css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="../css/animate.css" rel="stylesheet">
<link href="../css/style.css?v=4.1.0" rel="stylesheet">
</head>
<style>
.line-height {
	line-height: 86px;
}
</style>
<body class="gray-bg">
<div class="wrapper wrapper-content">
	 <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>流程设置</h5>
                    </div>
                    <div class="ibox-content">

                        <p>通过下表设置每个流程所需要的工序以及工序的次序</p>
                        <div class="table-responsive">
                        <form ethod="post" action="/procedure/updateDetail">
                            <table class="table table-bordered ">
                                <thead>
                                    <tr>
                                        <th>流程</th>
                                        <th>
                                        	 流程次序
                                        </th>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${procedureDepartments }">
                                    <tr>
                                    	
                                        <th class="text-nowrap">${item.name }</th>
                                        <td> 
                                      
                                        <input type="number" placeholder="请输入次序" name="${item.id }" class="form-control"></td>
                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                              <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <button class="btn btn-primary" type="submit">保存内容</button>
                                    <button class="btn btn-white" type="reset">重置</button>
                                </div>
                            </div>
                            </form>
                        </div>


                    </div>
                </div>
            </div>

        </div>
        
         <div class="col-sm-12">
                        <div class="ibox float-e-margins">
                        <div class="" id="ibox-content">

                            <div id="vertical-timeline" class="vertical-container light-timeline">
                              
                                <div class="vertical-timeline-block">
                                    <div class="vertical-timeline-icon navy-bg">
                                        <i class="glyphicon glyphicon-arrow-down"></i>
                                    </div>

                                    <div class="vertical-timeline-content">
                                        <h2>会议</h2>
                                    <small>2月3日</small>
                                </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </div>
                    </div>
        </div>
</body>
<!-- 全局js -->
<script src="http://localhost:8080/js/jquery.min.js?v=2.1.4"></script>
<script src="http://localhost:8080/js/bootstrap.min.js?v=3.3.6"></script>

<!-- 自定义js -->
<script src="http://localhost:8080/js/content.js?v=1.0.0"></script>

<!-- iCheck -->
<script src="http://localhost:8080/js/plugins/iCheck/icheck.min.js"></script>
</html>