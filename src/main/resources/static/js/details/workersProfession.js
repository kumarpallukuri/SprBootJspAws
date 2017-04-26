
var handles = ["SELECT Proffession","AC Repair","Carpenter","laptop Repair","Electrician","Geyser Repair","House Cleaning","Water Proofing","Plumber","Pest Control","Painting","Refrigerator Repair","Washing Machine Repair","Water Tank Cleaning","House Constructor","Driver"];

$(function() {
  var options = '';
  for (var i = 0; i < handles.length; i++) {
      options += '<option value="' + handles[i] + '">' + handles[i] + '</option>';
  }
  $('#proffession').html(options);
});

  
