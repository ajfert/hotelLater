<%@page import="com.bdqn.pojo.Employee"%>
<%@page import="com.bdqn.util.NewComment"%>
<%@page import="java.util.List"%>
<%@page import="com.bdqn.service.CommentService"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.bdqn.util.Week"%>
<%@page import="java.util.Date"%>
<%@page import="com.bdqn.pojo.User"%>
<%@page import="com.bdqn.service.UserService"%>
<%@page import="com.bdqn.dao.impl.UserDaoImpl"%>
<%@page import="com.bdqn.pojo.Order"%>
<%@page import="com.bdqn.util.Page"%>
<%@page import="com.bdqn.service.OrderService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<head>
	<title>Home</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!-- VENDOR CSS -->
	<link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/vendor/linearicons/style.css">
	<link rel="stylesheet" href="assets/vendor/chartist/css/chartist-custom.css">
	<!-- MAIN CSS -->
	<link rel="stylesheet" href="assets/css/main.css">
	<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
	<link rel="stylesheet" href="assets/css/demo.css">
	<!-- GOOGLE FONTS -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
	<!-- ICONS -->
	<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
</head>

<%
	OrderService os = new OrderService();
	UserService us = new UserService();
	CommentService cs = new CommentService();
	
	int allprice = os.getAllprice();
	Page<Order> p = os.paging(1, 5);
	request.setAttribute("po", p);
	
	request.setAttribute("olist", p.getData());
	//通过今天的日期得到week对象
	Date date = new Date();
	Week week = os.getWeekFromDay(date);
	request.setAttribute("week", week);
	int[] thisWeek = week.getThisweek();
	int thisWeekprice = 0;
	for(int i = 0;i<thisWeek.length;i++){
		thisWeekprice = thisWeekprice+thisWeek[i];
	}
	
	//评论
	List<NewComment> newclist = cs.selectNew(1, 5);
	request.setAttribute("newclist", newclist);
	
	Page<User> pu = us.paging(1, 1);
	
	//权限
	
%>


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
						<li><a href="index.jsp" class="active"><i class="lnr lnr-home"></i> <span>主页</span></a></li>
						<c:forEach var="emjur" items="${emjurlist }" varStatus="i">
							<c:if test="${emjur.jid eq 1}">
								<li><a href="userManage.jsp" class=""><i class="lnr lnr-code"></i> <span>用户管理</span></a></li>
							</c:if>
							<c:if test="${emjur.jid eq 2}">
								<li><a href="orderManage.jsp" class=""><i class="lnr lnr-chart-bars"></i> <span>订单管理</span></a></li>
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
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="container-fluid">
					<!-- OVERVIEW -->
					<div class="panel panel-headline">
						<div class="panel-heading">
							<h3 class="panel-title">Weekly Overview</h3>
							<p class="panel-subtitle">2019.4.7-2019.4.21</p>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-3">
									<div class="metric">
										<span class="icon"><i class="fa fa-download"></i></span>
										<p>
											<span class="number"><%=p.getTotle() %></span>
											<span class="title">交易数</span>
										</p>
									</div>
								</div>
								<div class="col-md-3">
									<div class="metric">
										<span class="icon"><i class="fa fa-shopping-bag"></i></span>
										<p>
											<span class="number"><%=allprice %></span>
											<span class="title">交易额</span>
										</p>
									</div>
								</div>
								<div class="col-md-3">
									<div class="metric">
										<span class="icon"><i class="fa fa-eye"></i></span>
										<p>
											<span class="number"><%=pu.getTotle() %></span>
											<span class="title">用户数</span>
										</p>
									</div>
								</div>
								<div class="col-md-3">
									<div class="metric">
										<span class="icon"><i class="fa fa-bar-chart"></i></span>
										<p>
											<span class="number"><%=thisWeekprice %></span>
											<span class="title">周盈利</span>
										</p>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-9">
									<div id="headline-chart" class="ct-chart"></div>
								</div>
								<div class="col-md-3">
									<div class="weekly-summary text-right">
										<span class="number">2,315</span> <span class="percentage"><i class="fa fa-caret-up text-success"></i> 12%</span>
										<span class="info-label">Total Sales</span>
									</div>
									<div class="weekly-summary text-right">
										<span class="number">$5,758</span> <span class="percentage"><i class="fa fa-caret-up text-success"></i> 23%</span>
										<span class="info-label">Monthly Income</span>
									</div>
									<div class="weekly-summary text-right">
										<span class="number">$65,938</span> <span class="percentage"><i class="fa fa-caret-down text-danger"></i> 8%</span>
										<span class="info-label">Total Income</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- END OVERVIEW -->
					<div class="row">
						<div class="col-md-6">
							<!-- 近期交易 -->
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title">近期订单</h3>
									<div class="right">
										<button type="button" class="btn-toggle-collapse"><i class="lnr lnr-chevron-up"></i></button>
										<button type="button" class="btn-remove"><i class="lnr lnr-cross"></i></button>
									</div>
								</div>
								<div class="panel-body no-padding">
									<table class="table table-striped">
										<thead>
											<tr>
												<th>编号</th>
												<th>用户</th>
												<th>金额</th>
												<th>时间</th>
												<th>状态</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="order" items="${requestScope.olist }" varStatus="i">
												<tr>
													<td>${order.oid }</td>
													<td>${order.uid }</td>
													<td>${order.eprice }</td>
													<td>${order.booktime }</td>
													<td>
														<c:if test="${order.status eq '完成' }">
														<span class="label label-success">${order.status }</span>
														</c:if>
														<c:if test="${order.status eq '已预定' }">
														<span class="label label-warning">${order.status }</span>
														</c:if>
														<c:if test="${order.status eq '已删除' }">
														<span class="label label-danger">${order.status }</span>
														</c:if>
													</td>
												</tr>
											</c:forEach>
											
										</tbody>
									</table>
								</div>
								<div class="panel-footer">
									<div class="row">
										<div class="col-md-6"><span class="panel-note"><i class="fa fa-clock-o"></i> Last five</span></div>
										<div class="col-md-6 text-right"><a href="orderManage.jsp" class="btn btn-primary">查看所有的订单</a></div>
									</div>
								</div>
							</div>
							<!-- END 近期交易 -->
						</div>
						<div class="col-md-6">
							<!-- 评论 -->
							<div class="panel panel-scrolling">
								<div class="panel-heading">
									<h3 class="panel-title">近期评论</h3>
									<div class="right">
										<button type="button" class="btn-toggle-collapse"><i class="lnr lnr-chevron-up"></i></button>
										<button type="button" class="btn-remove"><i class="lnr lnr-cross"></i></button>
									</div>
								</div>
								<div class="panel-body">
									<ul class="list-unstyled activity-list">
										<c:forEach var="newComment" items="${newclist }" varStatus="i">
											<li>
												<img src="<%=request.getContextPath()%>/upload/${newComment.upicture }" alt="未上传头像" class="img-circle pull-left avatar">
												<p><a href="#">${newComment.uname }</a> ${newComment.content } <span class="timestamp">${newComment.ctime }</span></p>
											</li>
										</c:forEach>
										
									</ul>
									<button type="button" class="btn btn-primary btn-bottom center-block">查看所有</button>
								</div>
							</div>
							<!-- END 评论 -->
						</div>
						<%-- <div class="col-md-6">
							<!-- 交易右边 -->
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title">每月订单量</h3>
									<div class="right">
										<button type="button" class="btn-toggle-collapse"><i class="lnr lnr-chevron-up"></i></button>
										<button type="button" class="btn-remove"><i class="lnr lnr-cross"></i></button>
									</div>
								</div>
								<div class="panel-body">
									<div id="visits-trends-chart" class="ct-chart"></div>
								</div>
							</div>
							<!-- END 交易右边 -->
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<!-- 交易下面 -->
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title">近期操作</h3>
									<div class="right">
										<button type="button" class="btn-toggle-collapse"><i class="lnr lnr-chevron-up"></i></button>
										<button type="button" class="btn-remove"><i class="lnr lnr-cross"></i></button>
									</div>
								</div>
								<div class="panel-body">
									<ul class="list-unstyled todo-list">
										<li>
											<label class="control-inline fancy-checkbox">
												<input type="checkbox"><span></span>
											</label>
											<p>
												<span class="title">房间变动</span>
												<span class="short-description">新加入房间412</span>
												<span class="date">2019-4-22</span>
											</p>
											<div class="controls">
												<a href="#"><i class="icon-software icon-software-pencil"></i></a> <a href="#"><i class="icon-arrows icon-arrows-circle-remove"></i></a>
											</div>
										</li>
										<li>
											<label class="control-inline fancy-checkbox">
												<input type="checkbox"><span></span>
											</label>
											<p>
												<span class="title">员工变动</span>
												<span class="short-description">新员工小兵加入</span>
												<span class="date">2019-4-20</span>
											</p>
											<div class="controls">
												<a href="#"><i class="icon-software icon-software-pencil"></i></a> <a href="#"><i class="icon-arrows icon-arrows-circle-remove"></i></a>
											</div>
										</li>
										<li>
											<label class="control-inline fancy-checkbox">
												<input type="checkbox"><span></span>
											</label>
											<p>
												<strong>超级管理员</strong>
												<span class="short-description">密码改变</span>
												<span class="date">2019-4-19</span>
											</p>
											<div class="controls">
												<a href="#"><i class="icon-software icon-software-pencil"></i></a> <a href="#"><i class="icon-arrows icon-arrows-circle-remove"></i></a>
											</div>
										</li>
									</ul>
								</div>
							</div>
							<!-- END 交易下面 -->
						</div>
						<div class="col-md-6">
							<!-- 评论 -->
							<div class="panel panel-scrolling">
								<div class="panel-heading">
									<h3 class="panel-title">近期评论</h3>
									<div class="right">
										<button type="button" class="btn-toggle-collapse"><i class="lnr lnr-chevron-up"></i></button>
										<button type="button" class="btn-remove"><i class="lnr lnr-cross"></i></button>
									</div>
								</div>
								<div class="panel-body">
									<ul class="list-unstyled activity-list">
										<c:forEach var="newComment" items="${newclist }" varStatus="i">
											<li>
												<img src="<%=request.getContextPath()%>/upload/${newComment.upicture }" alt="未上传头像" class="img-circle pull-left avatar">
												<p><a href="#">${newComment.uname }</a> ${newComment.content } <span class="timestamp">${newComment.ctime }</span></p>
											</li>
										</c:forEach>
										
									</ul>
									<button type="button" class="btn btn-primary btn-bottom center-block">查看所有</button>
								</div>
							</div> --%>
							<!-- END 评论 -->
						</div>
					</div>
					
				</div>
			</div>
			<!-- END MAIN CONTENT -->
		</div>
		<!-- END MAIN -->
		
	</div>
	<input type="hidden" value=${week.weekname[0] } id="thisw0">
	<input type="hidden" value=${week.weekname[1] } id="thisw1">
	<input type="hidden" value=${week.weekname[2] } id="thisw2">
	<input type="hidden" value=${week.weekname[3] } id="thisw3">
	<input type="hidden" value=${week.weekname[4] } id="thisw4">
	<input type="hidden" value=${week.weekname[5] } id="thisw5">
	<input type="hidden" value=${week.weekname[6] } id="thisw6">
	<!-- END WRAPPER -->
	<!-- Javascript -->
	<script src="assets/vendor/jquery/jquery.min.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
	<script src="assets/vendor/chartist/js/chartist.min.js"></script>
	<script src="assets/scripts/klorofil-common.js"></script>
	<script>
	$(function() {
		var data, options;
		
		// headline charts
		var name = $("#thisw2").val();
		data = {
			labels: [$("#thisw6").val(), $("#thisw5").val(), $("#thisw4").val(), $("#thisw3").val(), $("#thisw2").val(), $("#thisw1").val(), $("#thisw0").val()],
			series: [
				[${requestScope.week.thisweek[6]}, ${requestScope.week.thisweek[5]}, ${requestScope.week.thisweek[4]}, ${requestScope.week.thisweek[3]}, ${requestScope.week.thisweek[2]}, ${requestScope.week.thisweek[1]}, ${requestScope.week.thisweek[0]}],
				[${requestScope.week.previousweek[6]}, ${requestScope.week.previousweek[5]}, ${requestScope.week.previousweek[4]}, ${requestScope.week.previousweek[3]}, ${requestScope.week.previousweek[2]}, ${requestScope.week.previousweek[1]}, ${requestScope.week.previousweek[0]}],
			]
		};

		options = {
			height: 300,
			showArea: true,
			showLine: false,
			showPoint: false,
			fullWidth: true,
			axisX: {
				showGrid: false
			},
			lineSmooth: false,
		};

		new Chartist.Line('#headline-chart', data, options);


		// visits trend charts
		data = {
			labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
			series: [{
				name: 'series-real',
				data: [350, 380, 220, 190, 270, 310, 400, 370, 200, 390, 210, 150],
			}, {
				name: 'series-projection',
				data: [350, 380, 220, 190, 270, 310, 400, 370, 200, 390, 210, 150],
			}]
		};

		options = {
			fullWidth: true,
			lineSmooth: false,
			height: "270px",
			low: 0,
			high: 'auto',
			series: {
				'series-projection': {
					showArea: true,
					showPoint: false,
					showLine: false
				},
			},
			axisX: {
				showGrid: false,

			},
			axisY: {
				showGrid: false,
				onlyInteger: true,
				offset: 0,
			},
			chartPadding: {
				left: 20,
				right: 20
			}
		};

		new Chartist.Line('#visits-trends-chart', data, options);

		// real-time pie chart
		var sysLoad = $('#system-load').easyPieChart({
			size: 130,
			barColor: function(percent) {
				return "rgb(" + Math.round(200*percent/100) + ", " + Math.round(200 * (1.1 - percent/ 100)) + ", 0)";
			},
			trackColor: 'rgba(245, 245, 245, 0.8)',
			scaleColor: false,
			lineWidth: 5,
			lineCap: "square",
			animate: 800
		});

		var updateInterval = 3000; // in milliseconds

		setInterval(function() {
			var randomVal;
			randomVal = getRandomInt(0, 100);

			sysLoad.data('easyPieChart').update(randomVal);
			sysLoad.find('.percent').text(randomVal);
		}, updateInterval);

		function getRandomInt(min, max) {
			return Math.floor(Math.random() * (max - min + 1)) + min;
		}

	});
	</script>
</body>

</html>
