$(document).ready(function() {
    $("#login_frm").submit(function() {
        var name = " ";
        var pass = "";
        $('.error').hide();
        $("#links_left").removeClass().text('Validando existencia del Usuario ').fadeIn(1000);
        name = $("input#url").val();
        pass = $("input#pass").val();
        this.timer = setTimeout(function() {
            $.ajax({
                url: 'JSP/controlador.jsp',
                data: 'un=' + $('#url').val() + '&pw=' + $('#pass').val(),
                type: 'post',
                success: function(msg) {
                    if ('ERROR'!==$.trim(msg)) // Message Sent, check and redirect
                    {				// and direct to the success page
                        $("#links_left").html('Login Verificado, entrando.....').fadeTo(900, 1,
                                function()
                                {
                                    //redirect to secure page
                                    document.location = 'JSP/session/login.jsp?user=' + msg;
                                });

                    }
                    else
                    {
                        $("#links_left").fadeTo(200, 0.1, function() //start fading the messagebox
                        {
                            //add message and change the class of the box and start fading
                            $(this).html('Verifique si los datos son correctos.').removeClass().addClass('myerror').fadeTo(900, 1);
                        });

                    }
                }

            });
        }, 200);
        return false;

    });
});

