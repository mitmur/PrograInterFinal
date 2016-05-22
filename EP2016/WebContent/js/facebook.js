            (function(d,s,id) {  
                var js, fjs = d.getElementsByTagName(s)[0];  
                if(d.getElementById(id)) return;  
                js = d.createElement(s); js.id = id;  
                js.src = "http://connect.facebook.net/en_US/sdk.js";  
                fjs.parentNode.insertBefore(js, fjs);  
            }(document, 'script', 'facebook-jssdk'));  
  
            window.fbAsyncInit = function() {  
                FB.init({  
                    appId : '830578323715278',  
                    cookie : true,  
                    xfbml : true,  
                    version : 'v2.6'  
                });  
            }  
  
            function ingresar() {  
                FB.login(function(response){  
                    validarUsuario();  
                }, {scope: 'public_profile, email'});  
            }  
            function validarUsuario() {  
                FB.getLoginStatus(function(response) {  
                    if(response.status == 'connected') {  
                        FB.api('/me', function(response) {  
                            alert('Hola ' + response.name); 
                            location="index.jsp"; 
                        });
                        
                    } else if(response.status == 'not_authorized') {  
                        alert('Debes autorizar la app!');  
                    } else {  
                        alert('Debes ingresar a tu cuenta de Facebook!');  
                    }  
                }); 
                function logout() {
                    FB.logout(function(response) {
                      // user is now logged out
                    	
                    });
                    location="login.jsp";
                }
           }  
  
       