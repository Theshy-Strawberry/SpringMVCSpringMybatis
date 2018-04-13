<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#ajax").click(function(){
		var flag=$("#flag").val();
		$.ajax({
			url:'testAjax',
			data:{a:1,b:flag},
			 //contentType: "application/json", 
			 //dataType:'jason',
			success:function(data){
				//alert(data);
				//here is a bean yo~
	/* 			var obj =eval("(" +data +")");
			var html="<tr><td>序号</td></tr>";
			for(var i=0;i<obj.length;i++){
				html+="<tr><td>"+obj[i]+"</td></tr>";
			}
				$("#tbl").html(html); */
				
				var obj =eval("(" +data +")");
				$.each(obj,function(index,item){
					alert(index);
					alert(item);
				});
				
			/*=======传递list ====================
			java: String json= JSONArray.fromObject(list).toString();
			var json=eval(data);
			alert(json[0]);
			 =====================================*/
			 
			/*=======传递String ====================
			java: response.getWriter().print(str);
			alert(data);
			 =====================================*/
			 
			/*=======传递Map ====================
			java: String json=JSONObject.fromObject(map).toString();
			 
			var obj =eval("(" +data +")");
			alert(obj.list[1]);
			 =====================================*/
			 
				/*=======传递Bean ====================
				java: String json=JSONObject.fromObject(user).toString();
				 
				var obj =eval("(" +data +")");
				alert(obj.name);
				 =====================================*/
		}
			
			
		}
	
	)
	
})
	$("#testre").click(function(){
		var a="1993/01/01";
		a=a.replace(/\//g,"");
		alert("s");
		alert(a);
	})
})

			/* 	{'testAjax'},
				{data:{a:1,b:flag}},
				
				{success:function(data){} 
				
	}*/
</script>
</head>
<body>


<br/>
<br/>
<br/>
<br/>

<div class="row">
  <div class="col-md-12">
<div class="jumbotron">



  <h1>welcome to</h1>
  <p>Summoners' Rift</p>
  <p><a class="btn btn-primary btn-lg" href="#" role="button" onclick="javascript:window.location.href='forward?forwardPage=insert'">插入一条</a>
     <a class="btn btn-primary btn-lg" href="#" role="button" onclick="javascript:window.location.href='alluser'">查看全部</a></p>
     <a class="btn btn-primary btn-lg" href="#" role="button"  id="testre">testre</a></p>
     <a class="btn btn-primary btn-lg" href="#" role="button"  id="testmybatis"  onclick="javascript:window.location.href='forward?forwardPage=MybatisTestPage'">测试下Mybatis</a></p>
     
</div>
</div>
</div>

<!-- <button  name="findAll" onclick="javascript:window.location.href='forward?forwardPage=insert'">插入一条</button>
<button  name="findAll" onclick="javascript:window.location.href='alluser'">查看全部</button>


<button  name="ajax" id="ajax">AJAX</button> -->
<div class="row">
  <div class="col-xs-6 col-md-4">&nbsp;<span class="glyphicon glyphicon-play"></span>  <a class="btn btn-primary btn-lg" href="#" role="button" onclick="javascript:window.location.href='TestKey/ss'" class="btn btn-info">test没有变量名的</a>
  </div>
  <div class="col-xs-6 col-md-4"> <div class="input-group">

      <button   name="ajax" id="ajax" type="submit" class="btn btn-default"><span class="glyphicon glyphicon-fire"></span>AJAX</button> 
  <input type="text" name="pwd" id="flag" class="form-control" placeholder="test ajax!"></br>
  <a class="btn btn-primary btn-lg" href="#" role="button" onclick="javascript:window.location.href='testJson'">查看全部use  Json</a></p>
  <a class="btn btn-primary btn-lg" href="#" role="button" onclick="javascript:window.location.href='getJsonFromNet'">Json接收.net接口的数据</a></p>
  <table id="tbl">
  
  </table>
</div>

</div>
  <div class="col-xs-6 col-md-4"><div class="page-header">
  <h1> <small>这有一个</small>文件上传~</h1>
</div>
<form action="upload" method="post" enctype="multipart/form-data">
	文件名<input type="text" name="filename">
  <span class="glyphicon glyphicon-cloud-upload"></span>
    <span class="glyphicon glyphicon-cloud-upload"></span>
  <span class="glyphicon glyphicon-cloud-upload"></span>
    <span class="glyphicon glyphicon-cloud-upload"></span>
  <span class="glyphicon glyphicon-cloud-upload"></span>
<input type="file" name="file"/>  </br>
<button type="submit" class="btn btn-info">  <span class="glyphicon glyphicon-cloud-upload"></span>Submit</button>

</form>

  
  
  
  </div>
</div>
</body>
</html>