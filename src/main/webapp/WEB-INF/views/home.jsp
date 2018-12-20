<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <jsp:include page="/WEB-INF/templates/fragments/header.jsp">

        <jsp:param name="title" value="LandingPage" />

    </jsp:include>
    
    

</head>

<body>
	<form id="playerSubmissionForm">
		<input type="text" value="First Name" id="firstName"/>
		<input type="text" value="Last Name" id="lastName"/>
		<input type="button" value="GO!" onclick="doAjaxPost();" />
		<div id="subViewDiv"></div>
	</form>
	
	<script type="text/javascript">
    function doAjaxPost(){
    	var firstName = $("#firstName").val();
    	var lastName = $("#lastName").val();
    	$.ajax({
    		type: 'post',
    		url: 'savePlayer',
    		data: {"firstName" : firstName, "lastName": lastName},
    		success: function(response){
    			$('#subViewDiv').html( response );
    		},
    		error: function(jqxhr, status, exception) {
    			alert('Exception:', jqxhr);
    		}
    	});
    }
    </script>
	
	<ul class="nav nav-tabs">
	  <li class="active"><a data-toggle="tab" href="#home">Home</a></li>
	  <li><a data-toggle="tab" href="#menu1">Menu 1</a></li>
	  <li><a data-toggle="tab" href="#menu2">Menu 2</a></li>
	</ul>

<div class="tab-content">
  <div id="home" class="tab-pane fade in active">
    <jsp:include page="/WEB-INF/views/allplayers.jsp">

        <jsp:param name="title" value="LandingPage" />

    </jsp:include>
  </div>
  <div id="menu1" class="tab-pane fade">
    <h3>Menu 1</h3>
    <p>Some content in menu 1.</p>
  </div>
  <div id="menu2" class="tab-pane fade">
    <h3>Menu 2</h3>
    <p>Some content in menu 2.</p>
  </div>
</div>


<h3>Test</h3>


</body>

</html>