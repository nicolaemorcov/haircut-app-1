$(document).ready(function(){
    $("#login").click(function(){
    var email = $("#email").val();
    var password = $("#password").val();
    console.log("post Ajax blia");
    // Checking for blank fields.
    if( email =='' || password ==''){
    $('input[type="text"],input[type="password"]').css("border","2px solid red");
    $('input[type="text"],input[type="password"]').css("box-shadow","0 0 3px red");
    alert("Please fill all fields...!!!!!!");
    }else {
        $.POST( "/auth/login", 
            		{ email: email, password: password })
                .done(function( data ) {
                    console.log("I'm in hibernet");
                	// update table row, add a cloumn 
                    //whcih would say "completed" or canceled
                	
                });


    }
    });
    });