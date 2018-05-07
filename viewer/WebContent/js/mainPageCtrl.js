// function myFunction() {
//     document.getElementById("demo").innerHTML = "Paragraph changed.";
//  }
 
 function testFunction() {
     console.log("Hello World");
 }
 
 $(document).ready(function()    {

     var selectedBookingId = null;
    console.log("Hello world from main files !")
    
//    $.get("/services", function(data) {
//              console.log(data);
////              var services = data.data.data;
////              $('.service').remove();
////              console.log(services)
////              var trHTML = '';
////              $.each(services, function(i, item) {
////                  console.log(item)
////                  trHTML += '<tr class="service"><td>' + item.name + '</td><td>' + item.price + '</td></tr>';
////              })
////              $('#services').append(trHTML);
//          });
    
//      $("#servicesBtn").click(function(){
          console.log("Testing jquery")
          $.get("/services/bookings", function(data) {
//              console.log(data);
              var bookings = data.data.data;
//              console.log(bookings);
              $('.bookings').remove();
              var trHTML = '';
              $.each(bookings, function(i, item) {
            	  var customer = item.customer;
//            	  var service = item.service;
            	  console.log(item)
            	  console.log(customer.firstName)
                  console.log(item.bookingTime)
                  console.log(item.status)
                  var dateDue = item.dateDue
                  console.log(dateDue)
                  trHTML += '<tr class="bookings" id="'+item.bookingId+'"><td>' 
                  + customer.firstName + '</td><td>' 
                  + customer.lastName + '</td><td>' 
                  + dateDue.date + '/' + dateDue.day + '</td><td>' 
                  + item.bookingTime + '</td><td>' 
                  + customer.email + '</td><td>' 
                  + item.status + '</td></tr>';
              })
              $('#bookings').append(trHTML);
          });
//      });


     //when clicking on tr, get its id
     $('table').on("click", ".bookings", function () {
         var bId = $(this).attr("id");
         console.log(bId);
         selectedBookingId = bId;
         var selected = $(this).hasClass("rowColor");
         $(this).removeClass("rowColor");
         
         $(this).addClass('rowColor');
         
//         if(selected)
//                 $(this).addClass("highlight");
//         else{
//         $(this).removeClass("highlight");
//         }
     })

    $(".servicesBtn").on("click", function(){

        var newStatus = $(this).attr("id");
        console.log("post ajax")

        if(selectedBookingId !== null) {
            $.post( "/services/bookings", 
            		{ bookingId: selectedBookingId, status: newStatus })
                .done(function( data ) {
                	// update table row, add a cloumn 
                    //whcih would say "completed" or canceled
                	
                });
        } else {
            alert( "you need to select a booking");
        }

        selectedBookingId = null;
//        $.ajax({
//        	  type: "POST",
//        	  url: url,
//        	  data: data,
//        	  success: success,
//        	  dataType: dataType
//        	});
    });
 });