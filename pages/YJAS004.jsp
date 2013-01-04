<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>YJA Family | Reserve Information</title>
<meta charset="utf-8" />
<link rel="stylesheet" href="styles/reset.css" type="text/css" />
<link rel="stylesheet" href="styles/elegant-press.css" type="text/css" />
<script src="scripts/elegant-press.js" type="text/javascript"></script>
<script src="scripts/yjaFamily.js" type="text/javascript"></script>

</head>
<body>

	<s:form action="YJAS004Confirm" theme="simple">
	
		<s:hidden name="currentScreen" value="YJAS004BackInit" />
		<s:set name="reservedInfo" value="#session.reservedInfo"/>
		<!-- Including the common header screen -->
		<s:include value="YJAHeader.jsp">
			<s:param name="loginBtn">true</s:param>	
			<s:param name="menuDisplay">false</s:param>
			<s:param name="loginAction">YJAS004GoLogin</s:param>
			<s:param name="active">3</s:param>
		</s:include>
		
		<div class="main-container">
			<div class="container1">
				<div class="box">
					<h1 class="center">Reserve Information Details</h1>
					<h6>Price Info</h6>
					<div id="priceInfo">
						<table class="table1">
							<thead>
								<tr>
									<th>Arrival Date</th>
									<th>Night</th>
									<th>Site No.</th>
									<th>Site Type</th>
									<th>Party Size</th>
									<th>Site Cost.</th>
									<th>Extra People Cost</th>
									<th>Total Cost</th>
								</tr>
							</thead>
						</table>
						<div class="scroller">							
							<table class="table2">
								<tbody>
									<s:iterator value="reservedInfo" status="reservedInfoStatus">
										<tr>
											<td><s:property value="arrivalDate" /></td>
											<td><s:property value="night" /></td>
											<td><s:property value="reservedSiteNo" /></td>
											<td><s:property value="reservedSitetype" /></td>
											<td><s:property value="partySize" /></td>
											<td>$<s:property value="campUnitCost" /></td>
											<td>$<s:property value="costForextraPeople" /></td>
											<td>$<s:property value="totalcost" /></td>									
										</tr>							
									</s:iterator>													
								</tbody>
							</table>
						</div>		
					</div>
					<br /><br />
					<div class="clear"></div>				
					<div id="equipInfo">					
						<div class="block">
							<h6>Extra Service you want</h6>
							<s:textarea name="extraService" rows="4" cols="65"></s:textarea>							
						</div>
											
						<div class="block">
							<h6>Total Cost</h6>
							<table class="table1">
								<thead>							
									<tr>
										<th>Total Cost(without TAX)</th>
										<td>
											$<s:property value="costNotTax" />
											<s:hidden name="costNotTax" />
										</td>
										
									</tr>
									<tr>
										<th>TAX</th>
										<td>
											$<s:property value="tax" />
											<s:hidden name="tax" />
										</td>
									</tr>
									<tr>
										<th>Total Cost(including of TAX)</th>
										<td>
											$<s:property value="costWithTax" />
											<s:hidden name="costWithTax" />
										</td>
									</tr>
								</thead>
							</table>						
						</div>	
						<div class="clear"></div>
					</div>
					<br /><br />
					
					<div id="reserveInfo">					
						<h6>Customer Information</h6>				
						<table>
							<tr>
								<th><s:label for="userLName" key="screen.userLName" /></th>
								<td>
									<s:textfield name="userLName" id="userLName" size="22" maxLength="30"/>
									<s:fielderror cssClass="error">
										<s:param>userLName</s:param>
									</s:fielderror>
								</td>
								<th><s:label for="userFName" key="screen.userFName" /></th>
								<td>
									<s:textfield name="userFName" id="userFName" maxLength="30"/>
									<s:fielderror cssClass="error">
										<s:param>userFName</s:param>
									</s:fielderror>
								</td>
								<th><s:label for="userPhoneNumber" key="screen.userPhoneNumber"  title="Format: 999-999-9999"/></th>
								<td>
									<s:textfield name="userPhoneNumber" id="userPhoneNumber" maxLength="20"/>
									<s:fielderror cssClass="error">
										<s:param>userPhoneNumber</s:param>
									</s:fielderror>
								</td>
							</tr>
							
							<tr>
								<th><s:label for="userAddress" key="screen.userAddress" /></th>
								<td colspan="3">
									<s:textfield name="userAddr" id="userAddress" size="75" maxLength="45"/>
									<s:fielderror cssClass="error">
										<s:param>userAddr</s:param>
									</s:fielderror>
								</td>
								<th><s:label for="userPost" key="screen.userPost" title="Format: M2M1Y2"/></th>
								<td>
									<s:textfield name="userPost" id="userPost" maxLength="60"/>
									<s:fielderror cssClass="error">
										<s:param>userPost</s:param>
									</s:fielderror>
								</td>
							</tr>
							<tr>
								<th><s:label for="userCity" key="screen.userCity" /></th>
								<td>
									<s:textfield name="userCity" id="userCity" size="35" maxLength="20"/>
									<s:fielderror cssClass="error">
										<s:param>userCity</s:param>
									</s:fielderror>
								</td>	
								<th><s:label for="userProv" key="screen.userProv" /></th>
								<td>
									<s:textfield name="userProv" id="userProv" size="35" maxLength="20"/>
									<s:fielderror cssClass="error">
										<s:param>userProv</s:param>
									</s:fielderror>
								</td>			
								<th><s:label for="userId" key="screen.userId" /></th>
								<td>
									<s:textfield name="reservedEmail" id="userId"  maxLength="50"/>
									<s:fielderror cssClass="error">
										<s:param>reservedEmail</s:param>
									</s:fielderror>
								</td>
							</tr>				
						</table>										
					</div>
					<br /><br />
					<div id="reservebtn">
						<p>
							<s:submit name="confirmBtn" value="Confirm" />
							<s:submit type="button" action="YJAS004Back"  name="backBtn" value=" Back " />
						</p>				
					</div>				
				</div>
			</div>
		</div>		
	 	
	</s:form>
	
	<s:include value="YJAFooter.jsp"></s:include>
	
</body>
</html>
