
var proffessional = ["Select Profession","AC Repair","Carpenter","laptop Repair","Electrician","Geyser Repair","House Cleaning","Water Proofing","Plumber","Pest Control","Painting","Refrigerator Repair","Washing Machine Repair","Water Tank Cleaning",
	"House Constructor","Driver","Tailor","Other"];

$(function() {
  var options = '';
  for (var i = 0; i < proffessional.length; i++) {
	  if(proffessional[i] === "Select Profession"){
		  options += '<option value="">' + proffessional[i] + '</option>';
	  }else{
		  options += '<option value="' + proffessional[i] + '">' + proffessional[i] + '</option>';
	  }
  }
  $('#proffession').html(options);
});


var availabilty = ["Day","Day&Night","WeekEnds only"];
  

$(function() {
	  var options = '';
	  for (var i = 0; i < availabilty.length; i++) {
	      options += '<option value="' + availabilty[i] + '">' + availabilty[i] + '</option>';
	  }
	  $('#workersavailabilty').html(options);
	});

var paymentMode = ["Cash","Online","NA"];


$(function() {
	  var options = '';
	  for (var i = 0; i < paymentMode.length; i++) {
	      options += '<option value="' + paymentMode[i] + '">' + paymentMode[i] + '</option>';
	  }
	  $('#workersPaymentMode').html(options);
	});


var rateDropdown = ["Day","Week","Month"];
  

$(function() {
	  var options = '';
	  for (var i = 0; i < rateDropdown.length; i++) {
	      options += '<option value="' + rateDropdown[i] + '">' + rateDropdown[i] + '</option>';
	  }
	  $('#rateDropdown').html(options);
	});