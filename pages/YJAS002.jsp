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
	<s:form action="YJAS002Init" theme="simple">
	
		<s:hidden name="currentScreen" value="YJAS002Init" />
	
		<!-- Including the common header screen -->
		<s:include value="YJAHeader.jsp">
			<s:param name="loginBtn">true</s:param>	
			<s:param name="menuDisplay">true</s:param>
			<s:param name="loginAction">YJAS007Init</s:param>	
			<s:param name="active">2</s:param>	
		</s:include>	
		
		<div class="main-container">
			<div class="container1">	
				<h1>Headline: Gallery Page</h1>
				<div id="gallery" class="box">
					<!-- The pictures related to the picture displayed -->
					<ul>
						<s:iterator value="imageFullPathList" status="imageFullPathListStatus">	
						<s:if test='%{(#imageFullPathListStatus.index + 1)%3 == 0 }'>																		
							<li class="last">
						</s:if>
						<s:else>
							<li>
						</s:else>							
								<a data-gal="prettyPhoto[gallery2]" href="<s:property value="imageFullPathList[#imageFullPathListStatus.index]"/>" title="Image <s:property value="%{#imageFullPathListStatus.index + 1}" />">
									<img src="<s:property value="imageFullPathList[#imageFullPathListStatus.index]"/>" alt="Gallery Photo" width="260" height="190" />
								</a>
							</li>	
						</s:iterator>	
					</ul>
					<br class="clear" />
				</div><br />
				<div class="clear"></div>
			</div>
		</div>
	</s:form>
	<s:include value="YJAFooter.jsp"></s:include>
</body>
</html>
