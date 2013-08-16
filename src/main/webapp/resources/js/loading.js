//$('#preloader')
//    .hide()  // hide it initially
//    .ajaxStart(function() {
//        $(this).show();
//    })
//    .ajaxStop(function() {
//        $(this).hide();
//    })
//;

jQuery.ajaxSetup({
	  beforeSend: function() {
	     $('#loader').show();
	  },
	  complete: function(){
	     $('#loader').hide();
	  },
	  success: function() {}
	});

$("body").on({
    ajaxStart: function() { 
        $(this).addClass("loading"); 
    },
    ajaxStop: function() { 
        $(this).removeClass("loading"); 
    }    
});