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
	<s:form action="YJAS007Login" theme="simple" validate="true">		
	
		<s:hidden name="currentScreen" />
		
		<!-- Including the common header screen -->
		<s:include value="YJAHeader.jsp">
			<s:param name="loginBtn">false</s:param>
			<s:param name="menuDisplay">true</s:param>			
		</s:include>
		
		<div class="main-container">
			<div class="container1">			
				<div class="box">				
					<div class="loginbar">	
						<div class="subnav">
							<h5 class="center">SIGN IN</h5><br />								
								<table>
									<tr>
										<th><s:label for="userId" key="screen.userId"/></th>
										<td>
											<s:textfield name="userId" key="userId" size="30" />
											<s:fielderror cssClass="error">
												<s:param>userId</s:param>
											</s:fielderror>
										</td>										
									</tr>
									<tr>
										<th><s:label for="userPassword" key="screen.userPassword"/></th>
										<td>
											<s:password name="userPassword" id="userPassword" value="" size="30"/>
											<s:fielderror cssClass="error">
												<s:param>userPassword</s:param>
											</s:fielderror>
										</td>
									</tr>							
								</table>
								<br />	
								<div class="center">
									<p>								
					            		<s:submit value="SIGNIN" key="signInsubmitBtn" />
										<s:reset value=" Reset " key="resetBtn"/>															
									</p>
									<br />
									<p>
										<s:a href="YJAS008Init.action" cssClass="underline">Create New Account</s:a>
									</p>
									<br />
									<p>
										<s:if test="hasActionErrors()">
										   <div class="errors">
										      <s:actionerror/>
										   </div>
										</s:if>
									</p>			
								</div>										
						</div>
							
					</div>
					<div class="clear"></div>
				</div>
	
				<br />
	
				<div class="clear"></div>
			</div>
		</div>	
	</s:form>	
	<s:include value="YJAFooter.jsp"></s:include>
	
</body>
</html>
