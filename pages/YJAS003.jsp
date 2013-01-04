<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html lang="en">
<head>
<title>YJA Family | Reservation</title>
<meta charset="utf-8" />
<link rel="stylesheet" href="styles/reset.css" type="text/css" />
<link rel="stylesheet" href="styles/elegant-press.css" type="text/css" />
<link rel="stylesheet" href="styles/calendarControl.css" type="text/css" />
<script src="scripts/elegant-press.js" type="text/javascript"></script>
<script src="scripts/yjaFamily.js" type="text/javascript"></script>
<script src="scripts/yjaFamilyCalendar.js" type="text/javascript"></script>
<script type="text/javascript">

	function setDeletedSiteNo(siteNo) {
		document.forms[0].deletedSiteNo.value = siteNo;
		document.forms[0].action = "YJAS003Delete";
		document.forms[0].submit();
	}

	function changeTabMode(tabMode) {
		document.forms[0].tabMode.value = tabMode;
	}

</script>

</head>
<body>

	<s:form action="YJAS003Search" theme="simple" >	
	
		<s:hidden name="currentScreen" value="YJAS003BackInit" />
		<s:hidden name="deletedSiteNo"/>
		<s:hidden name="tabMode"/>	
		
		<!-- Including the common header screen -->
		<s:include value="YJAHeader.jsp">
			<s:param name="loginBtn">true</s:param>				
			<s:param name="menuDisplay">true</s:param>
			<s:param name="loginAction">YJAS007Init</s:param>
			<s:param name="active">3</s:param>	
		</s:include>
	
		<div class="main-container">
			<div class="container1">
				<div id="search">
					<h5>Searching Condition</h5>
					<div class="block">
						<table>
							<tr>
								<th><s:label for="rervationType" key="screen.rervationType" /></th>
							</tr>
							<tr>
								<td>
									<s:select headerKey="-1" headerValue="-------- All of types --------"
										list="reservationTypeList" listKey="key" listValue="value"
										name="selectedReservationType" id="rervationType" />									
								</td>
							</tr>
							<tr>
								<td>
									<s:submit value="Search" name="searchBtn" />
								</td>
							</tr>
						</table>
					</div>
					<div class="block">
						<table>
							<tr>
								<th><s:label for="arrivalDate" key="screen.arrivalDate" /></th>
								<td>
									<s:textfield name="arrivalDate" id="arrivalDate" size="22" readonly="true" onfocus="showCalendarControl(this);"/>									
								</td>
							</tr>
							<tr>
								<th><s:label for="night" key="screen.night" /></th>
								<td>									
									<s:textfield name="night" id="night" size="22" onblur="fnNumberCheck(this);"/>
								
								</td>
							</tr>							
						</table>
					</div>
					<div class="block last">
						<table>
							<tr>
								<th><s:label for="partySize" key="screen.partySize" /></th>
								<td>
									<s:textfield name="partySize" id="partySize" onblur="fnNumberCheck(this);"/>
								</td>
							</tr>
							<tr>
								<th><s:label for="serviceType" key="screen.serviceType" /></th>
								<td>
									<s:select headerKey="-1" headerValue="------ All of types ------"
										list="serviceTypeList" listKey="key" listValue="value" 
										name="selectedServiceType" id="serviceType" />
								</td>
							</tr>
						</table> 
					</div>
				</div>
				<br /> <br />

				<div class="box">
					<div class="content">
						<article class="tabs">	
											
						<s:if test='%{tabMode == "1"}'>
							<section class="current" onclick="changeTabMode('1');">
						</s:if>
						<s:else>
							<section onclick="changeTabMode('1');">
						</s:else>
								<h3>MAP</h3>
								<div class="reserve">
									<p class="camping">
										<img class="campmap" src="<s:property value="%{campMapFullPath}" />" alt="Camp Map"
											width="600" height="420"/>
											
										<s:iterator value="campSiteInfoList" status="campSiteLocationStatus">
											<s:if test="%{status == 0}">											
												<s:a href="#" onclick="openWin('YJAP001Init',%{siteNo}, %{campMapId}, 'insert');">
													<img src="<s:url value="images/campsite_avail.png"/>" style="z-index:2;left:<s:property value="%{campSiteLocationInfo.siteLeft}"/>px;top:<s:property value="%{campSiteLocationInfo.siteTop}"/>px;" title="SiteNo - <s:property value="%{siteNo}"/>"/>												
												</s:a>
											</s:if>
											<s:elseif test="%{status == 1}">
												<s:a href="#" onclick="openWin('YJAP001Init',%{siteNo}, %{campMapId}, 'select');">
													<img src="<s:url value="images/campsite_ongoing.png"/>" style="z-index:2;left:<s:property value="%{campSiteLocationInfo.siteLeft}"/>px;top:<s:property value="%{campSiteLocationInfo.siteTop}"/>px;"  title="SiteNo - <s:property value="%{siteNo}"/>"/>												
												</s:a>
											</s:elseif>
											<s:else>
												<s:a href="#" onclick="openWin('YJAP001Init',%{siteNo}, %{campMapId}, 'select');">
													<img src="<s:url value="images/campsite_unavail.png"/>" style="z-index:2;left:<s:property value="%{campSiteLocationInfo.siteLeft}"/>px;top:<s:property value="%{campSiteLocationInfo.siteTop}"/>px;"  title="SiteNo - <s:property value="%{siteNo}"/>"/>												
												</s:a>
											</s:else>										
										</s:iterator>
									</p>
									<br />
								</div>
								
							</section>
							
						<s:if test='%{tabMode == "2"}'>
							<section class="current" onclick="changeTabMode('2');">
						</s:if>
						<s:else>
							<section onclick="changeTabMode('2');">
						</s:else>							
								<h3>List</h3>
								<div class="reserve">
									<table class="table1">
										<thead>
											<tr>
												<th>Site No.</th>
												<th>Site Type</th>
												<th>Reserve</th>
												<th>Allowed people</th>
												<th>Picture</th>
											</tr>
										</thead>
									</table>
									<div class="scroller">
										<table class="table2">
											<tbody>
												<s:iterator value="campSiteInfoList" status="campSiteInfoStatus">												
													<tr>
														<td>
															<s:if test="%{status == 0}">											
																<s:a href="#" onclick="openWin('YJAP001Init',%{siteNo}, %{campMapId}, 'insert');">
																	<s:property value="%{siteNo}"/>
																</s:a>
															</s:if>
															<s:elseif test="%{status == 1}">
																<s:a href="#" onclick="openWin('YJAP001Init',%{siteNo}, %{campMapId}, 'select');">
																	<s:property value="%{siteNo}"/>
																</s:a>
															</s:elseif>
															<s:else>
																<s:a href="#" onclick="openWin('YJAP001Init',%{siteNo}, %{campMapId}, 'select');">
																	<s:property value="%{siteNo}"/>
																</s:a>
															</s:else>															
														</td>
														<td><s:property value="siteType" /></td>
														
														<td>
															<s:if test="%{status == 0}">											
																<img src="images/campsite_avail_table.png" alt="Avail"  title="Avail"/>
															</s:if>
															<s:elseif test="%{status == 1}">
																<img src="images/campsite_ongoing_table.png" alt="OnReserving"  title="On Reserving"/>
															</s:elseif>
															<s:else>
																<img src="images/campsite_unavail_table.png" alt="Unavail"  title="Unavail"/>
															</s:else>															
														</td>
														<td>
															<s:property value="partySize" />
														</td>
														<td>
															<s:iterator value="sitePhotoFullPathList" status="sitePhotoFullPathStatus">																													
																<!-- The pictures related to the picture displayed -->
																<a data-gal="prettyPhoto[gallery<s:property value="%{#campSiteInfoStatus.index}" />]" href="<s:property value="sitePhotoFullPathList[#sitePhotoFullPathStatus.index]"/>" title="Image <s:property value="%{#sitePhotoFullPathStatus.index + 1}" />">
																	<s:if test='%{#sitePhotoFullPathStatus.index == 0 }'>																		
																		<img src="<s:property value="sitePhotoFullPathList[#sitePhotoFullPathStatus.index]"/>" alt="Site Photo" width="50" height="37"/>
																	</s:if>
																</a>		
															</s:iterator>													
														</td>
													</tr>											
												</s:iterator>
											</tbody>
										</table>
									</div>
								</div>
							</section>
						<!-- 		
						<s:if test='%{tabMode == "3"}'>
							<section class="current" onclick="changeTabMode('3');">
						</s:if>
						<s:else>
							<section onclick="changeTabMode('3');">
						</s:else>
											
								<h3>Calendar</h3>
								<div class="calendar">
									<p>
										<s:submit type="button" action="#" name="prevBtn" id="prev" value="PREV" />
										<s:submit type="button" action="#" name="nextBtn" id="next" value="NEXT" />
									</p>
									<table class="table1">
										<thead>
											<tr>
												<th>Site No.</th>
												<th>10</th>
												<th>10</th>
												<th>10</th>
												<th>10</th>
												<th>10</th>
												<th>1</th>
												<th>10</th>
												<th>31</th>
												<th>31</th>
												<th>31</th>
											</tr>
										</thead>
									</table>
									<div class="scroller">
										<table class="table2">
											<tbody>
												<tr>
													<td>
														<s:a href="#" onclick="openWin('YJAP001Init',1, 'insert');">
															<s:property value="1"/>
														</s:a>
													</td>
													<td><img src="images/camping/campsite_avail_table.png" alt="Camp Map" /></td>
													<td><img src="images/camping/campsite_avail_table.png" alt="Camp Map" /></td>
													<td><img src="images/camping/campsite_disavail_table.png" alt="Camp Map" /></td>
													<td><img src="images/camping/campsite_avail_table.png" alt="Camp Map" /></td>
													<td><img src="images/camping/campsite_avail_table.png" alt="Camp Map" /></td>
													<td><img src="images/camping/campsite_disavail_table.png" alt="Camp Map" /></td>
													<td><img src="images/camping/campsite_disavail_table.png" alt="Camp Map" /></td>
													<td><img src="images/camping/campsite_avail_table.png" alt="Camp Map" /></td>
													<td><img src="images/camping/campsite_avail_table.png" alt="Camp Map" /></td>
													<td><img src="images/camping/campsite_avail_table.png" alt="Camp Map" /></td>
												</tr>																				
											</tbody>
										</table>
									</div>
									 	
								</div>								
							</section>-->
							<section></section>
						</article>
					</div>
					<div class="sidebar">
						<div class="subnav">
							<h5>Reservation</h5>
							<div id="topdiv">
							<ul>
								<s:iterator value="reservedInfoList" var="reservedInfo" status="reservedInfoStatus">									
									<li>
										<div class="leftSide">
										<s:a href="#" onclick="openWin('YJAP001Init',%{#reservedInfoStatus.index}, %{campMapId},'reserved')">
											Site No.<s:property value="reservedSiteNo" /> - <s:property value="reservedSitetype" />
										</s:a>
										</div>
										<div class="rightSide center">											
											<s:a href="#" onclick="setDeletedSiteNo(%{#reservedInfoStatus.index})">X</s:a>
										</div>
									</li>									
								</s:iterator>
							</ul>
							</div>
							<div id="bottomdiv">
								<p class="right">
									<s:if test='%{reservedInfoList == null || reservedInfoList.size() == 0}'>
																			
									</s:if>
									<s:else>
										<s:submit type="button" action="YJAS003DeleteAll" name="deleteBtn" value="Delete All" />
									</s:else>
								</p>
							</div>
						</div>						
						<div class="subnav2">
							<h5>Total Cost</h5>
							<table>
								<tr>
									<th>Cost :</th>
									<td><s:property value="costNotTax" /></td>
									<td rowspan="3">
									<s:if test='%{reservedInfoList == null || reservedInfoList.size() == 0}'>
										
									</s:if>
									<s:else>
										<s:submit type="button" action="YJAS003Detail" value="Detail" />
									</s:else>
								</tr>
								<tr>
									<th>HST :</th>
									<td><s:property value="tax" /></td>
								</tr>
								<tr>
									<th>Total:</th>
									<td><s:property value="costWithTax" /></td>
								</tr>
							</table>
							<p></p>
						</div>
						<div class="subnav1">					
							<table>
								<tr>
									<td width="10%">
										<img src="<s:url value="images/campsite_avail.png"/>" alt="CampAvail" />
									</td>
									<td width="10%">
										<img src="<s:url value="images/campsite_avail_table.png"/>" alt="CampUnAvail" />
									</td>
									<td>
										- Available
									</td>
								</tr>
								<tr>
									<td>
										<img src="<s:url value="images/campsite_ongoing.png"/>" alt="CampUnAvail" />
									</td>
									<td>
										<img src="<s:url value="images/campsite_ongoing_table.png"/>" alt="CampUnAvail" />
									</td>
									<td>
										- On Reserving now
									</td>
								</tr>
								<tr>
									<td>
										<img src="<s:url value="images/campsite_unavail.png"/>" alt="CampAvail" />
									</td>								
									<td>
										<img src="<s:url value="images/campsite_unavail_table.png"/>" alt="CampUnAvail" />
									</td>
									<td>
										- Unavailable
									</td>
								</tr>
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
