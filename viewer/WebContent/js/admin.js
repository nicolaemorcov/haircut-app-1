$(function() {  
  $('#servicesAjax').click(function() {
       $.ajax({
       url: "/services/bookings",
       dataType: 'json',
       success: function(data) {
          var items = [];

          $.each(data, function(key, val) {
        	  console.log();

            items.push('<li id="' + key + '">' + val + '</li>');    

          });

          $('<ul/>', {
             'class': 'interest-list',
             html: items.join('')
          }).appendTo('body');

       },
      statusCode: {
         404: function() {
           alert('There was a problem with the server.  Try again soon!');
         }
       }
    });
  });
});

//function showBookings(){
//    $.getJSON( "http://localhost:8080/view/services", function( data ) {
//        
//    });
//}