<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
$("#sub").click(function(){
	var num="";
	$("input[name='fruit']").each(function(){
		if($(this).is(':checked')){
			num+=$(this).val();
		}
	})
	$("#checkList").val(num);
	$("#fm").submit();
})
})
</script>
</head>
<body >
<!-- <div align=center   style="margin-top:200px">
<form action="insert" method="post">
姓名
<input type="text" name = "name"/><br/>
密码
<input type="text" name = "pwd"/><br/>
性别


<input type="text" name = "sex"/><br/>

<input type="submit" value ="添加"/> 
<button id ="back" onclick="javascript:history.go(-1)">返回</button>
</form>
</div> -->
<nav class="navbar navbar-default" role="navigation" align="center">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">
        <img class="img-responsive" alt="Brand" src="images/god.jpg">
      </a>
    </div>
  </div>
</nav>

<span class="label label-success">========================华丽丽的分割线=========================</span><br><br>
<form action="insert" method="post" id="fm">
<div class="input-group">
  <span class="input-group-addon">选择</span>
 <label><input name="fruit" type="checkbox" value="1" />苹果 </label>
<label><input name="fruit" type="checkbox"  value="2"/>桃子 </label>
<label><input name="fruit" type="checkbox"  value="3"/>香蕉 </label>
<label><input name="fruit" type="checkbox"  value="4"/>梨 </label>
<input type="hidden" id = "checkList" name="checkList"/>
</div>
<div class="input-group">
  <span class="input-group-addon">商品id</span>
  <input type="text" name="id" class="form-control" placeholder="输入姓名">
</div>

<div class="input-group">
  <span class="input-group-addon">商品名</span>
  <input type="text" name="name" class="form-control" placeholder="输入密码">
</div>

<div class="input-group">
  <span class="input-group-addon">商品价格</span>
  <input type="text" name="price" class="form-control" placeholder="输入性别">
</div>

 <button type="button" class="btn btn-default" id="sub"><span class="glyphicon glyphicon-fire"></span>添加</button>
 <button type="button" class="btn btn-default navbar-btn" onclick="javascript:history.go(-1)"><span class="glyphicon glyphicon-arrow-left"></span>返回</button>
</form>

</body>
</html>