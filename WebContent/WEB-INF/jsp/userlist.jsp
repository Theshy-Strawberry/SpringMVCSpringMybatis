<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script>

$(function(sss){
		var ser=$("#baochi").val();
	$("#search").keyup(function(){
		var searchKey=$("#search").val();
		alert("ss");
		$.ajax(
			{
				url:'searckByKey',
				data:{key:searchKey},
				success:function(data){
				//	var json=eval(data);
					alert("success");
					location.reload(); 
					
				}
			}				
		)
	});
	$("#searchkey").click(
			function(){
				var key = $("#key").val();
				window.location.href='ByKey?key='+key;
			}			
	);
	
/* 	$("[name='select']").bind("click", function() {
		var bool = false;
		$("[name='select']").each(function() {
			if ($(this).prop("checked") == true) {
				bool = false;
				return false;
			} else {
				bool = true;
			}
		});
		document.getElementById("delete").disabled = bool;
	}); */
	
	//delete按钮是否可用
	$("[name='select']").click(
		function(){
			var flag = true;
			$("[name='select']").each(function(){
				
				if($(this).prop("checked")==true){
		
					flag=false;			
					return  false;
				}
			});
			$("#delete").attr("disabled",flag);
		}		
	)
	//全选的checkbox
	$("#selectAll").click(function(){
		if ($(this).prop("checked") == true) {
			$("[name='select']").prop("checked", true);
			$("#delete").attr("disabled",false); 
		} else {
			$("[name='select']").prop("checked", false);
			$("#delete").attr("disabled",true); 
		}
	}
	);
	
	// 删除操作
	$("#delete").click(function(){
		var name ="";
		$("[name='select']").each(function(){
		
			if($(this).prop("checked")==true){
				name+= $(this).parent().next().children().val()+",";
			}
		})
		
			$.ajax({
				url :'deletes',
				data :{ name:name},
				type:'post',
				success : function(data) {
					alert(data);
					var temp = JSON.parse(data);
					alert(temp);
					if(data=='true'){
					alert("删除成功");
					}else{
						alert("删除失败");
					}
					window.location.href="alluser";
				}
			  }
			);
		
		
		
	});
	
}
)
</script>
</head>
<body><span class="label label-success">
筛选<input type="text" id="search" >
</span>


<div class="panel panel-default">
  <!-- Default panel contents -->

  <div class="page-header">
  <h1><small>所有的成员 </small>哟</h1>
</div>
  <div class="panel-body">
    <p><input type="text" name="key" id="key">
		<input type="hidden" id="baochi" value="${key}"/>	
 <button type="button" class="btn btn-info"  id= "searchkey" >搜索</button></p>
  </div>

  <!-- Table -->
  <table class="table" border="1px">
    <tr class="success">
<td>选择</td>
<td>商品名</td>
<td>code</td>
<td>价格</td>
<td colspan="2">操作</td>

</tr>
<c:forEach items="${userlist}" var="user" >

<tr class="danger">
<form action="update" method="post">
	   <td><input type="checkbox" name="select"  id="select"></td>
       <td> <input type="text" name="name" value="${user.name}" style="border:0px;background-color:#f2dede" readonly="readonly"/> </td>
       <td> <input type="text" name="pwd"  value="${user.pwd}"  style="border:0px;background-color:#f2dede" /> </td>
       <td> <input type="text" name="sex"  value="${user.sex}"  style="border:0px;background-color:#f2dede" /> </td>
       <td> <input type="submit" class="btn btn-warning" value="修改"> </td>
       <!-- <td> <button onclick="javascript:window.location.href='delete'">删除</button> </td> -->
       <td> <input type="button" value="删除" class="btn btn-danger" onclick="javascript:window.location.href='delete?name=${user.name}'"/ > </td>
</form>                     
</tr>
</c:forEach>
  </table>
</div>

<div><table>
<tr><td style="border:0px;"> &nbsp;</td><td style="border:0px;">
					 <div class="checkbox">
					     <label><input type="checkbox"  id="selectAll">全选</label>
 					 </div>
	</td>
				<td> &nbsp;
					<input type="button" value="删除" class="btn btn-red" id="delete" disabled/>
				</td></tr>
  </table>
</div>

<div id="hid"></div>
<button id ="back" onclick="javascript:history.go(-1)" class="btn btn-success" >返回</button>
<%--   <p><c:out value="${greetings}" /> </p>
  <p><c:out value="${test}" /> </p>

  ==============an=========
    <c:forEach items="${tara}" var="t">
<p>${t }</p>
</c:forEach> --%>
</body>















<%-- <table border="1px">
<tr>
<td>姓名</td>
<td>密码</td>
<td>性别</td>
</tr>
<c:forEach items="${userList}" var="user" >

<tr>
<form action="update" method="post">
       <td class="list-group-item list-group-item-success"> <input type="text" name="name" value="${user.name}" style="border:0px" readonly="readonly"/> </td>
       <td class="list-group-item"> <input type="text" name="pwd"  value="${user.pwd}"  style="border:0px" /> </td>
       <td> <input type="text" name="sex"  value="${user.sex}"  style="border:0px" /> </td>
       <td> <input type="submit" value="修改"> </td>
       <!-- <td> <button onclick="javascript:window.location.href='delete'">删除</button> </td> -->
       <td> <input type="button" value="删除" onclick="javascript:window.location.href='delete?name=${user.name}'"/ > </td>
</form>                     
</tr>
</c:forEach>

</table> --%>

</html>