function myFunction() {
   document.getElementById("demo").innerHTML = "Paragraph changed.";
}

function testFunction() {
	console.log("Hello World");
}

$(document).ready(function()    {
	$("#displayButton").click(function(){
		console.log("Testing jquery")
	    $.get("/view/services", function(data, status) {
	    	console.log(data);
	    	var services = data.data.data;
	    	$('.service').remove();
	    	console.log(services)
	    	var trHTML = '';
	    	$.each(services, function(i, item) {
	    		console.log(item)
	    		trHTML += '<tr class="service"><td>' + item.name + '</td><td>' + item.price + '</td></tr>';
	    	})
	    	$('#services').append(trHTML);
	    });
	});
});
