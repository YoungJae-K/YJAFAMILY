<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html lang="en">
<head>
<title>YJA Family | Home</title>
<meta charset="UTF-8" />
<link rel="stylesheet" href="styles/reset.css" type="text/css" />
<link rel="stylesheet" href="styles/elegant-press.css" type="text/css" />
<script src="scripts/elegant-press.js" type="text/javascript"></script>
<script src="scripts/yjaFamily.js" type="text/javascript"></script>

</head>
<body>
	
	<s:form action="YJAS001Init" theme="simple" >
	
		<s:hidden name="currentScreen" value="YJAS001Init" />	
		
		<!-- Including the common header screen -->
		<s:include value="YJAHeader.jsp">
			<s:param name="loginBtn">true</s:param>			
			<s:param name="menuDisplay">true</s:param>
			<s:param name="loginAction">YJAS007Init</s:param>
			<s:param name="active">1</s:param>
		</s:include>		
	
		<div class="main-container">
			<div class="container1">
				<div id="mySlides">
					<div id="slide1">			
						<img src="<s:url value="images/01.jpg"/>" alt="Slide 1 jFlow Plus" /> <span><b
							class="slideheading">With your family</b></span>
					</div>
					<div id="slide2">
						<img src="<s:url value="images/02.jpg"/>" alt="Slide 2 jFlow Plus" /> <span><b
							class="slideheading">With your lover</b></span>
					</div>
					<div id="slide3">
						<img src="<s:url value="images/03.jpg"/>" alt="Slide 3 jFlow Plus" /> <span><b
							class="slideheading">With your friends</b></span>
					</div>
				</div>
	
				<div id="myController">
					<span class="jFlowControl"></span> <span class="jFlowControl"></span>
					<span class="jFlowControl"></span>
				</div>
	
				<section class="jFlowPrev">
					<div></div>
				</section>
				<section class="jFlowNext">
					<div></div>
				</section>
				<br /> <br />
	
				<article class="box" id="home_featured21">
					<div class="block">
						<h2>Who is YJAFamily</h2>
						<p>
							YJAFamliy means the YoungJae Kim's Family. YJA word has been created by the first letter of 
							YoungJae, JeongEun and Arvin. YoungJae is me, who developed this site, and JeongEun is my wife.
							Finally, Arvin is cute my son.<s:property value="login"/> 
						</p>
					</div>
					<div class="block">
						<h2>Compatibility</h2>
						<img src="images/browsers.png" alt="Web Browsers" /> <br /> <br />
						<ul id="list">
							<li>Dapiensociis temper donec auctortortis cumsan et
								curabitur.</li>
							<li>Condis lorem loborttis leo.</li>
							<li>Portortornec condimenterdum eget consectetuer condis.</li>
							<li>Puruselit mauris nulla hendimentesque elit semper nam a
								sapien urna sempus.</li>
						</ul>
	
					</div>
					<div class="block last">
						<h2>What YJAFamily Do</h2>
						<p>
							Temperinte interdum sempus odio urna eget curabitur semper
							convallis nunc laoreet. Nullain convallis ris elis vest liberos
							nis diculis feugiat in rutrum. Suspendreristibulumfaucibulum
							lobortor quis tortortor ris sapien sce enim et volutpat sus.
							Urnaretiumorci orci fauctor leo justo nulla cras ridiculum eu id
							vitae.
						</p>
					</div>
					<div class="clear"></div>
				</article>
	
			</div>
			<br /> <br />
		</div>
	</s:form>
	<s:include value="YJAFooter.jsp"></s:include>
	
</body>
</html>
