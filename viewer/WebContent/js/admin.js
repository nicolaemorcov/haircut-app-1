$(function() {
	$('#ajaxBtn')
			.click(
					function() {
						$
								.ajax({
									type : "POST",
									url : "/services/bookings",
									dataType : 'json',
									success : function(data) {
										var items = [];
										console.log(data.data.data);
										var bookings = data.data.data;
										$('.bookings').remove();
										var htmlTbl = "<tr><th>First Name</th><th>LastName</th><th>Email</th><th>Time</th><th>Service</th><th>Price</th>"
										$.each(bookings, function(key, val) {
											var booking = val;
							            	  var customer = booking.customer;
											
//											console.log(key);
//											console.log(val);
//											console.log(val.bookingTime);

											htmlTbl += "<tr><td>" + customer.firstName + "</td><td>" + customer.lastName + "</td></tr>";

										});
						
										$("#bookingTable").append(htmlTbl);
//										$('<ul/>', {
//											'class' : 'interest-list',
//											html : items.join('')
//										}).appendTo('body');

									},
								});
					});
});

// function showBookings(){
// $.getJSON( "http://localhost:8080/view/services", function( data ) {
//        
// });
// }
