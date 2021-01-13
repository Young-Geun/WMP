<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Choi's WEB</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
<script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script type="text/javascript">
	function callResult() {
		$.ajax({
		    url: '<c:url value="/" />',
		    type: 'POST',
		    cache: false,
		    dataType: 'json',
		    data: JSON.stringify({"url": $('#url').val(), "scope": $('#scope').val(), "unit": $('#unit').val()}),
	        contentType:'application/json; charset=utf-8',
		    success: function(data){
		    	if (data.msg != null) {
		    		alert(data.msg);
		    	} else {
		    		$('#quotientDiv').html(data.result.quotient);
		    		$('#remainderDiv').html(data.result.remainder);
		    	}
		    },		    
		    error: function (request, status, error){        
		    	alert('오류가 발생하였습니다.');
		    }
		});		
	}
</script>
</head>
<body>
	<table>
		<tr>
			<th>URL : </th>
			<td><input type="text" id="url" class="wid300"></td>
		</tr>
		<tr>
			<th>Type : </th>
			<td>
				<select id="scope">
					<option value="1">HTML 태그 제외</option>
					<option value="0">Text 전체</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>출력 묶음 단위 : </th>
			<td class="txt_right"><input type="text" id="unit" class="wid50"></td>
		</tr>
		<tr>
			<td colspan="2" class="btn">
				<input type="button" onclick="javascript: callResult();" value="출력">
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<th>몫 :</th>
			<td><div id="quotientDiv"></div></td>
		</tr>
		<tr>
			<th>나머지 :</th>
			<td><div id="remainderDiv"></div></td>
		</tr>
	</table>
</body>
</html>

