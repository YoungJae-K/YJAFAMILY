<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.yja.constant.YJACommonConst" %>

<!DOCTYPE html>

<html lang="en">
<head>
<title>YJA Family | Reserve Information</title>
<meta charset="utf-8" />
<link rel="stylesheet" href="styles/reset.css" type="text/css" />
<link rel="stylesheet" href="styles/elegant-press.css" type="text/css" />
<script src="scripts/elegant-press.js" type="text/javascript"></script>
<script src="scripts/yjaFamily.js" type="text/javascript"></script>
<script type="text/javascript">

	function selectAction(btntype) {
		if(btntype == 1) {			
			window.opener.location = "YJAP001Select?partySize=" + document.forms[0].partySize.value;			
		}
		
	    window.close();
	    return false;
	}

</script>


</head>
<body>

	<s:form action="YJAP001Select" theme="simple" >
	<s:set var="siteInfo" value="campSiteInfo" />
	<s:hidden name="campMapId" />
	<div class="main-container">
		<div class="popup_container">
			<div class="box">			
				<h6>Site No.<s:property value="#siteInfo.siteNo"/> - <s:property value="#siteInfo.siteType"/></h6>
				<div class="image_block">
					<div class="block">
						<table>
							<tr>							
								<s:iterator value="#siteInfo.sitePhotoFullPathList" status="sitePhotoFullPathStatus">																													
									<td>
										<a data-gal="prettyPhoto[gallery1]" href="<s:property value="#siteInfo.sitePhotoFullPathList[#sitePhotoFullPathStatus.index]"/>" title="Image <s:property value="%{#sitePhotoFullPathStatus.index}" />">
											<img src="<s:property value="#siteInfo.sitePhotoFullPathList[#sitePhotoFullPathStatus.index]"/>" alt="Site Photo"  width="50" height="37"/>
										</a>
									</td>									
								</s:iterator>							
							</tr>
						</table>
					</div>
					<div class="block_last">						
						<s:if test="%{screenMode == 'insert'}">
							<s:label for="partySize" value="Party Size" title="Enter the number of people who will stay this site"/>
							<s:select list="peopleList" name="partySize" id="partySize" />	
						</s:if>
						<s:elseif test="%{screenMode == 'reserved'}">
							<s:label for="partySize" value="Reserved Party" title="Enter the number of people who will stay this site"/>
							<s:textfield name="partySize" size="5" readonly="true"/>	
						</s:elseif>	
					</div>					
							
					<br />
				</div>			
				<div class="site_block">
					<table class="table1">
						<thead>							
							<tr>
								<th>Site Type</th>
								<td><s:property value="#siteInfo.siteType"/></td>
							</tr>
							<tr>
								<th>Service Type</th>
								<td><s:property value="#siteInfo.serviceType"/></td>
							</tr>							
							<tr>
								<th>Cost</th>
								<td>$<s:property value="#siteInfo.cost"/></td>
							</tr>
							<!-- Allowed Equipment -->
							<tr>
								<th>Allowed Equipment</th>
								<td><s:property value="#siteInfo.allowedEquipment"/></td>
							</tr>						
							<tr>
								<th>Site Lenth(m)</th>
								<td><s:property value="#siteInfo.siteLenth"/></td>
							</tr>
							<tr>
								<th>Site Width(m)</th>
								<td><s:property value="#siteInfo.siteWidth"/></td>
							</tr>
							<tr>
								<th>On-Site Vehicle Parking</th>
								<td><s:property value="#siteInfo.onSiteParking"/></td>
							</tr>
							<tr>
								<th>Off-Site Vehicle Parking</th>
								<td><s:property value="#siteInfo.offSiteParking"/></td>
							</tr>
							<tr>
								<th>Allowed People</th>
								<td><s:property value="#siteInfo.partySize"/></td>
							</tr>
							<tr>
								<th>Extra People Cost</th>
								<td><s:property value="#siteInfo.extraPeopleCost"/></td>
							</tr>
						</thead>
					</table>
					<br />
				</div>
				
				<div class="center">
					<p>	
						<s:if test="%{screenMode == 'insert'}">
							<s:submit type="button" name="selectBtn" onclick="return selectAction(1);" value=" Select " />
						</s:if>
						<s:submit type="button" name="cancelBtn" onclick="return selectAction(2);" value=" Cancel " />
					</p>	
				</div>
				
				<div class="clear"></div>		
			</div>		
		</div>		
	</div>
	</s:form>	
</body>
</html>
