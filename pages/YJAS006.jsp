<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>YJA Family | Contact</title>
	<meta charset="utf-8" />
	<link rel="stylesheet" href="styles/elegant-press.css" type="text/css" />
	<script src="scripts/elegant-press.js" type="text/javascript"></script>
	<script src="scripts/yjaFamily.js" type="text/javascript"></script>
</head>
<body>

	<s:form action="YJAS006Send" theme="simple" >
	
		<s:hidden name="currentScreen" value="YJAS006BackInit" />
	
		<!-- Including the common header screen -->
		<s:include value="YJAHeader.jsp">
			<s:param name="loginBtn">true</s:param>		
			<s:param name="menuDisplay">true</s:param>
			<s:param name="loginAction">YJAS006GoLogin</s:param>
			<s:param name="active">4</s:param>
		</s:include>
		
		<div class="main-container">
			<div class="container1">		
				<div class="box">
					<div class="content">
						<h1>Contact YJA Family</h1>					
						<p>
							<s:textfield name="userFullName" id="userFullName" size="30" /> 
							<s:label for="userFullName" key="screen.userFullName" />
							
							<s:fielderror cssClass="error">
									<s:param>userFullName</s:param>
							</s:fielderror>
						</p>
						<br />
						<p>
							<s:textfield name="userId" id="userId" size="30" /> 
							<s:label for="userId" key="screen.userId" />
							<s:fielderror cssClass="error">
									<s:param>userId</s:param>
							</s:fielderror>			
						</p>
						<br />
						<p>	
							<s:label for="comments" key="screen.comments" />
							<s:fielderror cssClass="error">
									<s:param>comments</s:param>
							</s:fielderror>	
						</p>
						<p>
							<s:textarea name="comments" id="comments" rows="10" cols="100"></s:textarea>										
						</p>
						<p>
							<s:submit name="submitBtn" value="Submit Form" /> &nbsp; 
							<s:reset name="resetBtn" value="Reset Form" />							
						</p>					
					</div>
	
					<div class="sidebar">					
						<div class="subnav">
							<h5>Follow YJA!</h5>
							<ul>
								<li><s:a href="#">Facebook</s:a></li>
								<li><s:a href="#">Blog</s:a></li>
								<li><s:a href="#">Linkedin</s:a></li>
							</ul>
						</div>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			<div class="main-container"></div>
		</div>
	</s:form>
	
	<s:include value="YJAFooter.jsp"></s:include>
	
</body>
</html>
