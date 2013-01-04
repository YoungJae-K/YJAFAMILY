<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>YJA Family | Create New Account</title>
	<meta charset="utf-8" />
	<link rel="stylesheet" href="styles/reset.css" type="text/css" />
	<link rel="stylesheet" href="styles/elegant-press.css" type="text/css" />
	<script src="scripts/elegant-press.js" type="text/javascript"></script>
	<script src="scripts/yjaFamily.js" type="text/javascript"></script>	
</head>
<body>

	<s:form action="YJAS008Register" theme="simple">
	
		<s:hidden name="currentScreen" />
		<!-- Including the common header screen -->
		<s:include value="YJAHeader.jsp">
			<s:param name="loginBtn">false</s:param>
			<s:param name="menuDisplay">true</s:param>
		</s:include>
		
		<div class="main-container">
			<div class="container1">			
				<div class="box">				
					<div class="newuserbar">
						<div class="subnav">
							<h5 class="center">Register New Account</h5><br />
							<table>
								<tr>
									<th><s:label for="userId" key="screen.userId" /></th>
									<td>
										<s:textfield name="userId" id="userId" size="35" maxLength="50"/>
										<s:submit type="button" action="YJAS008UserIdCheck" id="checkBtn" value="Check"/>
										<s:fielderror cssClass="error">
												<s:param>userId</s:param>
										</s:fielderror>
										<s:if test="hasActionMessages()">
										   <div class="message">
										      <s:actionmessage/>
										   </div>
										</s:if>
									</td>
								</tr>
								<tr>
									<th><s:label for="userPassword" key="screen.userPassword" /></th>
									<td>
										<s:password name="userPassword" id="userPassword" size="35" maxLength="30"/>
										<s:fielderror cssClass="error">
												<s:param>userPassword</s:param>
										</s:fielderror>
									</td>
								</tr>
								<tr>
									<th><s:label for="reUserPassword" key="screen.reUserPassword" /></th>
									<td><s:password name="reUserPassword" id="reUserPassword" size="35"/>
										<s:fielderror cssClass="error">
												<s:param>reUserPassword</s:param>
										</s:fielderror>
									</td>
								</tr>
								<tr>
									<th><s:label for="userFName" key="screen.userFName" /></th>
									<td>
										<s:textfield name="userFName" id="userFName" size="35"  maxLength="30"/>
										<s:fielderror cssClass="error">
												<s:param>userFName</s:param>
										</s:fielderror>
									</td>
								</tr>
								<tr>
									<th><s:label for="userLName" key="screen.userLName" /></th>
									<td>
										<s:textfield name="userLName" id="userLName" size="35"  maxLength="30"/>
										<s:fielderror cssClass="error">
												<s:param>userLName</s:param>
										</s:fielderror>
									</td>
								</tr>
								<tr>
									<th><s:label for="userAddr" key="screen.userAddr" /></th>
									<td>
										<s:textfield name="userAddr" id="userAddr" size="35"  maxLength="45"/>
										<s:fielderror cssClass="error">
												<s:param>userAddr</s:param>
										</s:fielderror>
									</td>
								</tr>
								<tr>
									<th><s:label for="userCity" key="screen.userCity" /></th>
									<td><s:textfield name="userCity" id="userCity" size="35"  maxLength="20"/>
										<s:fielderror cssClass="error">
												<s:param>userCity</s:param>
										</s:fielderror>
									</td>								
								</tr>	
								<tr>
									<th><s:label for="userProv" key="screen.userProv" /></th>
									<td><s:textfield name="userProv" id="userProv" size="35"  maxLength="20"/>
										<s:fielderror cssClass="error">
												<s:param>userProv</s:param>
										</s:fielderror>
									</td>									
								</tr>
								<tr>
									<th><s:label for="userPost" key="screen.userPost" /></th>
									<td><s:textfield name="userPost" id="userPost" size="35"  maxLength="6"/>
										<s:fielderror cssClass="error">
												<s:param>userPost</s:param>
										</s:fielderror>
									</td>									
								</tr>					
							</table>
							<br />	
							<div class="center">
								<p>
									<s:submit value="Register" key="registerSubmitBtn"/>									
									<s:reset value=" Reset " key="resetBtn"/>								
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
