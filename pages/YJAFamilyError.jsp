<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>YJA Family | Gallery</title>
	<meta charset="utf-8" />
	<link rel="stylesheet" href="styles/reset.css" type="text/css" />
	<link rel="stylesheet" href="styles/elegant-press.css" type="text/css" />
	<script src="scripts/elegant-press.js" type="text/javascript"></script>
	<script src="scripts/yjaFamily.js" type="text/javascript"></script>
</head>
<body>
	<!-- Including the common header screen -->
	<s:include value="YJAHeader.jsp">
		<s:param name="loginBtn">false</s:param>	
		<s:param name="menuDisplay">true</s:param>
	</s:include>	
	<div class="main-container">
		<div class="container1">			
			<div class="errbox">
				<img class="errimage" src="<s:url value="images/error.jpg"/>" />
				<br class="clear" />
			</div>
		</div>
	</div>	
	<s:include value="YJAFooter.jsp"></s:include>
</body>
</html>
