$(document).ready(function() {
    $(".tab_content").hide();
    $(".tab_content:first").show();
    var funcion;
      
    $("ul.tabs li").click(function() {
        $("ul.tabs li").removeClass("active");
        $(this).addClass("active");
        $(".tab_content").hide();
        var activeTab = $(this).attr("rel");
        $("#" + activeTab).fadeIn();
    });
    
    $("#tab_2").click(function(){      
      $("#cont").html("<h3>Prueba</h3>");
    });
    
    $("#nav li").click(function(eve){
        $("#"+funcion).attr("class", "inactivo");
        funcion=$(this).data("option").name;
        $("#"+funcion).attr("class", "current");
        var jqxhr = $.ajax( "content/"+funcion+".jsp" )
        .done(function(msg) {
          $( "#cont" ).html( msg );
        })
        .fail(function() {
          $( "#cont" ).html("");
        })    
    });
});