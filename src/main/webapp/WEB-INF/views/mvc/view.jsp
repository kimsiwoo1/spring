<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${cp }/js/jquery-3.4.1.min.js"></script>
<script>
	$(document).ready(function(){
		$('#pathBtn').on('click', function(){
			var subpath = $("input[name=path]:checked").val();
			$("#frm").attr("action", "${cp}/mvc/path/" + subpath);
			$('#frm').submit();
		})
	})
</script>
</head>
<body>
	<h2>mvc/view.jsp</h2>
	
	<form action="${cp }/mvc/requestParam" method="post">
		userId : <input type="text" name="userId" value="sally"/><br>
		<input type="submit" value="전송"/>
	</form>
	
	<h3>pathvariable</h3>
	<form id="frm">
		<input type="radio" name="path" value="brown" checked="checked"/>ㅂ<br>
		<input type="radio" name="path" value="sally"/>ㅅ<br>
		<input type="button" id="pathBtn"value="전송"/>
	</form>
</body>
</html>