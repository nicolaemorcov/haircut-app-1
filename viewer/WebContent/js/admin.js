// function ShowBookings() {
//     var bookings = [
//         {
//             "Booking ID": "1",
//             "Customer ID": "22",
//             "Service ID": "101",
//             "Price": "17",
//             "Date booked": "2018-04-22",
//             "Date due": "2018-04-29",
//             "Time": "10:20"
//         },
//         {
//             "Booking ID": "2",
//             "Customer ID": "25",
//             "Service ID": "108",
//             "Price": "22",
//             "Date booked": "2018-04-17",
//             "Date due": "2018-04-30",
//             "Time": "13:00"
//         },
//         {
//             "Booking ID": "3",
//             "Customer ID": "14",
//             "Service ID": "103",
//             "Price": "13",
//             "Date booked": "2018-04-25",
//             "Date due": "2018-04-27",
//             "Time": "9:40"
//         },
//     ];

//     // EXTRACT VALUE FOR HTML HEADER. 
//     // ('Booking ID', 'Customer ID', 'Service ID', 'Price', "Date booked", "Date Due", "Time")
//     var col = [];
//     for (var i = 0; i < bookings.length; i++) {
//         for (var key in bookings[i]) {
//             if (col.indexOf(key) === -1) {
//                 col.push(key);
//             }
//         }
//     }

//     // CREATE DYNAMIC TABLE.
//     var table = document.createElement("table");

//     // CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.

//     var tr = table.insertRow(-1);                   // TABLE ROW.

//     for (var i = 0; i < col.length; i++) {
//         var th = document.createElement("th");      // TABLE HEADER.
//         th.innerHTML = col[i];
//         tr.appendChild(th);
//     }

//     // ADD JSON DATA TO THE TABLE AS ROWS.
//     for (var i = 0; i < bookings.length; i++) {

//         tr = table.insertRow(-1);

//         for (var j = 0; j < col.length; j++) {
//             var tabCell = tr.insertCell(-1);
//             tabCell.innerHTML = bookings[i][col[j]];
//         }
//     }

//     // FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
//     var divContainer = document.getElementById("showData");
//     divContainer.innerHTML = "";
//     divContainer.appendChild(table);
// }

function showBookings(){
    $.getJSON( "http://localhost:8080/view/services", function( data ) {
        
    });
}