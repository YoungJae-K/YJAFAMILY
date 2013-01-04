<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>YJA Family | Reservation</title>
<meta charset="utf-8" />
<link rel="stylesheet" href="styles/reset.css" type="text/css" />
<link rel="stylesheet" href="styles/elegant-press.css" type="text/css" />
<script src="scripts/elegant-press.js" type="text/javascript"></script>
<script src="scripts/yjaFamily.js" type="text/javascript"></script>
<script type="text/javascript">
	function handleDeleteBtn() {
		var inputTags = document.getElementsByTagName('input');		
		var checkboxes = [];		
		
		for (var i=0, length = inputTags.length; i<length; i++) {
		     if (inputTags[i].getAttribute('type').toLowerCase() == 'checkbox') {
		    	 checkboxes.push(inputTags[i]);		    	
		     }
		}
		
		for(var i = 0; i < checkboxes.length; i++) {
			if (checkboxes[i].checked) {				
				document.forms[0].deleteBtn.disabled = false;
				return;
			}
		}
		document.forms[0].deleteBtn.disabled = true;
	}	
</script>
</head>
<body>

	<s:form action="YJAS005Search" theme="simple" >
	
		<s:hidden name="currentScreen" value="YJAS005BackInit" />
	
		<!-- Including the common header screen -->
		<s:include value="YJAHeader.jsp">
			<s:param name="loginBtn">true</s:param>			
			<s:param name="menuDisplay">true</s:param>
			<s:param name="loginAction">YJAS005GoLogin</s:param>
			<s:param name="active">3</s:param>
		</s:include>
		
		<div class="main-container">
			<div class="container1">
				<div id="search_mod">
					<h5>Searching Condition</h5>
					<table>
						<tr>
							<th>
								<s:label for="reservationId" key="screen.reservationId" />&nbsp;
								<s:textfield name="reservationId" id="reservationId" size="30" />
							</th>
							<th>
								<s:label for="userId"  key="screen.userId" />&nbsp;
								<s:textfield name="userId" id="userId" size="30"/>
							</th>					
							<td class="right">
								<s:submit value="Search" key="searchBtn" />
							</td>
						</tr>
					</table>
				</div>
				<div>
					<s:if test="hasActionErrors()">
					   <div class="error">
					      <s:actionerror/>
					   </div>
					</s:if>	
				<div>
				<br /> <br />				
				<div class="box">
					<div class="right">
						<p>						
							<s:submit type="button" name="deleteBtn" id="deleteBtn" action="YJAS005Cancel" value="Delete" disabled="true"/>					
						</p>
					</div>
					<br />		
					<div class="modify">
						<table class="table1">
							<thead>
								<tr>
									<th >&nbsp;</th>
									<th colspan="3">Reservation No</th>
									<th colspan="2">Arrival Date</th>
									<th colspan="2">Night</th>
									<th colspan="2">Site No.</th>
									<th colspan="2">Site Type</th>
									<th colspan="2">Party Size</th>
									<th colspan="2">Status</th>
									<th colspan="2">Cost(plus HST)</th>
								</tr>						
							</thead>
						</table>
						<div class="scroller">
							<table class="table2">
								<tbody>
									<s:iterator value="reservedInfoList" status="reservedInfoStatus">
										<tr>
											<td>
												<s:if test="%{enable}">
													<s:checkbox name="selectedReservationId[%{#reservedInfoStatus.index}]" id="selectedReservationId[%{#reservedInfoStatus.index}]" fieldValue="%{reservationId + '/' + reservedSiteNo + '/' + arrivalDate}" theme="simple" onclick="handleDeleteBtn(this);"/>
												</s:if>
												<s:else>
													<s:checkbox name="selectedReservationId[%{#reservedInfoStatus.index}]" id="selectedReservationId[%{#reservedInfoStatus.index}]" fieldValue="%{reservationId + '/' + reservedSiteNo + '/' + arrivalDate}" theme="simple" disabled="true"/>	
												</s:else>												
											</td>
											<td colspan="3"><s:property value="reservationId" /></td>
											<td colspan="2"><s:property value="arrivalDate" /></td>
											<td colspan="2"><s:property value="night" /></td>
											<td colspan="2"><s:property value="reservedSiteNo" /></td>
											<td colspan="2"><s:property value="reservedSitetype" /></td>									
											<td colspan="2"><s:property value="reservedPartySize" /></td>
											<td colspan="2"><s:property value="status" /></td>
											<td colspan="2">$<s:property value="totalcost" /></td>
										</tr>								
									</s:iterator>													
								</tbody>
							</table>
						</div>
					</div>
					<div class="clear"></div>
				</div>
	
			</div>
		</div>
	</s:form>
	<s:include value="YJAFooter.jsp"></s:include>
</body>
</html>
