<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.yja.constant.YJACommonConst" %>

	<s:set name="userInfo" value="#session.userInfo"/>
	<s:set name="active">${param.active}</s:set>
	<s:set name="menuDisplay">${param.menuDisplay}</s:set>
	<s:set name="loginAction">${param.loginAction}</s:set>	
	
	<!--<s:form action="#" theme="simple">-->					
		<div class="main-container">
			<header>
				<h1>
					<s:a href="YJAS001Init">YJA Family</s:a>
				</h1>
				<p id="tagline">
					<strong>Camping Site Reservation</strong>
				</p>
			</header>
		</div>
		<div class="main-container">
			<div id="sub-headline">
				<div class="tagline_left">
					<p id="tagline2">					
						Tel: 647-384-6552 | Mail: <s:a href="mailto:dudwo88@gmail.com">dudwo88@gmail.com</s:a>
					</p>
				</div>
				<div class="tagline_right">					
					<s:if test="%{#userInfo != null}">						
						Welcome to <span class="username"><s:property value="%{#userInfo.userFullName}"/></span>
						<s:a href="YJAS007Logout">Logout</s:a>									
					</s:if>
					<s:else>
						<s:set name="loginBtn">${param.loginBtn}</s:set>
						<s:if test='%{#loginBtn == "true"}'>
							<s:submit type="button" name="signInSubmit" id="signIn" value="SIGN IN" onclick='goLogin(this.form, "%{#loginAction}");'/>
							<p>
								Create New Account here?
							</p>							
						</s:if>												
					</s:else>
				</div>
				<br class="clear" />
			</div>
		</div>
		
		<s:if test='%{#menuDisplay == "true"}'>	
			<div class="main-container">
				<div id="nav-container">
					<nav>
						<ul class="nav">
						<s:if test='%{#active == "1"}'>	
							<li class="active">
						</s:if>
						<s:else>
							<li>
						</s:else>
								<s:a href="YJAS001Init">Homepage</s:a>
							</li>							
						<s:if test='%{#active == "2"}'>	
							<li class="active">
						</s:if>
						<s:else>
							<li>
						</s:else>
								<s:a href="YJAS002Init">Gallery</s:a>
							</li>							
						<s:if test='%{(#active == "3") }'>	
							<li class="active">
						</s:if>
						<s:else>
							<li>
						</s:else>
								<s:a href="#">Reservation</s:a>
								<ul>
									<li><s:a href="YJAS003Init">New</s:a></li>
									<li><s:a href="YJAS005Init">Modify</s:a></li>
								</ul>
							</li>
						<s:if test='%{#active == "4"}'>	
							<li class="active">
						</s:if>
						<s:else>
							<li>
						</s:else>
								<s:a href="YJAS006Init">Contact</s:a>
							</li>
							<li><s:a href="#">Admin</s:a></li>
						</ul>
					</nav>
					<div class="clear"></div>
				</div>
			</div>
		</s:if>
	<!-- </s:form> -->