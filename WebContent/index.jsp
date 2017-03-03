<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
 	<script type="text/javascript">
 		function startTime(){
 			//每隔1秒钟执行updateTime()方法
 			window.setInterval("updateTime()",1000);
 		}
 		function updateTime(){
 			//取得当前时间
 			var date = new Date();
 			//取得当前时间的本地描述信息
 			var msg = date.toLocaleString();
 			//定位spanID所指定的区域
 			var spanElement = document.getElementById("spanID");
 			//将信息写入span标签内部[JS大小写是不同的含义]
 			spanElement.innerHTML = msg;
 		}
 	</script>
 </head>
 <body onload="startTime()">
    
    你的IP地址：${requestScope.ip}<br/>
    归属地：${requestScope.address}<br/>
    当前流量,即访问当前jsp的次数：${requestScope.counter}<br/>
    当前时间：<span id="spanID"></span>
  </body>
</html>
