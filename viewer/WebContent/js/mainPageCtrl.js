// function myFunction() {
//     document.getElementById("demo").innerHTML = "Paragraph changed.";
//  }
 
 function testFunction() {
     console.log("Hello World");
 }
 
 $(document).ready(function()    {
    console.log("Hello world from main files !")
    
    $.get("/services", function(data) {
              console.log(data);
//              var services = data.data.data;
//              $('.service').remove();
//              console.log(services)
//              var trHTML = '';
//              $.each(services, function(i, item) {
//                  console.log(item)
//                  trHTML += '<tr class="service"><td>' + item.name + '</td><td>' + item.price + '</td></tr>';
//              })
//              $('#services').append(trHTML);
          });
    
      $("#servicesBtn").click(function(){
          console.log("Testing jquery")
          $.get("/services/bookings", function(data) {
              console.log(data);
//              var services = data.data.data;
//              $('.service').remove();
//              console.log(services)
//              var trHTML = '';
//              $.each(services, function(i, item) {
//                  console.log(item)
//                  trHTML += '<tr class="service"><td>' + item.name + '</td><td>' + item.price + '</td></tr>';
//              })
//              $('#services').append(trHTML);
          });
      });
 });