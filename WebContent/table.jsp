<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="layui//css/layui.css" media="all"/>
</head>
<body>
	<div class="layui-btn-group demoTable">
		<button class="layui-btn" data-type="getCheckData">获取选中行</button>
		<button class="layui-btn" data-type="getCheckLength">获取选中数量</button>
		<button class="layui-btn" data-type="isAll">是否全选</button>
	</div>
    <table class="layui-hide" id="test" lay-filter="demo"></table>

<script src="layui/layui.js"></script>
    <script>
        layui.use('table', function(){
            var table = layui.table;
			//方法渲染（加载表）
            table.render({
                elem: '#test'
                ,url:'TableServlet'
                ,cols: [[
                	{fixed:'left',type:'checkbox'}
                    ,{field:'uname', width:100, title: '用户名'}
                    ,{field:'utruename', width:110, title: '真实姓名'}
                    ,{field:'ugender', width:80, title: '性别'}
                    ,{field:'upassword', width:80, title: '密码'}
                    ,{field:'uidentity', width:210, title: '身份证号'}
                    ,{field:'uemail', width:210, title: '邮箱'}
                    ,{field:'uborn', width:140, title: '出生年月'}
                    ,{field:'uphone', width:140, title: '手机号'}
                    ,{field:'upicture', width:135, title: '头像'}
                    ,{width:170,align:'center',toolbar:'#barDemo'}
                ]]
                ,page: true
                ,id:'isTest'
            });
            //监听工具条
            table.on('tool(demo)',function(obj){
            	var data = obj.data;
            	var event = obj.event;
            	if(event=='detail'){
            		layer.alert(data.uname);//查看
            	}else if(event=='edit'){
            		layer.alert("编辑");//编辑
            		
            	}else if(event=='del'){//删除
            		layer.confirm('真的要删除吗',function(index){
            			obj.del();//删除对应行（tr）的DOM结构，并更新缓存
            			layer.close(index);//关闭弹出来的窗口
            		})
            	}
            });
            
            var $=layui.$,active={
            	getCheckData:function(){
            		var checkStatus = table.checkStatus('isTest')
            		,data = checkStatus.data;
            		layer.alert(JSON.stringify(data));
            	}
            	,getCheckLength:function(){
            		var checkStatus = table.checkStatus('isTest')
            		,data = checkStatus.data;
            		layer.alert('数量：'+data.length);
            	}
            	,isAll:function(){
            		var checkStatus = table.checkStatus('isTest');
            		layer.alert(checkStatus.isAll?'全选':'未全选');
            		
            	}
            };
            $('.demoTable .layui-btn').on('click', function(){
                var type = $(this).data('type');
                active[type] ? active[type].call(this) : '';
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