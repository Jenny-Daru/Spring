<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
<!-- jQyery 라이브러리 사용 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<%-- handlebars : JSON 형식의 JavaScript 객체를 전달받아 HTML 코드로 변환하는 기능을 제공하는 템플릿 라이브러리 --%>
<%-- => https://cdnjs.com 사이트에서 handlesbars 라이브러리를 포함하여 사용 --%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.6/handlebars.min.js"></script>
</head>
<body>
	<h1>handlebars</h1>
	<hr />
	<div id="display"></div>
	
	<%-- 템플릿 코드(HTML) 작성 --%>
	<%-- JavaScript 객체 이용 방법 => ${{propertyName}} 형식으로 속성값을 출력 --%>
	<!-- 요로게 변환시켜쥬세요 -->
	<script id="template1" type="text/x-handlebars-template">
	<ul>
		<li>아이디 = {{id}}</li>
		<li>이름 = {{name}}</li>
		<li>주소 = {{address}}</li>
	</ul>
	</script>
	
	<%-- 회원목록 출력 --%>
	<%--{{#each.}} {{/each}} 표현식을 이용하여 Array 객체에 대한 요소의 반복 처리 --%>
	<script id="template2" type="text/x-handlebars-template">
	<ul>
		{{#each.}}
		<li>아이디 = {{id}}, 이름 = {{name}}, 주소 = {{address}}</li>
		{{/each}}
	</ul>
	</script>
	
	<script type="text/javascript">
	/*
		//템플릿 코드를 반환받아 저장
		var source=$("#template1").html();
		//템플릿 코드를 전달하여 템플릿 객체를 생성하여 저장
		var template=Handlebars.compile(source);
		//JSON 형식에 JavaScript 객체를 생성하여 저장
		var data={"id":"Daru", "name":"꿈다루", "address":"융져니 하우스"};
		//템플릿 객체에 JavaScript 객체를 제공하여 HTML 코드로 변환하여 출력		
		$("#display").html(template(data));
	*/
	
		var source=$("#template2").html();
		var template=Handlebars.compile(source);
		var data=[
					{"id":"Daru", "name":"꿈다루", "address":"융져니 하우스"}
					,{"id":"Jenny", "name":"융제니", "address":"꿈다루 하우스"}
					,{"id":"Choding", "name":"서초딩", "address":"헬뜌댱"}
				 ];
		$("#display").html(template(data));
		
	</script>
	

</body>
</html>














