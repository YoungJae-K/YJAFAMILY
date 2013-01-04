/**
 * YJA Family Project Camping site Reservation System
 */

// Getting window instance
var w = window;

/**
 * Opens the Pop-up window
 * 
 * @param urlStr 		URL of Popup screen
 * @param siteNo		The camp site No. to display
 * @returns {Boolean}
 */
function openWin(urlStr, siteNo, campMapId, screenMode) {
	
	var left = (screen.width/2)-(520/2);
	var top = (screen.height/2)-(520/2);
			
	if ((w == window) || w.closed) {
		w = window.open(urlStr + "?siteNo=" + siteNo + "&campMapId=" + campMapId + "&screenMode=" + screenMode, 
				"Popup", 
				"location=no,directories=0,fullscreen=1,toolbar=no,status=no,menubar=no,scrollbars=yes,resizable=no,width=520,height=520,"
				+ "top=" + top + ",left=" + left);
	} else {
		w.focus();
	}
	
	return (false);
}

/**
 * Closes the Pop-up window
 */
function closeWin() {
	
	if (!w.closed) {
		w.close();
	}
}

/**
 * Calculates the position that mouse clicked.
 * This function is used when Administrator register the location of 
 * each camp site over the entire camp map.
 * 
 * @param event
 */
function calImgPosition(event){
	pos_x = event.offsetX?(event.offsetX):event.pageX-document.getElementById("campmap").offsetLeft;
	pos_y = event.offsetY?(event.offsetY):event.pageY-document.getElementById("campmap").offsetTop;
	document.getElementById("imageA1").style.left = (pos_x) ;
	document.getElementById("imageA1").style.top = (pos_y) ;
	document.getElementById("imageA1").style.visibility = "visible" ;
	document.pointform.form_x.value = pos_x;
	document.pointform.form_y.value = pos_y;
}

/**
 * This function is executed when SINGIN button is clicked,
 * 
 * @param formVar
 * @param actionUrl
 * @returns {Boolean}
 */
function goLogin(formVar, actionUrl) {
	
	formVar.action = actionUrl;
	formVar.submit();
	return true;
}

/**
 * Checks if the value inputed is number or not.
 * 
 * @param obj
 * @returns {Boolean}
 */
function fnNumberCheck(obj) {
    if (/^[^1-9]/g.test(obj.value) || /[^0-9]/g.test(obj.value)) {
	    alert("You must enter positive integer");	       
        obj.value = "";
        obj.focus();
        return false;
    }

    return true;
}


