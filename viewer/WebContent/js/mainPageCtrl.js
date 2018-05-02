// function myFunction() {
//     document.getElementById("demo").innerHTML = "Paragraph changed.";
//  }
 
 function testFunction() {
     console.log("Hello World");
 }
 
 $(document).ready(function()    {
    console.log("Hello world from main files !")
    
//      $("#servicesBtn").click(function(){
          console.log("Testing jquery")
          $.get("/services/bookings", function(data) {
//              console.log(data);
              var bookings = data.data.data;
              console.log(bookings);
              $('.bookings').remove();
              var trHTML = '';
              $.each(bookings, function(i, item) {
            	  var booking = item;
            	  var customer = booking.customer;
            	  
            	  var service = booking.service;
            	  
//                  console.log(item.bookingTime)
                  trHTML += '<tr class="bookings"><td>' + customer.firstName + '</td>'
                  + '<td>' + customer.lastName + '</td>'
                  +  '<td>' + customer.email + '</td>'
                  +  '<td>' + booking.bookingTime + '</td>'
                  +  '<td>' + service.serviceName + '</td>'
                  +  '<td>&#163; ' + service.servicePrice + '</td></tr>';
              })
              $('#bookings').append(trHTML);
          });
//      });
 });