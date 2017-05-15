<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
</head>
<body>
<h1> Personal Worker Details </h1>

	<div class="container">

		<div class="starter-template">
			 <b>WorkerName :   </b>${workerName}</br>
			<b>Proffession :   </b>${workerProffession} </br> 
			<b>Rate :   </b>${workerRate} </br> 
			<b>Availablity :   </b>${workerAvailablity} </br> 
			<b>MobileNumber :   </b>${MobileNumber} </br> 
			<b>Email :   </b>${workerEmail} </br> 
			<b>PhoneNumber :   </b>${workerPhoneNumber} </br>
			<b>Address :   </b>${workerAddress} </br>
			<b>City :   </b>${workerCity} </br>
			<b>District :   </b>${workerDistrict} </br>
			<b>State :   </b>${workerState} </br>

		</div>
	</div>
	<div style ="display:inline-block;"> 
		<li style ="display:inline-block;"><a  class="btn btn btn-warning"  href="/addWorkerDetails" >Add Contact.. </a></li>
		<li style ="display:inline-block;"><a  class="btn btn-primary" href="/register">Home/Worker Details .. </a></li>
	</div>
	
</body>

</html>
