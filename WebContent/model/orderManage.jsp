<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">

<head>
	<title>订单管理</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!-- VENDOR CSS -->
	<link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/vendor/linearicons/style.css">
	<!-- MAIN CSS -->
	<link rel="stylesheet" href="assets/css/main.css">
	<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
	<link rel="stylesheet" href="assets/css/demo.css">
	<!-- GOOGLE FONTS -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
	<!-- ICONS -->
	<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
	
	<link rel="stylesheet" href="../layui//css/layui.css" media="all"/>
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<!-- 导航 -->
		<nav class="navbar navbar-default navbar-fixed-top">
			<!-- 最左上角图标-->
			<div class="brand">
				<a href="index.html"><img src="assets/img/logo-dark.png" alt="Klorofil Logo" class="img-responsive logo"></a>
			</div>

			<div class="container-fluid">
				<!-- 傍边的小箭头，可以收放左边的菜单栏-->
				<div class="navbar-btn">
					<button type="button" class="btn-toggle-fullwidth"><i class="lnr lnr-arrow-left-circle"></i></button>
				</div>
				<!-- 搜索框-->
				<form class="navbar-form navbar-left">
					<div class="input-group">
						<input type="text" value="" class="form-control" placeholder="搜索...">
						<span class="input-group-btn"><button type="button" class="btn btn-primary">Go</button></span>
					</div>
				</form>
				<!-- 右上角的绿色按钮-->
				<div class="navbar-btn navbar-btn-right">
					<a class="btn btn-success update-pro" href="#downloads/klorofil-pro-bootstrap-admin-dashboard-template/?utm_source=klorofil&utm_medium=template&utm_campaign=KlorofilPro" title="Upgrade to Pro" target="_blank"><i class="fa fa-rocket"></i> <span>刷新</span></a>
				</div>
				<!-- 有下拉列表的-->
				<div id="navbar-menu">
					<ul class="nav navbar-nav navbar-right">
						<!-- 消息提示-->
						<li class="dropdown">
							<ul class="dropdown-menu notifications">
								<li><a href="#" class="notification-item"><span class="dot bg-warning"></span>系统消息</a></li>
								<li><a href="#" class="notification-item"><span class="dot bg-danger"></span>未处理通知</a></li>
								<li><a href="#" class="notification-item"><span class="dot bg-success"></span>订单更新</a></li>
								<li><a href="#" class="notification-item"><span class="dot bg-warning"></span>人员变动</a></li>
								<li><a href="#" class="notification-item"><span class="dot bg-success"></span>新的任务</a></li>
								<li><a href="#" class="more">查看所有消息</a></li>
							</ul>
						</li>
						<!-- 中间的help-->
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="lnr lnr-question-circle"></i> <span>Help</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
							<ul class="dropdown-menu">
								<li><a href="#">基本用法</a></li>
								<li><a href="#">工作时间</a></li>
								<li><a href="#">安全信息</a></li>
								<li><a href="#">操作指南</a></li>
							</ul>
						</li>
						<!-- 用户-->
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="assets/img/user.png" class="img-circle" alt="Avatar"> <span>${employee.ename }</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
							<ul class="dropdown-menu">
								<li><a href="page-login.jsp"><i class="lnr lnr-exit"></i> <span>注销</span></a></li>
							</ul>
						</li>
						<!-- <li>
							<a class="update-pro" href="#downloads/klorofil-pro-bootstrap-admin-dashboard-template/?utm_source=klorofil&utm_medium=template&utm_campaign=KlorofilPro" title="Upgrade to Pro" target="_blank"><i class="fa fa-rocket"></i> <span>UPGRADE TO PRO</span></a>
						</li> -->
					</ul>
				</div>
			</div>
		</nav>
		<!-- 导航结束 -->
		<!-- 左边菜单栏 -->
		<div id="sidebar-nav" class="sidebar">
			<div class="sidebar-scroll">
				<nav>
					<ul class="nav">
						<li><a href="index.jsp" class=""><i class="lnr lnr-home"></i> <span>主页</span></a></li>
						<c:forEach var="emjur" items="${emjurlist }" varStatus="i">
							<c:if test="${emjur.jid eq 1}">
								<li><a href="userManage.jsp" class=""><i class="lnr lnr-code"></i> <span>用户管理</span></a></li>
							</c:if>
							<c:if test="${emjur.jid eq 2}">
								<li><a href="orderManage.jsp" class="active"><i class="lnr lnr-chart-bars"></i> <span>订单管理</span></a></li>
							</c:if>
							<c:if test="${emjur.jid eq 3}">
								<li><a href="roomManage.jsp" class=""><i class="lnr lnr-cog"></i> <span>房间管理</span></a></li>
							</c:if>
							<c:if test="${emjur.jid eq 4}">
								<li><a href="commentManage.jsp" class=""><i class="lnr lnr-alarm"></i> <span>评论管理</span></a></li>
							</c:if>
							<c:if test="${emjur.jid eq 5}">
								<li><a href="employeeManage.jsp" class=""><i class="lnr lnr-text-format"></i> <span>成员管理</span></a></li>
							</c:if>
						</c:forEach>
					</ul>
				</nav>
			</div>
		</div>
		<!-- 左边菜单结束 -->
		<!-- MAIN -->
		<div class="main">
			<!-- 主要内容 -->
			<div class="main-content">
				<div class="container-fluid">
					<h3 class="page-title">订单管理</h3>
						<form class="layui-form" action="" id="orderform" lay-filter="userEdit">
							<div class="layui-form-item">
								<div class="layui-inline">
									<label class="layui-form-label">订单号</label>
									<div class="layui-input-inline">
										<input type="text" name="oid"
											autocomplete="off" placeholder="搜索订单号" class="layui-input">
									</div>
								</div>
								<div class="layui-inline">
									<label class="layui-form-label">房间号</label>
									<div class="layui-input-inline">
										<input type="text" name="rid"
											autocomplete="off" placeholder="搜索房间号" class="layui-input">
									</div>
								</div>
								<div class="layui-inline">
									<label class="layui-form-label">用户id</label>
									<div class="layui-input-inline">
										<input type="text" name="uid"
											autocomplete="off" placeholder="搜索用户id" class="layui-input">
									</div>
								</div>
								<div class="layui-inline">
									<label class="layui-form-label">员工id</label>
									<div class="layui-input-inline">
										<input type="text" name="eid"
											autocomplete="off" placeholder="搜索员工id" class="layui-input">
									</div>
								</div>
								<div class="layui-inline">
									<label class="layui-form-label">价格</label>
									<div class="layui-input-inline">
										<input type="text" name="eprice"
											autocomplete="off" placeholder="搜索价格" class="layui-input">
									</div>
								</div>
								<div class="layui-inline">
									<label class="layui-form-label">状态</label>
									<div class="layui-input-inline">
										<input type="text" name="status"
											autocomplete="off" placeholder="搜索状态" class="layui-input">
									</div>
								</div>
								<div class="layui-inline">
									<label class="layui-form-label">入住日期</label>
									<div class="layui-input-inline">
										<input type="text" name="starttime"
											autocomplete="off" placeholder="搜索入住日期" class="layui-input date-item">
									</div>
								</div>
								<div class="layui-inline">
									<label class="layui-form-label">离开日期</label>
									<div class="layui-input-inline">
										<input type="text" name="endtime"
											autocomplete="off" placeholder="搜索离开日期" class="layui-input date-item">
									</div>
								</div>
								<div class="layui-inline">
									<label class="layui-form-label">预定日期</label>
									<div class="layui-input-inline">
										<input type="text" name="booktime"
											autocomplete="off" placeholder="搜索预定日期" class="layui-input date-item">
									</div>
								</div>
								
								<div class="layui-inline">
									<button class="layui-btn" lay-submit="" lay-filter="finish">搜索</button>
								</div>
							</div>
						</form>
						<table class="layui-hide" id="orderTable" lay-filter="demo"></table>
				</div>
			</div>
			<!-- END MAIN CONTENT -->
		</div>
	</div>
	<!-- END WRAPPER -->
	<!-- Javascript -->
	<script src="assets/vendor/jquery/jquery.min.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="assets/scripts/klorofil-common.js"></script>
	<script src="../layui/layui.js"></script>
	
	<script type="text/javascript">
		layui.use(['table','form','laydate'],function(){
			var table = layui.table
			,form = layui.form
			,laydate = layui.laydate;
			
			lay('.date-item').each(function(){
			    laydate.render({
			      elem: this
			      ,trigger: 'click'
			    });
			});
			
			var orderTable = table.render({
				elem:'#orderTable'
				,url:'../ShowOrderServlet'
				,cols:[[
					{field:'oid', width:90, title: '订单id',sort: true}
                    ,{field:'rid', width:90, title: '房间号',sort: true}
                    ,{field:'uid', width:90, title: '用户id',sort: true}
                    ,{field:'eid', width:70, title: '员工id'}
                    ,{field:'starttime', width:150, title: '入住时间'}
                    ,{field:'endtime', width:150, title: '离开时间'}
                    ,{field:'eprice', width:120, title: '价格（元）',sort: true}
                    ,{field:'status', width:100, title: '状态'}
                    ,{field:'booktime', width:150, title: '预定时间'}
                    ,{field:'remark', width:120, title: '备注'}
                    ,{title:'操作',fixed:'right',width:170,align:'center',toolbar:'#barDemo'}
				]]
				,page:true
			});
			
			//搜索
			form.on('submit(finish)', function(data){
				var a = JSON.stringify(data.field);
				var sss = JSON.parse(a);//将格式解析为json格式。
				//console.log(sss);
				orderTable.reload({
					url:'../LikeQueryOrderServlet'
					,where:sss
					,page:{
						curr:1
					}
				}); 
			    return false;
			});
			
			 //监听工具条
	        table.on('tool(demo)',function(obj){
	        	var data = obj.data;
	        	var event = obj.event;
	        	if(event=='detail'){//查看
	        		var ss = "订单id："+data.oid+"<br/>房间号："+data.rid
	        		+"<br/>用户id："+data.uid+"<br/>员工id："+data.eid
	        		+"<br/>入住时间："+data.starttime+"<br/>离开时间："+data.endtime
	        		+"<br/>价格（元）："+data.eprice+"<br/>状态："+data.status
	        		+"<br/>预定时间："+data.booktime+"<br/>备注："+data.remark;
	        		layer.alert(ss);
	        	}else if(event=='edit'){//编辑
	        		var parameters = "oid="+data.oid+"&rid="+data.rid+"&uid="+data.uid+"&eid="+data.eid
	        		+"&starttime="+data.starttime+"&endtime="+data.endtime+"&eprice="+data.eprice
	        		+"&status="+data.status+"&booktime="+data.booktime+"&remark="+data.remark;
	        		//layer.alert("orderManageEdit.jsp?"+parameters);
	        		window.location.href="orderManageEdit.jsp?"+parameters;
	        		
	        	}else if(event=='del'){//删除
	        		layer.confirm('真的要删除吗',function(index){
	        			
	        			$.getJSON("../DelOrderServlet",{"oid":data.oid},function(data){
	        				if(data.result=="成功"){
	        					obj.del();//删除对应行（tr）的DOM结构，并更新缓存
	    	        			layer.close(index);//关闭弹出来的窗口
	        				}else{
	        					layer.alert("失败");
	        				}
	        			})
	        		})
	        	}
	        });
		});
		
		
	</script>
	
	<script type="text/html" id="barDemo">
		<a class="layui-btn layui-btn-primary  layui-btn-xs" lay-event="detail">查看</a>
  		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
</body>

</html>
