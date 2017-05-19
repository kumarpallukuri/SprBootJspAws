<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

